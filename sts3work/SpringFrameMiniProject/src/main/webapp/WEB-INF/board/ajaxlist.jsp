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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<style type="text/css">
  .photo{
    width: 200px;
    height: 200px;
  }
</style>
<script type="text/javascript">
  $(function(){
	  $(".list2").trigger("click");
  })
</script>
</head>
<body>
   <!-- RestApi를 이용한 2개의 리스트 출력 (페이징처리 없이 출력할것!!!)
   /rest/list1  : 아이콘 클릭시  제목이랑 내용위주의 출력(카드형)
    			  아이콘 클릭시 사진이있는 경우에만 이미지리스트 출력(앨범형)
   
    ajax이용해서 출력할것
    sql,dao 전체글 출력하는 메서드 추가
    RestController 이용해서 출력할것-->
    
    
    <div style="width: 800px; text-align: right; margin: 50px 50px; font-size: 3em;">
		<i class="bi bi-card-list list1"></i>
		<i class="bi bi-person-lines-fill list2"></i>
	</div>
	<div class="restlist" style="margin: 50px 50px;"></div>
	
	<script type="text/javascript">
	   $("i.list1").click(function(){
		   $("i.list1").css("color","green");
		   $("i.list2").css("color","black");
		   
		   
		   $.ajax({
			   
			   type:"get",
			   dataType:"json",
			   url:"../rest/list1",
			   success:function(data){
				   
				   var tag="";
				   tag+="<table class='table'>";
				   
				   $.each(data,function(i,ele){
					   
					   tag+="<tr height='100'><td>";
					   tag+="<h3><b>"+ele.subject+"</b></h3>";
					   tag+=ele.content+"<br>";
					   tag+="작성자: "+ele.writer;
					   tag+=ele.writeday;
					   tag+="</td></tr>";
				   });
				   tag+="</table>";
				   $(".restlist").html(tag);
				   
			   }
			   
		   });
		   
		   
	   });
	   
	   
	   
	   
	   
	   $("i.list2").click(function(){
		   $("i.list2").css("color","green");
		   $("i.list1").css("color","black");
		   
		   
		   $.ajax({
			   
			   type:"get",
			   dataType:"json",
			   url:"../rest/list1",
			   success:function(res){
				   
				 var s="" ; 
				 	s+="<table class='table'>";
				    s+="<tr>";
				 var n=0;
				$.each(res,function(i,elt){
					
					n++;
					if(elt.photo!='no'){
						   s+="<td width='200'>";
						   s+="<img  src='../photo/"+elt.photo+"' class='photo'>";
						   s+="작성자: "+elt.writer;
						   s+="</td>";
						   
						   if(n%4==0){
							   s+="</tr><tr>";
						   }
					   }
				});
				
				s+="</table>";
				$(".restlist").html(s);
				   
				
			   }
		   });
	   });
	</script>
	
	
</body>
</html>