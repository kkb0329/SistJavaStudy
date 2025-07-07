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

  <h2>상품정보출력</h2>

<div  style="color: ${sangpumDto.color}" >
   상품명: ${sangpumDto.sangpum }<br>
   가격:   <fmt:formatNumber value="${sangpumDto.price }" type="currency"/> <br>
   수량:  <fmt:formatNumber value="${sangpumDto.su }" pattern="#,##0"/><br>
   총금액: <fmt:formatNumber value="${sangpumDto.price*sangpumDto.su}" type="currency"/>
</div>
  
</body>
</html>