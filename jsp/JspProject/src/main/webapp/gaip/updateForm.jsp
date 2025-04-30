<%@page import="java.util.StringTokenizer"%>
<%@page import="gaip.GaipDto"%>
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
<script type="text/javascript">
  function goFocus(hp){
	  if(hp.value.length==4)
		  frm.hp3.focus();
  }
</script>
</head>
<%
  String num=request.getParameter("num");
  GaipDao dao=new GaipDao();
  GaipDto dto=dao.getData(num);
%>
<body>
<div style="margin: 100px 100px; width: 600px;">

	<form action="updateAction.jsp" method="post" name="frm">
	
	<input type="hidden" name="num" value="<%=num%>">
	  <table class="table table-bordered">
	     <tr>
	       <th>이름</th>
	       <td>
	         <input type="text" name="name" required="required"
	         class="form-control" style="width: 150px;"
	         value=<%=dto.getName()%>>
	       </td>
	     </tr>
	     
	     <tr>
	       <th>연령대</th>
	       <td>
	         <select name="age" class="form-control" style="width: 200px;">
	           <%
	           String [] str={"10","20","30","40","50","기타"};
	           
	           for(int i=0;i<str.length;i++)
	           {
	        	   if(dto.getAge().equals(str[i]))
	        	   {%>
	        		   <option value="<%=str[i]%>" selected="selected">
	        		      <%=str[i] %>대
	        		   </option>
	        	   <%}else{%>
	        		   <option value="<%=str[i]%>"><%=str[i] %>대</option>
	        	   <%}
	           }
	           
	           %>
	         </select>
	       </td>
	     </tr>
	     
	     <tr>
	     <%
	       //-하이픈 구분자로 분리
	       StringTokenizer st=new StringTokenizer(dto.getHp(),"-");
	       String hp1=st.nextToken();
	       String hp2=st.nextToken();
	       String hp3=st.nextToken();
	     %>
	     
	       <th>연락처</th>
	       <td class="input-group">
	         <select name="hp1" class="form-control" style="width: 50px;">
	           <option <%=hp1.equals("010")?"selected":"" %>>010</option>
	           <option <%=hp1.equals("011")?"selected":"" %>>011</option>
	           <option <%=hp1.equals("02")?"selected":"" %>>02</option>
	           <option <%=hp1.equals("031")?"selected":"" %>>031</option>
	         </select>&nbsp;&nbsp;
	         <b>-</b>&nbsp;&nbsp;
	         <input type="text" name="hp2" required="required"
	         class="form-control" style="width: 50px;"
	         onkeyup="goFocus(this)" value="<%=hp2%>">&nbsp;&nbsp;
	         <b>-</b>&nbsp;&nbsp;
	         <input type="text" name="hp3" required="required"
	         class="form-control" style="width: 50px;" value="<%=hp3%>">&nbsp;&nbsp;
	       </td>
	     </tr>
	     <tr>
	       <th>가능언어</th>
	       <td>
	         <input type="checkbox" name="lang1" value="영어"
	         <%=dto.getLang().contains("영어")?"checked":"" %>>영어&nbsp;
	         <input type="checkbox" name="lang1" value="일본어"
	         <%=dto.getLang().contains("일본")?"checked":"" %>>일본어&nbsp;
	         <input type="checkbox" name="lang1" value="중국어"
	         <%=dto.getLang().contains("중국")?"checked":"" %>>중국어&nbsp;
	         <input type="checkbox" name="lang1" value="스페인어"
	         <%=dto.getLang().contains("스페인")?"checked":"" %>>스페인어&nbsp;
	         <input type="checkbox" name="lang1" value="불어"
	         <%=dto.getLang().contains("불어")?"checked":"" %>>불어&nbsp;
	       </td>
	     </tr>
	     <tr>
	       <th>생년월일</th>
	       <td>
	         <input type="date" name="birth" class="form-control"
	         style="width: 200px;" value=<%=dto.getBirth() %> required="required">
	       </td>
	     </tr>
	     <tr>
	       <td colspan="2" align="center">
	         <input type="submit" value="db수정" class="btn btn-outline-info">
	         <input type="button" value="목록가기" class="btn btn-outline-success"
	         onclick="location.href='gaipList.jsp'">
	       </td>
	     </tr>
	  </table>
	</form>
</div>
</body>
</html>