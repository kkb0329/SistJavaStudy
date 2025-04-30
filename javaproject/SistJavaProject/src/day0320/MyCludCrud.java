package day0320;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day0319.DBConnect;

public class MyCludCrud {

	DBConnect db = new DBConnect();
	Scanner sc = new Scanner(System.in);
	String sql = "";

	public void insertClud() {
		System.out.println("회원가입 ");
		System.out.println("이름");
		String cname = sc.nextLine();
		System.out.println("주소");
		String cadress = sc.nextLine();
		System.out.println("직급");
		String cposition = sc.nextLine();
		System.out.println("번호");
		String cph = sc.nextLine();
		System.out.println("회비");
		int fee = Integer.parseInt(sc.nextLine());

		sql = "INSERT INTO myclub VALUES (seq_club.NEXTVAL, '" + cname + "', '" + cadress + "', '" + cposition + "', '"
				+ cph + "', " + fee + "," + "DEFAULT)";
		System.out.println(sql);

		Connection conn = db.getConnection();
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("sucess");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}

	// 사원 조회
	public void select() {
		Connection conn = db.getConnection();
		String sql = "select cno,cname,caddress,cposition,cph,to_char(fee,'L999,999,999') fee,gaipday from myclub order by cno";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("회원번호\t회원이름\t주소\t직급\t전화번호\t회비\t가입일");
			while (rs.next()) {
				int cno = rs.getInt("cno");
				String cname = rs.getString("cname");
				String caddress = rs.getString("caddress");
				String cposition = rs.getString("cposition");
				String cph = rs.getString("cph");
				String fee = rs.getString("fee");
				Date gaipday = rs.getDate("gaipday");

				System.out.println("=".repeat(60));
				System.out.println(cno + "\t" + cname + "\t" + caddress + "\t" + cposition + "\t" + cph + "\t" + fee
						+ "\t" + gaipday);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
	}

	// 사원 정보 수정
	public void update() {
		System.out.println("수정할 사원의 번호를 입력하세요:");
		int cno = Integer.parseInt(sc.nextLine());

		System.out.println("새로운 회원명을 입력하세요:");
		String cname = sc.nextLine();
		System.out.println("새로운 주소를 입력하세요:");
		String caddress = sc.nextLine();
		System.out.println("새로운 직급을 입력하세요:");
		String cposition = sc.nextLine();
		System.out.println("새로운 번호를 입력하세요:");
		String cph = sc.nextLine();
		System.out.println("새로운 급여를 입력하세요:");
		int fee = Integer.parseInt(sc.nextLine());

		sql = "UPDATE myclub SET cname = '" + cname + "', caddress = '" + caddress + "', cposition = '" + cposition
				+ "', cph = '" + cph + "', fee = " + fee + " WHERE cno = " + cno;
		System.out.println(sql);

		Connection conn = db.getConnection();
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			int rowsUpdated = stmt.executeUpdate(sql);
			if (rowsUpdated == 0) {
				System.out.println("해당 번호의 회원이 없습니다.");
			} else {
				System.out.println("회원 정보가 수정되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}

	// 사원 삭제
	public void delete() {
		System.out.println("삭제할 회원의 번호를 입력하세요:");
		int cno = Integer.parseInt(sc.nextLine());

		sql = "DELETE FROM myclub WHERE cno = " + cno;
		System.out.println(sql);

		Connection conn = db.getConnection();
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			int rowsDeleted = stmt.executeUpdate(sql);
			if (rowsDeleted == 0) {
				System.out.println("해당 번호의 회원이 없습니다.");
			} else {
				System.out.println("회원이 삭제되었습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}

	// 클럽 회원 검색
	public void search() {
		System.out.println("검색할 회원의 이름을 입력하세요:");
		String cname = sc.nextLine(); // 회원 이름 검색

		// SQL 쿼리 수정: 이름으로 검색
		sql = "SELECT cno, cname, caddress, cposition, cph, TO_CHAR(fee, 'L999,999,999') fee, gaipday "
				+ "FROM myclub WHERE cname LIKE '" + cname + "%'"; // 부분 매칭 검색

		System.out.println(sql);

		Connection conn = db.getConnection();
		ResultSet rs = null;
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("회원번호\t회원이름\t주소\t직급\t전화번호\t회비\t가입일");
			while (rs.next()) {
				int cno = rs.getInt("cno");
				String name = rs.getString("cname");
				String address = rs.getString("caddress");
				String position = rs.getString("cposition");
				String ph = rs.getString("cph");
				String fee = rs.getString("fee");
				Date gaipday = rs.getDate("gaipday");

				System.out.println("=".repeat(60));
				System.out.println(
						cno + "\t" + name + "\t" + address + "\t" + position + "\t" + ph + "\t" + fee + "\t" + gaipday);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
	}

	public static void main(String[] args) {
		MyCludCrud as = new MyCludCrud();
		Scanner sc = new Scanner(System.in);
		int n = 0;

		while (true) {
			System.out.println("1.회원가입     2.전체회원출력    3.회원정보수정     4.회원삭제  5.검색    9.종료");
			n = Integer.parseInt(sc.nextLine());

			if (n == 1) {
				as.insertClud();
			} else if (n == 2) {
				as.select();
			} else if (n == 3) {
				as.update();
			} else if (n == 4) {
				as.delete();
			} else if (n == 5) {
				as.search();
			}

			else if (n == 9) {
				System.out.println("exit");
				break;
			}
		}
	}
}
