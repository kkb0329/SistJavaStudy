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
</head>
<body>
<%
    String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String cbsave=request.getParameter("savechk"); //체크안하면 null
	
	MemberDao dao=new MemberDao();
	boolean b=dao.isIdPass(id, pass);
	
	//아이디와 비번이 맞으면 3개의 세션저장..
	if(b){
		//세션저장
		session.setMaxInactiveInterval(60*60*8); //8시간,생략시 30분
		
		session.setAttribute("loginok", "yes");
		session.setAttribute("myid", id);
		session.setAttribute("saveok", cbsave==null?null:"yes");
		
		//로그인메인
		response.sendRedirect("../index.jsp?main=login/loginmain.jsp");
		
	}else{%>
		<script type="text/javascript">
			alert("아이디나 비번이 맞지않습니다");
			history.back();
		</script>
		
	<%}
	

%>
</body>
</html>