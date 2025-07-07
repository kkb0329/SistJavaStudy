<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<style type="text/css">
  div.layout{
     border: 0px solid gray;
     font-family: 'Nanum Myeongjo';
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
   font-size: 15pt;
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

div.layout a{
	color: black;
	text-decoration: none;
}
  
</style>
</head>
<body>
  <div  class="layout title">
    <tiles:insertAttribute name="title"/>
  </div>
  <div  class="layout menu">
    <tiles:insertAttribute name="menu"/>
  </div>
  <div  class="layout info">
    <tiles:insertAttribute name="info"/>
  </div>
  <div  class="layout main">
    <tiles:insertAttribute name="main"/>
  </div>
</body>
</html>