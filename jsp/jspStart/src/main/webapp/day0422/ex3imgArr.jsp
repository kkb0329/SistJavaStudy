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
  .main_img{
    width: 120px;
    height: 160px;
    border: 1px solid gray;
  }
</style>

</head>
<body>
<%
    String [] imgArr1={"1","3","4","6","7","12","10","3","5"};
    int n=0;
%>

<table>
    <%
      for(int i=0;i<3;i++) //행
      {%>
    	  <tr height="70">
    	     <%
    	       for(int j=0;j<3;j++) //열
    	       {%>
    	    	   <td>
    	    	     <img src="../image/연예인사진/<%=imgArr1[n]%>.jpg"
    	    	     width="150" height="150">
    	    	   </td>
    	       <%
    	         n++;
    	       }
    	     %>
    	  </tr>
      <%}
    %>
</table>

<hr>
<h2>쇼핑몰사진 을 4행5열로 출력해주세요..배열선언없이 이미지20개출력 
너비높이 120*160출력</h2>

<table>
<%
  int s=0;
for(int row=1;row<=4;row++)//행
{%>
	<tr>
	  <%
	    for(int col=1;col<=5;col++)//열
	    {
	    	s++;
	    	%>
	    	<td>
	    	  <img alt="" src="../image/쇼핑몰사진/<%=s%>.jpg" class="main_img">
	    	</td>
	    <%}
	  %>
	</tr>
<%}
%>


</table>

<h2>만화이미지 20개를 출력해주세요  01~20  5행4열로 출력해주세요</h2>
<table>
<%
  int a=1;
for(int row=1;row<=5;row++)//행
{%>
	<tr>
	  <%
	    for(int col=1;col<=4;col++)//열
	    {
	    	
	    	%>
	    	<td>
	    	  <img alt="" src="../image/만화이미지/<%=a<10?"0":"" %><%=a %>.png" class="main_img">
	    	</td>
	    <%
	    a++;
	    }
	  %>
	</tr>
<%}
%>


</table>
  


</body>
</html>