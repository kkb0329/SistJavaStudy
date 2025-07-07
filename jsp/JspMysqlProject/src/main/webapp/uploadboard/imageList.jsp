<%@page import="java.text.SimpleDateFormat"%>
<%@page import="uploadboard.UploadDto"%>
<%@page import="java.util.List"%>
<%@page import="uploadboard.UploadDao"%>
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
  a{
    text-decoration: none;
    color: black;
  }
</style>
</head>
<%
  UploadDao dao=new UploadDao();
  List<UploadDto> list=dao.getAllDatas();
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
<div style="margin: 100px 50px;">
  <table style="width: 1000px;">
     <caption align="top"><b>앨범형 목록보기</b>
       <button type="button" class="btn btn-warning btn-sm"
          onclick="location.href='boardList.jsp'" style="margin-left: 650px;">목록형게시판</button>
     </caption>
     
     <tr>
       <%
        for(int i=0;i<list.size();i++){
        	UploadDto dto=list.get(i);
        	%>
        	<td>
	        	<a href="detailView.jsp?num=<%=dto.getNum()%>">
	        	   <img alt="" src="../save/<%=dto.getImgname()%>"
	        	   style="width: 200px; height: 200px; border: 1px solid gray; margin: 5px;">
	        	   <br>
	        	   <h6><b><%=dto.getSubject() %></b></h6>
	        	</a>
	        	
	        	<b style="font-size: 10pt;"><%=dto.getWriter() %></b>
	        	<br>
	        	<span style="color: gray; font-size: 9pt;"><%=sdf.format(dto.getWriteday()) %></span>
	        	<span style="color: gray; font-size: 9pt;">조회수: <%=dto.getReadcount() %></span>
	        	<br><br><br>
        	</td>
        <%
          if((i+1)%5==0){%>
        	  </tr>
        	  <tr>
         <% }
        
        }
       %>
     </tr>
  </table>
  </div>
</body>
</html>