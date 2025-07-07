<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="uploadAction2.jsp" method="post"
enctype="multipart/form-data">
  <table class="table table-bordered" style="width: 400px;">
    <caption align="top"><b>이미지 여러개 업로드하기</b></caption>
    <tr>
      <th>작성자</th>
      <td>
        <input type="text" name="writer" class="form-control"
        style="width: 150px;">
      </td>
    </tr>
    <tr>
      <th>이미지</th>
      <td>
        <input type="file" name="photo1" class="form-control"
        style="width: 250px;"><br>
        <input type="file" name="photo2" class="form-control"
        style="width: 250px;"><br>
        <input type="file" name="photo3" class="form-control"
        style="width: 250px;"><br>
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="서버에 업로드하기"
        class="btn btn-info">
      </td>
    </tr>
  </table>
</form>
</body>
</html>