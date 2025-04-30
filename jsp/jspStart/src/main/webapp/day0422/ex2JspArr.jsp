<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	//배열선언
	String [] colors={"green","gray","pink","orange","magenta"};
	//제목선언
	String title="배열출력";
%>

<table class="table table-bordered" style="width: 300px;">
	<caption align="top"><b><%=title %></b></caption>
	<tr>
	   <th>번호</th>
	   <th>색상</th>
	</tr>
	<%
	  for(int i=0;i<colors.length;i++)
	  {%>
		 <tr>
		   <td><%=i+1 %></td>
		   <td>
		      <b style="color: <%=colors[i]%>"><%=colors[i] %></b>
		   </td>
		 </tr>
	  <%}
	%>

</table>

<hr>
<table class="table table-bordered">
	<tr>
	   <td colspan="8" align="center">
	      <b style="font-size: 2em">전체 구구단</b>
	   </td>
	</tr>
	<tr>
	  <%
	    for(int dan=2;dan<=9;dan++)
	    {%>
	    	<td align="center"><b><%=dan %>단</b></td>
	    <%}
	  %>
	</tr>
	
	<%
	  for(int i=1;i<=9;i++)
	  {%>
		  <tr>
		  <%
		    for(int dan=2;dan<=9;dan++)
		    {%>
		    	<td align="center">
		    	<%=dan %>X<%=i %>=<%=dan*i %>
		    	</td>
		    <%}
		  %>
		  </tr>
	  <%}
	%>
	
	
</table>

<hr>

<%
   List<String> list=new ArrayList();

   list.add("yellow");
   list.add("pink");
   list.add("gray");
   list.add("cyan");
   
   for(String a:list)
   {%>
	  <div style="width: 100px; height: 100px; background-color: <%=a%>"><%=a %></div> 
   <%}
%>






</body>
</html>