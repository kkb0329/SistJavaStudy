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
 <form action="write" method="post">
    <table class="table table-bordered" style="width: 600px;">
      <tr>
        <th width="150px">이름</th>
        <td><input type="text" name="name" class="form-control"
        style="width: 150px;"></td>
      </tr>
      <tr>
        <th width="150px">퍼스널 컬러</th>
        <td><input type="color" name="color" class="form-control"
        style="width: 150px;"></td>
      </tr>
      <tr>
        <th width="150px">취미</th>
        <td>
        
        <input type="checkbox" name="hobby"  value="여행">여행&nbsp;
        <input type="checkbox" name="hobby"  value="공부">공부&nbsp;
        <input type="checkbox" name="hobby"  value="게임">게임&nbsp;
        <input type="checkbox" name="hobby"  value="음악감상">음악감상&nbsp;
        <input type="checkbox" name="hobby"  value="유투브">유투브&nbsp;
        
        </td>
      </tr>
      <tr>
         <th width="150px">가장좋아하는 언어</th>
         <td>
           <select name="lang">
              <option value="Java">Java</option>
              <option value="Spring">Spring</option>
              <option value="Ajax">Ajax</option>
              <option value="HTML">HTML</option>
           </select>
         </td>
      </tr>
      
      <tr>
        <td colspan="2" align="center">
           <button type="submit" class="btn btn-outline-info"
           style="width: 150px;">전송</button>
        </td>
      </tr>
    </table>
    
  </form>
</body>
</html>