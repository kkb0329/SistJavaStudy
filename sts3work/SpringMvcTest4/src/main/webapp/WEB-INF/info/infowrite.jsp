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
  <h2>Info 폼 출력</h2>
  
  이름: ${infoDto.name }<br>
  퍼스널컬러: ${infoDto.color }<br>
  <div style="width: 30px; height: 30px; background-color: ${infoDto.color}"></div>
  취미:
  <c:if test="${empty infoDto.hobby }">없음</c:if>
  
  <c:if test="${!empty infoDto.hobby }">
     <c:forEach var="h" items="${infoDto.hobby }">
        [${h }]
     </c:forEach>
  </c:if>
  <br>
  가장 재미있는 언어: ${infoDto.lang }
</body>
</html>