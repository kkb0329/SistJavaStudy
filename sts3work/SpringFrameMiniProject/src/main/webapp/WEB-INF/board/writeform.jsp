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

<form action="insert" method="post" enctype="multipart/form-data">
    <!-- hidden 5개 넣기 -->
    <input type="hidden" name="num" value="${num }">
    <input type="hidden" name="currentPage" value="${currentPage }">
    <input type="hidden" name="regroup" value="${regroup }">
    <input type="hidden" name="restep" value="${restep }">
    <input type="hidden" name="relevel" value="${relevel }">
    
    <table class="table table-bordered" style="width: 500px;">
       <caption align="top"><b>
         <c:if test="${num==0 }">새글쓰기</c:if>
         <c:if test="${num!=0 }">답글쓰기</c:if>
       </b></caption>
       
       <tr>
         <th width="100">작성자</th>
         <td>
           <input type="text" name="writer" class="form-control"
           style="width: 120px;" required="required">
         </td>
       </tr>
       <tr>
         <th width="100">제목</th>
         <td>
           <input type="text" name="subject" class="form-control"
           style="width: 250px;" required="required" value="${subject }">
         </td>
       </tr>
       <tr>
         <th width="100">사진</th>
         <td>
           <input type="file" name="upload" class="form-control"
           style="width: 200px;" multiple="multiple">
         </td>
       </tr>
       <tr>
         <td colspan="2">
           <textarea style="width: 480px; height: 100px;"
           name="content" class="form-control" required="required"></textarea>
         </td>
       </tr>
       <tr>
         <td colspan="2" align="center">
           <button type="submit" class="btn btn-outline-info"
           >저장</button>
         </td>
       </tr>
    </table>
</form>









</body>
</html>