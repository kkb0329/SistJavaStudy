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
  function confirmdel(num){
	  var ans=confirm("정말 탈퇴하시겠어요?");
	  
	  if(ans){
		  location.href='delete?num='+num;
	  }
  }
</script>
</head>
<body>
    <div  style="margin: 200px; width: 600px;">
       <table class="table table-bordered">
          <c:forEach  var="dto" items="${list }">
          
          <c:if test="${sessionScope!=null && sessionScope.myid==dto.id }">
          
            <tr>
               <td style="width: 220px;" align="center" rowspan="4">
                  <img alt="" src="../image/mainview/mainImg.png" width="200px;">
                  
               </td>
               <td>회원명:  ${dto.id }</td>
               <td rowspan="4" valign="middle" align="center">
                  <button type="button" class="btn btn-outline-warning btn-sm"
                  onclick="location.href='updateform?num=${dto.num}'">수정</button><br><br>
                  <button type="button" class="btn btn-outline-danger btn-sm"
                  onclick="confirmdel('${dto.num}')">탈퇴</button>
               </td>
            </tr>
            <tr>
              <td>${dto.name }</td>
            </tr>
            <tr>
              <td>${dto.hp }</td>
            </tr>
            <tr>
              <td>${dto.gaipday }</td>
            </tr>
            
           </c:if> 
            
           
          </c:forEach>
       </table>
    </div>
</body>
</html>