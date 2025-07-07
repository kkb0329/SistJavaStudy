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
</head>
<%
  String num=request.getParameter("num");
%>
<body>
<div class="deletepassform">
  <form action="board/deletepassaction.jsp" >
    <!-- hidden -->
    <input type="hidden" name="num" value="<%=num%>">
    <table class="table table-bordered" style="width: 300px;">
       <caption align="top"><b>삭제 비밀번호</b></caption>
      <tr>
        <td>
          <input type="password" name="pass" required="required"
          class="form-control" style="width: 200px;" placeholder="비밀번호">
        </td>
      </tr>
      <tr>
        <td align="center">
          <button type="submit" class="btn btn-primary">삭제하기</button>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>