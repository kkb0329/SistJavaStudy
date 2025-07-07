<%@page import="data.dao.ShopDao"%>
<%@page import="data.dao.MemberDao"%>
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
a{
color: black;
	text-decoration: none;
}

div.cart{
  float: right;
  cursor: pointer;
}

.carticon{
  font-size: 30px;
  
}

div.cart .cartcount{
  
  width: 30px;
  height: 30px;
  border-radius: 100px;
  float: right;
  background-color: red;
  color: white;
  text-align: center;
  line-height: 30px;
  font-size: 15px;
  position: relative;
  left: -15px;
  top: 10px;
}


</style>
<script type="text/javascript">
  $(function(){
	  $("div.cart").click(function(){
		  location.href="index.jsp?main=shop/mycart.jsp";
	  });
  })
</script>
</head>
<%
   //프로젝트 경로구해기
   String root=request.getContextPath();
  //로그인 세션
  String loginok=(String)session.getAttribute("loginok");
  //id
  String myid=(String)session.getAttribute("myid");
  //dao,id==>name
  MemberDao dao=new MemberDao();
  String name=dao.getName(myid);
  
  
  //shopdao
  ShopDao sdao=new ShopDao();
  //카트개수
  int cartSize=sdao.getCartList(myid).size();
%>
<body>

<a href="<%=root%>/">
   <img alt="" src="image2/title.png"></a>
   
  
  <div style="float: right; padding-right: 100px;"> 
   <%
     if(loginok==null){%>
    	 
    	 <button type="button" class="btn btn-success" style="width: 100px; "
    	 onclick="location.href='index.jsp?main=login/loginmain.jsp'">Login</button>
    <% }else{%>
        <b style="font-size: 11pt;"><%=name %>님 로그인중</b>
    	<button type="button" class="btn btn-danger" style="width: 100px;"
    	 onclick="location.href='index.jsp?main=login/logoutaction.jsp'">Logout</button>
    <%}
   %>
     <div class="cart">
     	<i class="bi bi-cart carticon"></i>
          <span class="cartcount"><%=cartSize %></span>
     </div>
</div>

</body>
</html>