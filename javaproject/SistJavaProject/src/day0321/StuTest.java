package day0321;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import day0319.DBConnect;

public class StuTest {

    DBConnect db = new DBConnect();
    Scanner sc = new Scanner(System.in);
    String sql = "";

    // 학생 추가
    public void insert() {
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        System.out.println("학생 이름을 입력하세요:");
        String name = sc.nextLine();
        System.out.println("학생 주소를 입력하세요:");
        String addr = sc.nextLine();
        System.out.println("혈액형을 입력하세요:");
        String blood = sc.nextLine();
        System.out.println("학생 전화번호를 입력하세요:");
        String hp = sc.nextLine();
        System.out.println("학년을 입력하세요:");
        int grade = Integer.parseInt(sc.nextLine());
        System.out.println("나이를 입력하세요:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("생일을 입력하세요:");
        String birth = sc.nextLine();

        // 삽입 쿼리 수정
        sql = "INSERT INTO StuInfo (stu_no, stu_name, stu_addr, stu_blood, stu_hp, stu_grade, stu_age, birth, writeday) " +
              "VALUES (seq_StuInfo.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, sysdate)";
        System.out.println(sql);

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, addr);
            pstmt.setString(3, blood);
            pstmt.setString(4, hp);
            pstmt.setInt(5, grade);
            pstmt.setInt(6, age);
            pstmt.setString(7, birth);

            int n = pstmt.executeUpdate();

            if (n == 1) {
                System.out.println("성공적으로 추가되었습니다.");
            } else {
                System.out.println("추가 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    // 학생 조회
    public void select() {
        Connection conn = db.getConnection();
        String sql = "SELECT * FROM StuInfo ORDER BY stu_no ASC";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            System.out.println("번호\t이름\t주소\t혈액형\t전화번호\t학년\t나이\t생일\t입력날짜");
            
            while (rs.next()) {
                System.out.println("=".repeat(60));
                System.out.println(rs.getInt("stu_no") + "\t" + rs.getString("stu_name") + "\t" + rs.getString("stu_addr")
                        + "\t" + rs.getString("stu_blood") + "\t" + rs.getString("stu_hp") +
                        "\t" + rs.getInt("stu_grade") + "\t" + rs.getInt("stu_age") +
                        "\t" + rs.getString("birth") +
                        "\t" + rs.getDate("writeday"));
            }
            System.out.println("=".repeat(60));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
    }

    // 학생 정보 수정
    public void update() {
        System.out.println("수정할 학생 번호를 입력하세요:");
        int num = Integer.parseInt(sc.nextLine());

        // 해당 번호가 존재하는지 확인
        if (!isOneData(num)) {
            System.out.println("해당 번호는 존재하지 않습니다.");
            return;
        }

        // 수정할 정보 입력 받기
        System.out.println("새로운 학생 이름을 입력하세요:");
        String name = sc.nextLine();
        System.out.println("새로운 학생 주소를 입력하세요:");
        String addr = sc.nextLine();
        System.out.println("새로운 혈액형을 입력하세요:");
        String blood = sc.nextLine();
        System.out.println("새로운 전화번호를 입력하세요:");
        String hp = sc.nextLine();
        System.out.println("새로운 학년을 입력하세요:");
        int grade = Integer.parseInt(sc.nextLine());
        System.out.println("새로운 나이를 입력하세요:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("새로운 생일을 입력하세요:");
        String birth = sc.nextLine();

        // 수정 쿼리
        sql = "UPDATE StuInfo SET stu_name = ?, stu_addr = ?, stu_blood = ?, stu_hp = ?, stu_grade = ?, stu_age = ?, birth = ? " +
              "WHERE stu_no = ?";
        System.out.println(sql);

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, name);
            pstmt.setString(2, addr);
            pstmt.setString(3, blood);
            pstmt.setString(4, hp);
            pstmt.setInt(5, grade);
            pstmt.setInt(6, age);
            pstmt.setString(7, birth);
            pstmt.setInt(8, num);

            int n = pstmt.executeUpdate();
            if (n == 0) {
                System.out.println("수정 실패");
            } else {
                System.out.println("수정되었습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    // 학생 삭제
    public void delete() {
        System.out.println("삭제할 학생 번호를 입력하세요:");
        int num = Integer.parseInt(sc.nextLine());

        // 삭제 쿼리
        sql = "DELETE FROM StuInfo WHERE stu_no = ?";
        System.out.println(sql);

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);

            int n = pstmt.executeUpdate();

            if (n == 0) {
                System.out.println("해당 번호는 존재하지 않습니다.");
            } else {
                System.out.println("삭제되었습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(pstmt, conn);
        }
    }

    // 특정 학생 데이터 존재 확인
    public boolean isOneData(int num) {
        boolean b = false;

        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        sql = "SELECT * FROM StuInfo WHERE stu_no = ?";

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
            e.printStackTrace();
        }

        return b;
    }

    // 학생 검색
    public void search() {
        System.out.println("검색할 학생 이름을 입력하세요:");
        String n = sc.nextLine();

        // SQL 쿼리 수정 (LIKE 문법에 맞게 수정)
        String sql = "SELECT * FROM StuInfo WHERE stu_name LIKE ?";

        System.out.println(sql);

        Connection conn = db.getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);

            // 사용자 입력 값 앞뒤로 '%'를 추가하여 패턴 검색
            pstmt.setString(1, n + "%");

            rs = pstmt.executeQuery();

            // 결과 출력
            System.out.println("번호\t이름\t주소\t혈액형\t전화번호\t학년\t나이\t생일\t입력날짜");
            System.out.println("=".repeat(60));
            while (rs.next()) {
                System.out.println("=".repeat(60));
                System.out.println(rs.getInt("stu_no") + "\t" + rs.getString("stu_name") + "\t" + rs.getString("stu_addr")
                        + "\t" + rs.getString("stu_blood") + "\t" + rs.getString("stu_hp") +
                        "\t" + rs.getInt("stu_grade") + "\t" + rs.getInt("stu_age") +
                        "\t" + rs.getString("birth") +
                        "\t" + rs.getDate("writeday"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.dbClose(rs, pstmt, conn);
        }
    }

    public static void main(String[] args) {
        StuTest st = new StuTest();
        Scanner sc = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.println("1.학생정보 입력    2.학생정보 출력    3.학생정보 삭제    4.학생정보 수정    5.학생검색  9.종료");
            n = Integer.parseInt(sc.nextLine());

            if (n == 1) {
                st.insert();
            } else if (n == 2) {
                st.select();
            } else if (n == 3) {
                st.delete();
            } else if (n == 4) {
                st.update();
            } else if (n == 5) {
                st.search();
            } else if (n == 9) {
                System.out.println("종료");
                break;
            }
        }
    }
}
