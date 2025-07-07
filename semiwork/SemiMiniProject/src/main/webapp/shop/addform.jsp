<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    <div class="addform">
      <form action="shop/addaction.jsp" method="post"
      enctype="multipart/form-data">
        <table class="table table-bordered" style="width: 500px;">
          <caption align="top"><b>상품등록</b></caption>
          <tr>
            <th width="150">카테고리</th>
            <td>
              <select name="category" class="form-control"
              style="width: 200px;" required="required">
                <option value="아우터">아우터</option>
                <option value="상의">상의</option>
                <option value="하의">하의</option>
                <option value="액세서리">액세서리</option>
                <option value="기타">기타</option>
              </select>
            </td>
          </tr>
          <tr>
            <th>상품명</th>
            <td>
              <input type="text" name="sangpum" class="form-control"
              style="width: 200px;" required="required">
            </td>
          </tr>
          <tr>
            <th>이미지</th>
            <td>
              <input type="file" name="sang_photo" class="form-control"
              style="width: 300px;" required="required">
            </td>
          </tr>
          <tr>
            <th>상품가격</th>
            <td>
              <input type="text" name="price" class="form-control"
              style="width: 200px;" required="required">
            </td>
          </tr>
          <tr>
            <th>입고일</th>
            <td>
              <%
              SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
              String today=sdf.format(new Date());
              
              %>
            
              <input type="date" name="ipgoday" class="form-control"
              style="width: 200px;" required="required" value="<%=today%>">
            </td>
          </tr>
          <tr>
            <td colspan="2" align="center">
              <button type="submit" class="btn btn-outline-info">상품저장</button>
              <button type="button" class="btn btn-outline-info"
              onclick="location.href='index.jsp?main=shop/shoplist.jsp'">상품목록</button>
            </td>
          </tr>
        </table>
      </form>
   </div> 
   
</body>
</html>