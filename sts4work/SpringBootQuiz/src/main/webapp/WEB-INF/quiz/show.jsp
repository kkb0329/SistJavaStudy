<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<style type="text/css">
  img {
	  width: 100px;
	  height: 100px;
	  border: 2px solid green;
	  border-radius: 20px;
	  margin-right: 20px;
}
</style>
</head>
<body>
  <h3 class="alert alert-danger">
     음식명: ${quizDto.fname }<br>
     음식가격:${quizDto.fprice }<br><br>
     <c:if test="${quizDto.fphoto==null }">
        이미지없음
     </c:if>
     <c:if test="${quizDto.fphoto!=null }">
        <c:forEach var="a" items="${quizDto.fphoto }">
            <img alt="" src="../image/Food/${a }.jpg" >
        </c:forEach>
     </c:if>
  </h3>
</body>
</html>