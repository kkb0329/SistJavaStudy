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

<!-- num:hidden -->
<input type="hidden" name="num" value="${dto.num }">

  <table class="table table-bordered" style="width: 400px;">
     <caption align="top"><b>글쓰기</b></caption>
     <tr>
       <th width="100">작성자</th>
       <td>
         <input type="text" name="writer" class="form-control"
         style="width: 100px;" value="${dto.writer }">
       </td>
     </tr>
     <tr>
       <th width="100">제목</th>
       <td>
         <input type="text" name="subject" class="form-control"
         style="width: 280px;" value="${dto.subject }">
       </td>
     </tr>
     <tr>
       <td colspan="2">
         <textarea style="width: 380px; height: 100px;"
         class="form-control" name="content">
           ${dto.content }
         </textarea>
       </td>
     </tr>
     <tr>
       <td colspan="2" align="center">
         <button type="submit" class="btn btn-outline-warning"
         style="width: 150px;">db수정</button>
       </td>
     </tr>
  </table>
</form>
</body>
</html>