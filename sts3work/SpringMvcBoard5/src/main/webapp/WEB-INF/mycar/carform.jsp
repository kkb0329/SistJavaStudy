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
<form action="carinfo" method="post">
  <table class="table table-bordered" style="width: 400px;">
     <caption align="top"><b>자동차 정보</b></caption>
     <tr>
       <th width="100">자동차명</th>
       <td>
         <input type="text" name="carname" class="form-control"
         style="width: 100px;" required="required">
       </td>
     </tr>
     <tr>
       <th width="100">자동차가격</th>
       <td>
         <input type="text" name="carprice" class="form-control"
         style="width: 120px;" required="required">
       </td>
     </tr>
     <tr>
       <th width="100">자동차색상</th>
       <td>
         <input type="color" name="carcolor" class="form-control"
         style="width: 100px;" value="#ffffcc" required="required">
       </td>
     </tr>
     <tr>
       <th width="100">자동차구입일</th>
       <td>
         <input type="date" name="carguip" class="form-control"
         style="width: 200px;" required="required">
       </td>
     </tr>
     
     <tr>
       <td colspan="2" align="center">
         <button type="submit" class="btn btn-outline-info"
         style="width: 150px;">db에 저장</button>
         <button type="button" style="width: 150px;"
         class="btn btn-outline-info">목록</button>
       </td>
     </tr>
  </table>
</form>
</body>
</html>