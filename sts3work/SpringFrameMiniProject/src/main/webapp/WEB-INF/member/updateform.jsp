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
  <form action="update" method="post">
  <input type="hidden" name="num" value="${dto.num }">
     <table  class="table table-bordered" style="width: 500px;">
        <caption align="top"><b>회원정보수정</b></caption>
        <tr>
          <th width="120">회원명</th>
          <td>
            <input type="text" name="name" class="form-control"
            required="required" style="width: 120px;" value="${dto.name }">
          </td>
        </tr>
        
        <tr>
          <th width="120">비밀번호</th>
          <td>
            <input type="password" name="pass" class="form-control"
            required="required" style="width: 150px;">
          </td>
        </tr>
        <tr>
          <th width="120">핸드폰</th>
          <td>
            <input type="text" name="hp" class="form-control"
            required="required" style="width: 200px;" value="${dto.hp }">
          </td>
        </tr>
        
        <tr>
          <td colspan="2" align="center">
            <button type="submit" class="btn btn-info">회원정보수정</button>
            <button type="button" class="btn btn-success"
            onclick="location.href='list'">회원목록</button>
          </td>
        </tr>
     </table>
  </form>
</body>
</html>