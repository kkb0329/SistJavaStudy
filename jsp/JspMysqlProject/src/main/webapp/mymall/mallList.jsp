<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="mymall.MymallDto"%>
<%@page import="java.util.List"%>
<%@page import="mymall.MymallDao"%>
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
<style type="text/css">
  #box{
    width: 30px;
    height: 30px;
    border-radius: 100px;
  }
  a{
     text-decoration: none;
     color: black;
     cursor: pointer;
  }
</style>
</head>
<%
  MymallDao dao=new MymallDao();
  List<MymallDto> list=dao.getAllSangPums();
  NumberFormat nf=NumberFormat.getCurrencyInstance();
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
<div style="margin: 100px 100px; width: 800px;">
  <h3 class="alert alert-info">MyMall 전체목록</h3>
  <br>
  <button type="button" class="btn btn-warning"
  onclick="location.href='addForm.jsp'">상품추가</button>
  <br><br>
  <table class="table table-bordered">
    <tr class="table-success">
      <th width="80">번호</th>
      <th width="180">상품명</th>
      <th width="80">색상</th>
      <th width="180">가격</th>
      <th width="180">등록일</th>
    </tr>
    
    <%
      if(list.size()==0){
    	  %>
    	  <tr>
    	    <td colspan="5" align="center">
    	      <b>등록된 상품이 없습니다</b>
    	    </td>
    	  </tr>
      <%}else{
    	  
    	  for(int i=0;i<list.size();i++)
    	  {
    		  MymallDto dto=list.get(i);
    		  %>
    		  
    		  <tr>
    		    <td align="center"><%=i+1 %></td>
    		    <td><a href="detailPage.jsp?num=<%=dto.getNum()%>"><%=dto.getSangpum() %></a></td>
    		    <td align="center">
    		      <div id="box" style="background-color: <%=dto.getColor()%>"></div>
    		    </td>
    		    <td align="right"><%=nf.format(dto.getPrice()) %></td>
    		    <td><%=sdf.format(dto.getWriteday()) %></td>
    		  </tr>
    	  <%}
    	  
      }
    %>
  </table>
</div>
</body>
</html>