<%@page import="java.text.NumberFormat"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.ShopDao"%>
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
<style type="text/css">
  img.photo{
    width: 60px;
    height: 80px;
    border: 1px solid gray;
  }
</style>
</head>
<%
  String id=(String)session.getAttribute("myid");
  ShopDao dao=new ShopDao();
  //장바구니 목록
  List<HashMap<String,String>> list=dao.getCartList(id);
  
  //이름
  MemberDao mdao=new MemberDao();
  String name=mdao.getName(id);
  
//화폐
  NumberFormat nf=NumberFormat.getCurrencyInstance();
%>
<body>
<div style="margin: 100px 100px; width: 800px;" >
  <h4 class="alert alert-success"><%=name %>(<%=id %>)님의 장바구니</h4>
  <table class="table table-striped">
    <tr>
       <th><input type="checkbox" id="allcheck"></th>
       <th>상품정보</th>
       <th>상품금액</th>
    </tr>
    
    <%
      for(int i=0;i<list.size();i++)
      {
    	  HashMap<String,String> map=list.get(i);
    	  
    	  //cnt
    	  int cnt=Integer.parseInt(map.get("cnt"));
    	  //price
    	  int price=Integer.parseInt(map.get("price"));
    	  
    	  %>
    	  
    	  <tr>
    	    <td>
    	      <input type="checkbox" name="idx" class="idx"
    	      idx="<%=map.get("idx") %>">
    	    </td>
    	    <td>
    	      <div>
    	        <img alt="" src="shopsave/<%=map.get("photo")%>"
    	        class="photo"  shopnum="<%=map.get("shopnum") %>"
    	        align="left" hspace="20">
    	        
    	        <h6>상품명: <%=map.get("sangpum") %></h6>
    	        <h6>갯수: <%=cnt %></h6>
    	        <h6>날짜: <%=map.get("cartday") %></h6>
    	      </div>
    	    </td>
    	    
    	    <td>
    	       <h6><%=nf.format(price*=cnt)%></h6>
    	    </td>
    	    
    	    
    	  </tr>
      <%}
    %>
    
    <tr>
      <td colspan="4">
        <button type="button"
        class="btn btn-danger" style="margin-left: 100px;">선택상품삭제</button>
        
        <span style="color: green; float: right; font-size: 1.5em;">
        총 주문금액: <b >
        
        </b></span>
      </td>
    </tr>
   
  </table>
</div>
</body>
</html>