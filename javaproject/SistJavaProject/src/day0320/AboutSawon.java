package day0320;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day0319.DBConnect;

public class AboutSawon {

    DBConnect db = new DBConnect();
    Scanner sc = new Scanner(System.in);
    String sql = "";

    // 사원 추가
    public void insertSawon() {
        System.out.println("splus");
        System.out.println("사원명");
        String name = sc.nextLine();
        System.out.println("성별");
        String gender = sc.nextLine();
        System.out.println("부서");
        String buseo = sc.nextLine();
        System.out.println("급여");
        int pay = Integer.parseInt(sc.nextLine());

        sql = "INSERT INTO sawon VALUES (seq_sawon.NEXTVAL, '" + name + "', '" + gender + "', '" + buseo + "', " + pay + ")";
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
        String sql="select num,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon order by num";
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("번호\t이름\t성별\t부서\t급여");
            while (rs.next()) {
                int num = rs.getInt("num");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String buseo = rs.getString("buseo");
                String pay = rs.getString("pay");

                System.out.println("=".repeat(60));
                System.out.println(num + "\t" + name + "\t" + gender + "\t" + buseo + "\t" + pay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, stmt, conn);
        }
    }

    // 사원 정보 수정
    public void updateSawon() {
        System.out.println("수정할 사원의 번호를 입력하세요:");
        int num = Integer.parseInt(sc.nextLine());

        System.out.println("새로운 사원명을 입력하세요:");
        String name = sc.nextLine();
        System.out.println("새로운 성별을 입력하세요:");
        String gender = sc.nextLine();
        System.out.println("새로운 부서를 입력하세요:");
        String buseo = sc.nextLine();
        System.out.println("새로운 급여를 입력하세요:");
        int pay = Integer.parseInt(sc.nextLine());

        sql = "UPDATE sawon SET name = '" + name + "', gender = '" + gender + "', buseo = '" + buseo + "', pay = " + pay + " WHERE num = " + num;
        System.out.println(sql);

        Connection conn = db.getConnection();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            int rowsUpdated = stmt.executeUpdate(sql);
            if (rowsUpdated == 0) {
                System.out.println("해당 번호의 사원이 없습니다.");
            } else {
                System.out.println("사원 정보가 수정되었습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(stmt, conn);
        }
    }

    // 사원 삭제
    public void deleteSawon() {
        System.out.println("삭제할 사원의 번호를 입력하세요:");
        int num = Integer.parseInt(sc.nextLine());

        sql = "DELETE FROM sawon WHERE num = " + num;
        System.out.println(sql);

        Connection conn = db.getConnection();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            int rowsDeleted = stmt.executeUpdate(sql);
            if (rowsDeleted == 0) {
                System.out.println("해당 번호의 사원이 없습니다.");
            } else {
                System.out.println("사원이 삭제되었습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(stmt, conn);
        }
    }
    
    
    public void search() {
	
    	
    	System.out.println("검색할 사원의 성을 입력하세요:");
        String n = sc.nextLine();

        //sql = "SELECT * FROM sawon WHERE name LIKE '" + n + "%'";
        sql="select num,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon WHERE name LIKE '" + n + "%'";

        System.out.println(sql);

        Connection conn = db.getConnection();
        ResultSet rs = null;
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("번호\t이름\t성별\t부서\t급여");
            while (rs.next()) {
                int num = rs.getInt("num");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String buseo = rs.getString("buseo");
                String pay = rs.getString("pay");

                System.out.println("=".repeat(60));
                System.out.println(num + "\t" + name + "\t" + gender + "\t" + buseo + "\t" + pay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, stmt, conn);
        }
    }
    	
	

    public static void main(String[] args) {
        AboutSawon as = new AboutSawon();
        Scanner sc = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.println("1.i   2.s  3.u  4.d  5.s 9.e");
            n = Integer.parseInt(sc.nextLine());

            if (n == 1) {
                as.insertSawon();
            } else if (n == 2) {
                as.select();
            } else if (n == 3) {
                as.updateSawon();
            } else if (n == 4) {
                as.deleteSawon();
            }else if (n == 5) {
                as.search();
            } 
            
            else if (n == 9) {
                System.out.println("exit");
                break;
            }
        }
    }
}
