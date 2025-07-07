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
  <h3 class="alert alert-success">ex2 예제_음식명과 이미지</h3>
  <br>
  <button type="button" id="btn1" 
  class="btn btn-danger">json배열 데이타 출력하기</button>
  
  <div id="show"></div>
  
  <script type="text/javascript">
    $("#btn1").click(function(){
    	
    	$.ajax({
    		type:"get",
    		dataType:"json",
    		url:"list2",
    		success:function(res){
    			
    			var s="";
    			$.each(res,function(i,elt){
    				
    				s+="<figure>";
    				s+="<img src='/photo/Food/"+elt.photo+"' width=200>";
    				s+="<figcaption><b>";
    				s+=elt.name+"</b></figcaption></figure>";
    			});
    			
    			$("#show").html(s);
    		}
    	});
    });
  
  </script>
  
  
  
  
  
  
  
</body>
</html>