<%@page import="hello.HelloDto"%>
<%@page import="hello.HelloDao"%>
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
<%
	String num=request.getParameter("num");
    HelloDao dao=new HelloDao();
    HelloDto dto=dao.getOneData(num);
%>
<body>
 <div style="margin-left: 50px;">
     <form action="./updateAction.jsp" method="post">
        <table class="table table-bordered" style="width: 600px;">
         <tr>
          <th>이름</th>
	           <td>
	             <input type="text" name="name" class="form-control"
	             style="width: 150px;" value="<%=dto.getName()%>">
	           </td>
           
         </tr>
         <tr>
           <th>주소</th>
	           <td>
	             <input type="text" name="addr" class="form-control"
	             style="width: 300px;" value="<%=dto.getAddr()%>">
	           </td>
           
         </tr>
         <tr>
           <th>연락처</th>
	           <td>
	             <input type="text" name="hp" class="form-control"
	             style="width: 250px;" value="<%=dto.getHp()%>">
	           </td>
           
         </tr>
         
         <tr>
           <td colspan="2" align="center">
            <!-- num hidden 처리 위치는 폼안어디든 상관없다-->
             <input type="hidden" name="num" value="<%=num%>">
             <input type="submit" value="DB수정" class="btn btn-info">
             <input type="button" value="목록이동" onclick="location.href='helloList.jsp'"
             class="btn btn-warning">
           </td>
         </tr>
       </table>
     </form>
 </div>
</body>
</html>