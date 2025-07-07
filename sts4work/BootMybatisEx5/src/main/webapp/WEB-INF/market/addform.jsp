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
  <div style="margin: 100px 100px; width: 400px;">
   <form action="insert" method="post" enctype="multipart/form-data">
     <table class="table table-bordered">
       <tr>
         <th class="table-success" width="100">상품명</th>
         <td>
           <input type="text" name="sangpum" required="required"
           class="form-control" style="width: 150px;">
         </td>
       </tr>
       <tr>
         <th class="table-success">상품이미지</th>
           <td>
             <input type="file" name="photo" class="form-control"
             style="width: 200px;">
         </td>
       </tr>
       
        <tr>
         <th class="table-success" width="100">가격</th>
         <td>
           <input type="text" name="price" 
           class="form-control" style="width: 150px;">
         </td>
       </tr>
       
       
       
       <tr>
         <td colspan="2" align="center">
           <input type="submit" class="btn btn-outline-success"
           value="상품저장">
           <input type="button" class="btn btn-outline-info"
           value="상품목록" onclick="location.href='list'">
         </td>
       </tr>
     </table>
   </form>
</div>

</body>
</html>