package day0321;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day0319.DBConnect;

public class ShopTest {

	DBConnect db = new DBConnect();
	Scanner sc = new Scanner(System.in);
	String sql = "";

	// 사원 추가
	public void insert() {

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		System.out.println("음료 과자");
		String type = sc.nextLine();
		System.out.println("상품명");
		String sname = sc.nextLine();
		System.out.println("수량");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("단가");
		int dan = Integer.parseInt(sc.nextLine());

		sql = "INSERT INTO sales VALUES (seq_test.NEXTVAL,?,?,?,?,sysdate )";
		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, type);
			pstmt.setString(2, sname);
			pstmt.setInt(3, su);
			pstmt.setInt(4, dan);

			int n = pstmt.executeUpdate();

			if (n == 1) {
				System.out.println("sucess");
			} else {
				System.out.println("f");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// 사원 조회
	public void select() {
		Connection conn = db.getConnection();
		String sql = "select * from sales order by num asc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			System.out.println("번호\t카테고리\t상품명\t수량\t단가");
			System.out.println("=".repeat(60));
			while (rs.next()) {

				System.out.println("=".repeat(60));
				System.out.println(rs.getInt("num") + "\t" + rs.getString("type") + "\t" + rs.getString("sangpum")
						+ "\t" + rs.getInt("su") + "\t" + rs.getInt("dan"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}

	// 사원 정보 수정
	public void update() {
		System.out.println("수정할 번호를 입력하세요:");
		int num = Integer.parseInt(sc.nextLine());

		if (!isOneData(num)) {

			System.out.println("n");

			return;

		}

		System.out.println("새로운 타입을 입력하세요:");
		String type = sc.nextLine();
		System.out.println("새로운 상품명을 입력하세요:");
		String name = sc.nextLine();
		System.out.println("새로운 수량을 입력하세요:");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("새로운 단가를 입력하세요:");
		int dan = Integer.parseInt(sc.nextLine());

		sql = "UPDATE sawon SET type=?,sanpum=?,su=?,dan=?, WHERE num = " + num;
		System.out.println(sql);

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, type);
			pstmt.setString(2, name);
			pstmt.setInt(3, su);
			pstmt.setInt(4, dan);

			int a = pstmt.executeUpdate(sql);
			if (a == 0) {
				System.out.println("실패");
			} else {
				System.out.println("수정되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// 사원 삭제
	public void delete() {
		System.out.println("삭제할 번호를 입력하세요:");
		int num = Integer.parseInt(sc.nextLine());

		sql = "DELETE FROM sawon WHERE num = " + num;
		System.out.println(sql);

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			int n = pstmt.executeUpdate();

			if (n == 0) {
				System.out.println("해당 번호는 없습니다.");
			} else {
				System.out.println("삭제되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	public boolean isOneData(int num) {

		boolean b = false;

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		sql = " select * from sales where num=? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				b = true;

			} else {

				b = false;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	public void search() {
	    System.out.println("검색할 상품명을 입력하세요:");
	    String n = sc.nextLine();

	    // SQL 쿼리 수정 (LIKE 문법에 맞게 수정)
	    String sql = "SELECT * FROM sales WHERE sangpum LIKE ?";

	    System.out.println(sql);

	    Connection conn = db.getConnection();
	    ResultSet rs = null;
	    PreparedStatement pstmt = null;

	    try {
	        pstmt = conn.prepareStatement(sql);

	        // 사용자 입력 값 앞뒤로 '%'를 추가하여 패턴 검색
	        pstmt.setString(1, "%" + n + "%");

	        rs = pstmt.executeQuery();

	        // 결과 출력
	        System.out.println("번호\t카테고리\t상품명\t수량\t단가");
	        System.out.println("=".repeat(60));
	        while (rs.next()) {
	            System.out.println("=".repeat(60));
	            System.out.println(rs.getInt("num") + "\t" + rs.getString("type") + "\t" + rs.getString("sangpum")
	                    + "\t" + rs.getInt("su") + "\t" + rs.getInt("dan"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(rs, pstmt, conn);
	    }
	}


	
	
	public static void main(String[] args) {
		ShopTest sh = new ShopTest();
		Scanner sc = new Scanner(System.in);
		int n = 0;

		while (true) {
			System.out.println("1.추가   2.삭제  3.수정  4.재고출력  5.s 9.e");
			n = Integer.parseInt(sc.nextLine());

			if (n == 1) {
				sh.insert();
			} else if (n == 2) {
				sh.delete();
			} else if (n == 3) {
				sh.update();
			} else if (n == 4) {
				sh.select();
			} else if (n == 5) {

				sh.search();
				
			}

			else if (n == 9) {
				System.out.println("exit");
				break;
			}
		}
	}
}
