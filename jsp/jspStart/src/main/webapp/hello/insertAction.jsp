<%@page import="hello.HelloDao"%>
<%@page import="hello.HelloDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

    String irum=request.getParameter("name");
    String juso=request.getParameter("addr");
    String hp=request.getParameter("hp");
    
    //입력데이타 dto로 묶어서
    HelloDto dto=new HelloDto();
    
    dto.setName(irum);
    dto.setAddr(juso);
    dto.setHp(hp);
    
    //insert메서드에 전달
    HelloDao dao=new HelloDao();
    dao.insertHello(dto);
    
    //목록으로 이동
    response.sendRedirect("helloList.jsp");
%>
</body>
</html>