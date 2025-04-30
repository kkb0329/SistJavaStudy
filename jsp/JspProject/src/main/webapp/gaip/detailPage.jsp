<%@page import="java.text.SimpleDateFormat"%>
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
   function funcDel(num){
	  var yes = confirm("삭제하시겠습니까?");
	  if(yes){
		  location.href="delete.jsp?num="+num;
	  }
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
      <table class="table table-bordered">
         <caption align="top"><h2 class="alert alert-success"><%=dto.getName() %>님의 가입정보</h2></caption>
        <tr>
           <th width="200" class="table-success">연령대</th>
           <td><%=dto.getAge() %>대</td>
        </tr>
        <tr>
           <th width="200" class="table-success">핸드폰</th>
           <td><%=dto.getHp() %></td>
        </tr>
        <tr>
           <th width="200" class="table-success">생년월일</th>
           <td><%=dto.getBirth() %></td>
        </tr>
        <tr>
           <th width="200" class="table-success">가능한 언어</th>
           <td><%=dto.getLang().equals("no")?"가능언어 없음":dto.getLang() %></td>
        </tr>
        <tr>
          <td colspan="2" align="right">
            <input type="button" class="btn btn-success" value="수정"
            onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">
            <input type="button" class="btn btn-success" value="삭제"
            onclick="funcDel(<%=num%>)">
            <input type="button" class="btn btn-success" value="목록"
            onclick="location.href='gaipList.jsp'">
          </td>
        </tr>
      </table>
   </div>
</body>
</html>