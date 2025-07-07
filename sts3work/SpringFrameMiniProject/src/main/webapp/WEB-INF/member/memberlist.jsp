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
<script type="text/javascript">
  $(function(){
	  
	  $(".btndelete").click(function(){
		  
		  var num=$(this).attr("num");
		  //alert(num);
		  
		  var ans=confirm("정말 강퇴시킬겁니까?");
		  if(ans){
			  
			  $.ajax({
				  
				  type:"get",
				  dataType:"html",
				  url:"memdel",
				  data:{"num":num},
				  success:function(){
					  
					  alert("강퇴처리 되었습니다");
					  location.reload();
				  }
				  
				  
			  });
		  }
	  });
	  
	  
  });

</script>
</head>
<body>

<button type="button" class="btn btn-success"
onclick="location.href='form'">회원가입폼</button>
<br><br>
<table class="table table-bordered" style="width: 800px;">
   <caption align="top"><b>전체회원명단</b></caption>
   <tr class="table-warning">
     <th width="100">번호</th>
     <th width="120">아이디</th>
     <th width="120">회원명</th>
     <th width="150">핸드폰</th>
     <th width="180">가입일</th>
     <th width="180">강퇴</th>
   </tr>
   
   <c:forEach  var="dto" items="${list }" varStatus="i">
     <tr align="center">
       <td>${i.count }</td>
       <td>${dto.id }</td>
       <td>${dto.name }</td>
       <td>${dto.hp }</td>
       <td>
          <fmt:formatDate value="${dto.gaipday }"
          pattern="yyyy-MM-dd HH:mm"/>
       </td>
       <td>
         <button type="button" 
         class="btn btn-danger btn-sm btndelete" num=${dto.num }>강퇴</button>
         
       </td>
     </tr>
   </c:forEach>
</table>

</body>
</html>