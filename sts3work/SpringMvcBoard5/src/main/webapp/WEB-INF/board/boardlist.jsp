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
  <h5 class="alert alert-info" style="width: 800px;">총 ${totalCount }개의 데이타가 있습니다</h5>
  <br>
  <button type="button" class="btn btn-info btn-sm"
  onclick="location.href='writeform'">글쓰기</button>
  
<br><br>
  
  <table class="table table-bordered" style="width: 800px;">
     <tr class="table-warning">
        <th width="100">번호</th>
        
        <th width="380">제목</th>
        <th width="180">작성자</th>
        <th width="180">작성일</th>
     </tr>
     <c:forEach var="dto"  items="${list }" varStatus="i">
       <tr>
         <td>${i.count }</td>
         <td>
           <a href="content?num=${dto.num }">${dto.subject }</a>
         </td>
         <td>${dto.writer }</td>
         <td><fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/></td>
       </tr>
     </c:forEach>
  </table>

</body>
</html>