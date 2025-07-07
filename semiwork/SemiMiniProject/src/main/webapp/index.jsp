<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
div.layout{
  border: 0px solid gray;
  position: absolute;
}

div.title{
    width: 100%;
    height: 80px;
    line-height: 80px;
    font-size: 30pt;
    font-family: 'Nanum Myeongjo';
    text-align: center;
}

div.menu{
  width: 100%;
  height: 80px;
  top: 120px;
  text-align: center;
  font-family: 'Nanum Myeongjo';
   font-size: 20pt;
    line-height: 80px;
}

div.info{
  width: 250px;
  height: 300px;
  line-height: 30px;
  font-family: 'Nanum Myeongjo';
  font-size: 13pt;
  top: 300px;
  padding: 20px 20px;
  border: 5px solid purple;
  border-radius: 30px;
  left: 100px;
  
}

div.main{
  width: 1200px;
  height: 1000px;
  font-size: 12pt;
  font-family: 'Nanum Myeongjo';
  left: 400px;
  top: 250px;
  
}
a,a:hover {
	color: black;
	text-decoration: none;
}

</style>
</head>
<%
   String mainPage="layout/main.jsp"; 
  
  if(request.getParameter("main")!=null)
  {
	  mainPage=request.getParameter("main");
  }
%>
<body>

<div class="layout title">
  <jsp:include page="layout/title.jsp"/>
</div>
<div class="layout menu">
  <jsp:include page="layout/menu.jsp"/>
</div>
<div class="layout info">
  <jsp:include page="layout/sideinfo.jsp"/>
</div>
<div class="layout main">
  <jsp:include page="<%=mainPage %>"/>
</div>
</body>
</html>