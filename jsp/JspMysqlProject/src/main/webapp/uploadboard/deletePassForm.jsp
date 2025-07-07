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
%>
<body>
<div style="margin: 200px 200px;">
	<form action="deleteAction.jsp" method="post">
	  <table class="table table-bordered" style="width: 250px;">
	     <caption align="top"><b>삭제비밀번호 입력</b></caption>
	     <tr>
	       <th >비밀번호를 입력해 주세요<br><br>
	         <input type="password" name="pass" class="form-control"
	         style="width: 150px;" required="required">
	         <br><br>
	         
	         <!-- hidden num -->
	         <input type="hidden" name="num" value="<%=num%>">
	         
	         
	         <button type="submit" class="btn btn-danger">삭제</button>
	         <button type="button" class="btn btn-success"
	         onclick="history.back()">이전</button>
	       </th>
	     </tr>
	  </table>
	</form>
</div>
</body>
</html>