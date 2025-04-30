<%@page import="java.text.SimpleDateFormat"%>
<%@page import="gaip.GaipDto"%>
<%@page import="java.util.Vector"%>
<%@page import="gaip.GaipDao"%>
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
<%
  GaipDao dao=new GaipDao();
  Vector<GaipDto> list=dao.getAllGaips();
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
<div style="margin: 100px 100px; width: 900px;">
   <table class="table table-bordered">
      <tr>
        <th width="80">번호</th><th width="120">회원명</th><th width="200">연락처</th><th width="280">가입일자</th><th width="150">상세보기</th>
      </tr>
      <%
        if(list.size()==0){
        	%>
        	<tr>
        	  <td colspan="5" align="center">
        	     <h3>가입한 회원정보가 없습니다</h3>
        	  </td>
        	</tr>
        <%}else{
        	for(int i=0;i<list.size();i++){
        		
        		GaipDto dto=list.get(i);%>
        		
        		<tr>
        		  <td><%=list.size()-i %></td>
        		  <td><%=dto.getName() %></td>
        		  <td><%=dto.getHp() %></td>
        		  <td><%=sdf.format(dto.getGaipday()) %></td>
        		  <td>
        		     <button type="button" class="btn btn-warning"
        		     onclick="location.href='detailPage.jsp?num=<%=dto.getNum()%>'">상세보기</button>
        		  </td>
        		</tr>
        	<%}
        }
      %>
      
      
   </table>
</div>
</body>
</html>