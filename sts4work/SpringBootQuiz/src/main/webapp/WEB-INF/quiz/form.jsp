<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
  <h1>quiz_data읽기</h1>
    <form action="foodshow" method="post">
      <table class="table table-bordered" style="width: 300px;">
         <tr>
           <th width="100">음식명</th>
           <td>
             <input type="text" name="fname" class="form-control"
             style="width: 100px;" required="required">
           </td>
         </tr>
         <tr>
           <th width="100">음식가격</th>
           <td>
             <input type="text" name="fprice" class="form-control"
             style="width: 150px;" required="required">
           </td>
         </tr>
         <tr>
           <th width="100">이미지</th>
           <td>
             <input type="checkbox" name="fphoto" value="1">이미지1&nbsp;
             <input type="checkbox" name="fphoto" value="2">이미지1&nbsp;
             <input type="checkbox" name="fphoto" value="3">이미지1&nbsp;
             <input type="checkbox" name="fphoto" value="4">이미지1&nbsp;
             <input type="checkbox" name="fphoto" value="11">이미지1&nbsp;
           </td>
         </tr>
         <tr>
           <td colspan="2" align="center">
             <button type="submit" class="btn btn-danger">서버에 전송</button>
           </td>
         </tr>
      </table>
    </form>
</body>
</html>