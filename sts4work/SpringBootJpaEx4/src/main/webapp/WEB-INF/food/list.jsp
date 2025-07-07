<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body class="container mt-5">
  <h3 class="alert alert-success">총 ${count}개의 음식 정보가 있습니다</h3>
  <button type="button" class="btn btn-success mb-3" onclick="location.href='/food/form'">음식 등록</button>

  <table class="table table-bordered">
    <thead class="table-warning">
      <tr>
        <th>번호</th>
        <th>음식명</th>
        <th>가격</th>
        <th>이미지</th>
        <th>입고일</th>
        <th>등록일</th>
        <th>편집</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="dto" items="${list}" varStatus="i">
        <tr>
          <td>${i.count}</td>
          <td>${dto.foodname}</td>
          <td><fmt:formatNumber value="${dto.foodprice}" type="currency"/></td>
          <td><img src="/images/${dto.foodphoto}" width="50"></td>
          <td>${dto.ipgoday}</td>
          <td><fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/></td>
          <td>
            <a href="/food/updateform?num=${dto.num}" class="btn btn-sm btn-info">수정</a>
            <a href="/food/delete?num=${dto.num}" class="btn btn-sm btn-danger">삭제</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
