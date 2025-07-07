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
  <form action="save1" method="post" enctype="multipart/form-data">
    <table class="table table-bordered" style="width: 400px;">
       <caption align="top"><b>스프링 업로드_1개</b></caption>
       <tr>
         <th>제목</th>
         <td>
           <input type="text" name="title" class="form-control"
           style="width: 200px;">
         </td>
       </tr>
       <tr>
         <th>업로드</th>
         <td>
           <input type="file" name="photo" class="form-control"
           style="width: 200px;">
         </td>
       </tr>
       <tr>
         <td colspan="2" align="center">
           <button type="submit" class="btn btn-success">업로드#1</button>
         </td>
       </tr>
    </table>
  </form>
</body>
</html>