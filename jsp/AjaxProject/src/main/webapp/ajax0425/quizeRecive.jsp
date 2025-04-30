<%@ page import="java.sql.SQLException"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="oracle.db.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // 클라이언트로부터 음식과 점수 파라미터 받기
    String food = request.getParameter("food");
    String score = request.getParameter("score");

    // DB 연결 설정
    DbConnect db = new DbConnect();
    Connection conn = db.getConnecton();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from mymall order by num"; // SQL 쿼리

    try {
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        JSONArray arr = new JSONArray();

        while (rs.next()) {
            String num = rs.getString("num");
            String sangpum = rs.getString("sangpum");
            String color = rs.getString("color");
            String price = rs.getString("price");
            String imagename = rs.getString("imagename");

            JSONObject ob = new JSONObject();
            ob.put("num", num);
            ob.put("sangpum", sangpum);
            ob.put("color", color);
            ob.put("price", price);
            ob.put("imagename", imagename);
            ob.put("food", food);  // 요청받은 음식 정보 추가
            ob.put("score", score); // 요청받은 점수 정보 추가

            arr.add(ob); // JSON 배열에 객체 추가
        }
        // JSON 배열을 HTML로 출력
        out.print(arr.toString()); // JSON 형식으로 데이터 출력
    } catch (SQLException e) {
        e.printStackTrace(); // 예외 처리
    } finally {
        db.dbClose(rs, pstmt, conn);  // DB 자원 반납
    }
%>


