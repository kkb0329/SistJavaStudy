<%@page import="login.LoginDao"%>
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
<%
    String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String save=request.getParameter("savechk");
	
	//아이디와 비번이 맞는지 확인
	LoginDao db=new LoginDao();
	boolean flag=db.isLogin(id, pass);
	
	//맞으면 세션저장후 로그인메인으로 이동
	if(flag)
	{
		//로그인중인지를 알수있는 세션저장
		session.setAttribute("loginok", "yes");
		//아이디와 체크값 저장
		session.setAttribute("idok", id);
		//체크하면 값으로 on,체크안하면 null값 저장
		session.setAttribute("saveok", save);
		
		//세션유지시간
		session.setMaxInactiveInterval(60*60*8);//8시간 유지
		//로그인메인으로 이동
		response.sendRedirect("loginMain.jsp");
	}else{
		%>
		<script type="text/javascript">
		  alert("아이디와 비밀번호가 맞지않습니다");
		  history.back();
		</script>
	<%}
  
%>
</body>
</html>