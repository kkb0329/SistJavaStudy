<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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
<%
   //프로젝트 경로구해기
   String root=request.getContextPath();
%>
<body>
   <a href="<%=root%>/">메인(홈)</a>&nbsp;&nbsp;&nbsp;
   <a href="<%=root%>/">로그인</a>&nbsp;&nbsp;&nbsp;
   <a href="<%=root%>/">회원가입</a>&nbsp;&nbsp;&nbsp;
   <a href="<%=root%>/">방명록</a>&nbsp;&nbsp;&nbsp;
   <a href="<%=root%>/">Q&A</a>&nbsp;&nbsp;&nbsp;
   <a href="<%=root%>/">고객게시판</a>&nbsp;&nbsp;&nbsp;
   <a href="<%=root%>/">Shop</a>&nbsp;&nbsp;&nbsp;
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="csstransforms no-csstransforms3d csstransitions"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<%
	
   //프로젝트 경로구해기
   String root=request.getContextPath();
	
	//로그인에관한 세션
	String loginok=(String)session.getAttribute("loginok");
	
	//아이디세션
	String myid=(String)session.getAttribute("myid");
	
	
%>
	<link rel="stylesheet" type="text/css" href="<%=root %>/menu/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="<%=root %>/menu/css/menu.css">
    
	<script type="text/javascript" src="<%=root %>/menu/js/jquery.js"></script>
	<script type="text/javascript" src="<%=root %>/menu/js/function.js"></script>

</head>
<body>

<div id="wrap">
	<header>
		<div class="inner relative">
			<a class="logo" href="http://www.freshdesignweb.com"></a>
			<a id="menu-toggle" class="button dark" href="#"><i class="icon-reorder"></i></a>
			<nav id="navigation">
				<ul id="main-menu">
					<li class="current-menu-item"><a href="<%=root%>/">Home</a></li>
					<li class="parent">
						<a href="#">Member</a>
						<ul class="sub-menu">
						
						<%
						  if(loginok!=null && myid.equals("admin")){%>
							  
							  <li><a href="index.jsp?main=member/memberlist.jsp"><i class="icon-wrench"></i> 회원목록</a></li>
						  <%}
						%>
							
							
							
							<li><a href="index.jsp?main=member/memberform.jsp"><i class="icon-credit-card"></i>  회원가입</a></li>
							<li><a href="index.jsp?main=member/mypage.jsp"><i class="icon-credit-card"></i>  마이페이지</a></li>
							<li><a href="index.jsp?main=login/loginmain.jsp"><i class="icon-gift"></i> 로그인</a></li>
							
						</ul>
					</li>
					<li><a href="index.jsp?main=guest/guestlist.jsp">방문인사</a></li>
					<li class="parent">
						<a href="#">게시판</a>
						<ul class="sub-menu">
							<li><a href="#">Q&A 게시판</a></li>
							<li><a href="index.jsp?main=board/boardlist.jsp">답변형 고객게시판</a></li>
							<li><a href="index.jsp?main=smart/selist.jsp">Smart게시판</a></li>
							
						</ul>
					</li>
					<li><a href="<%=root%>/shop/shoplist.jsp">Shop</a>
					   <ul class="sub-menu">
					   
					     <%
					       if(loginok!=null && myid.equals("admin")){%>
					    	   
					    	   <li><a href="index.jsp?main=shop/addform.jsp">ShopForm</a></li>
					       <%}
					     %>
							
							
							<li><a href="index.jsp?main=shop/shoplist.jsp">ShoppingMall</a></li>
							
							<li><a href="index.jsp?main=shop/map.jsp">오시는길</a></li>
							
						</ul>
					
					</li>
					  
					
				</ul>
			</nav>
			<div class="clear"></div>
		</div>
	</header>	
</div>    
</body></html>