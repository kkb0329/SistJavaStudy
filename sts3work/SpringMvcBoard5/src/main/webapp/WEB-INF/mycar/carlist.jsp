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
  <c:if test="${totalCount==0 }">
    <h3 class="alert alert-info">저장된 자동차 정보가 없습니다</h3>
  </c:if>
  <c:if test="${totalCount>0 }">
    <h3 class="alert alert-info">총 ${totalCount }개의 자동차 정보가 있습니다</h3>
  </c:if>
  
  <br>
  <button type="button" style="width: 150px;"
  onclick="location.href='writeform'" class="btn btn-outline-success">차 정보입력</button>
   <br> <br>
  <table class="table table-bordered" style="width: 800px;">
     <tr class="table-success">
       <th width="80">번호</th>
       <th width="120">자동차명</th>
       <th width="120">차량가격</th>
       <th width="100">색상</th>
       <th width="120">구입일</th>
       <th width="120">차량등록일</th>
       <th width="180">수정/삭제</th>
     </tr>
     <c:forEach var="dto" items="${list }" varStatus="i">
       <tr>
         <td>${totalCount-i.index }</td>
         <td>${dto.carname }</td>
          <td><fmt:formatNumber value="${dto.carprice }" type="currency"/></td>
          <td>
             <div style="width: 20px; height: 20px; background-color: ${dto.carcolor}; border-radius:100px;"></div>
          </td>
          <td>${dto.carguip }</td>
          <td><fmt:formatDate value="${dto.carwriteday }" pattern="yyyy-MM-dd"/></td>
          <td>
            <button type="button" class="btn btn-outline-success btn-sm"
            onclick="location.href='updateform?num=${dto.num}'">수정</button>
            <button type="button" class="btn btn-outline-danger btn-sm"
            onclick="location.href='delete?num=${dto.num}'">삭제</button>
          </td>
       </tr>
     </c:forEach>
     
  </table>
  
  
  
  
  
  
  
  
  
</body>
</html>