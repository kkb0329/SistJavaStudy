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
 <div style="margin-left: 50px;">
     <form action="./insertAction.jsp" method="post">
        <table class="table table-bordered" style="width: 600px;">
         <tr>
           <th>이름</th>
	           <td>
	             <input type="text" name="name" class="form-control"
	             style="width: 150px;" required="required">
	           </td>
           
         </tr>
         <tr>
           <th>주소</th>
	           <td>
	             <input type="text" name="addr" class="form-control"
	             style="width: 300px;" required="required">
	           </td>
           
         </tr>
         <tr>
           <th>연락처</th>
	           <td>
	             <input type="text" name="hp" class="form-control"
	             style="width: 250px;" required="required">
	           </td>
           
         </tr>
         
         <tr>
           <td colspan="2" align="center">
             <input type="submit" value="DB전송" class="btn btn-success">
             <input type="button" value="목록이동" onclick="location.href='helloList.jsp'"
             class="btn btn-warning">
           </td>
         </tr>
       </table>
     </form>
 </div>
</body>
</html>