<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrhttp://localhost:8080/summer/cat/form3ap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="process3" method="post">
    <table class="table table-bordered" style="width: 400px;">
      <tr>
        <th width="150px">이름</th>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <th>자바점수</th>
        <td><input type="text" name="java"></td>
      </tr>
      <tr>
        <th>스프링점수</th>
        <td><input type="text" name="spring"></td>
      </tr>
      <tr>
        <th>오라클점수</th>
        <td><input type="text" name="oracle"></td>
      </tr>
    </table>
    <button type="submit">전송</button>
  </form>
</body>
</html>