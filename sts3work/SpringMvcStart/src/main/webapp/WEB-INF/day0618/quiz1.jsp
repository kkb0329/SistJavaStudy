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
  <h2> ${stuName }</h2>
  <h2> ${title }</h2>
  <br><br>
  <h3>리소스 이미지</h3>
  <img alt="" src="../../res/toy01.png" width="200">
  <img alt="" src="../../res/image1/icon02.png">
  <h3>WEB-INF 이미지</h3>
  <img alt="" src="../../image/user.png">
  <img alt="" src="../../image/shop/shoe02.png">
</body>
</html>