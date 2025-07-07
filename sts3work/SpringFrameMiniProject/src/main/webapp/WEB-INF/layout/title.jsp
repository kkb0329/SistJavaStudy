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
<c:set var="root" value="<%=request.getContextPath() %>"/>
<body>
  <a href="${root }/">
     <img alt="" src="${root }/image/mainview/title.png">
     
  </a>
  <span>
 
     <c:if test="${sessionScope.loginok==null }">
        <button type="button" class="btn btn-success btn-sm"
        onclick="location.href='${root}/login/form'">Login</button>
     </c:if>
     
     <c:if test="${sessionScope.loginok!=null }">
       <b style="font-size: 10pt;">${sessionScope.myid }님이 로그인중입니다</b>
        <button type="button" class="btn btn-danger btn-sm"
        onclick="location.href='${root}/login/logoutprocess'">Logout</button>
     </c:if>
  </span>
  
  
</body>
</html>