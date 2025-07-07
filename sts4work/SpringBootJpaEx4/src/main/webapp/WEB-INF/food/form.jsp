<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식 등록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
  function updatePreview() {
    const image = document.getElementById("preview");
    const selected = document.getElementById("foodphoto").value;
    image.src = "/images/" + selected;
  }
</script>
</head>
<body class="container mt-5">
  <h2>음식 등록</h2>
  <form action="/food/insert" method="post">
    <div class="mb-3">
      <label>음식명:</label>
      <input type="text" name="foodname" class="form-control" required>
    </div>
    <div class="mb-3">
      <label>가격:</label>
      <input type="number" name="foodprice" class="form-control" required>
    </div>
    <div class="mb-3">
      <label>입고일:</label>
      <input type="date" name="ipgoday" class="form-control" required>
    </div>
    <div class="mb-3">
      <label>이미지 선택:</label>
      <select name="foodphoto" id="foodphoto" class="form-select" onchange="updatePreview()">
        <c:forEach var="img" items="${images}">
          <option value="${img}">${img}</option>
        </c:forEach>
      </select>
    </div>
    <div class="mb-3">
      <img id="preview" src="/images/${images[0]}" width="150" style="margin-top:10px;">
    </div>
    <button type="submit" class="btn btn-primary">저장</button>
  </form>
</body>
</html>
