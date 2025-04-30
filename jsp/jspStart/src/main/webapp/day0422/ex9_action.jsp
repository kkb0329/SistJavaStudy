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
  request.setCharacterEncoding("utf-8");
  String city=request.getParameter("city");
  String [] city2 =request.getParameterValues("city2");
 %>
 
  현재 거주지역: <%=city %><br><br>
  희망 거주지역: 
  <%
    if(city2==null)
    {%>
    	<b style="color: red;">희망 거주지 선택안함</b>
    <%}else
    {
    	for(int i=0;i<city2.length;i++)
    	{%>
    		[<%=city2[i] %>]&nbsp;
    	<%}%>
    	
    	<b>총 <%=city2.length %>개의 희망지역을 선택함<br></b>
    <%}
  %>
   
   <a href="ex9_form.jsp">다시입력</a><br>
   <a href="javascript:history.back()">다시입력</a><br>
   
</body>
</html>