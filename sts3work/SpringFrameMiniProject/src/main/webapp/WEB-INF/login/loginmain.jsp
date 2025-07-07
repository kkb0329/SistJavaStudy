<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="loginprocess" method="post">
  <table  class="table table-bordered" style="width: 300px;">
    <caption align="top"><b>회원로그인</b></caption>
    <tr>
      <th>아이디</th>
      <td>
        <input type="text" name="id" class="form-control"
        style="width: 150px;" required="required">
      </td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td>
        <input type="password" name="pass" class="form-control"
        style="width: 150px;" required="required">
      </td>
    </tr>
    
    <tr>
      <td colspan="2" align="center">
        <input type="submit" class="btn btn-info" value="로그인">
        <input type="button" class="btn btn-success" value="회원가입"
        onclick="location.href='../member/form'">
      </td>
    </tr>
  </table>
</form>
</body>
</html>