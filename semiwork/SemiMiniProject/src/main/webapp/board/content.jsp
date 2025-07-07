<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.BoardDto"%>
<%@page import="data.dao.BoardDao"%>
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
<%
  String num=request.getParameter("num");

  BoardDao dao=new BoardDao();
  BoardDto dto=dao.getData(num);
  //조회수 증가
  dao.updateReadCount(num);
  
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM- dd HH:mm");
%>
<body>
  <div class="boardcontent">
    <table class="table table-bordered" style="width: 500px;">
      <caption align="top"><b>내용 확인</b></caption>
      <tr>
        <td>
          <b style="font-size: 1.3em;"><%=dto.getSubject() %></b>
          <br>
          <b><%=dto.getWriter() %></b>
          <span style="color: gray;"><%=sdf.format(dto.getWriteday()) %></span>&nbsp;&nbsp;&nbsp;&nbsp;
          <span style="color: gray;">조회  <%=dto.getReadcount() %></span>
        </td>
      </tr>
      <tr height="250">
        <td style="padding: 20px 20px;">
          
            <%=dto.getContent().replace("\n", "<br>") %>
            
            <br><br><br><br>
            <!-- 버튼들 -->
            <div class="buttons" style="float: right; ">
              <button type="button" class="btn btn-outline-success"
              onclick="location.href='index.jsp?main=board/writeform.jsp'">글쓰기</button>
              <button type="button" class="btn btn-outline-success"
              onclick="location.href='index.jsp?main=board/writeform.jsp?num=<%=num%>&regroup=<%=dto.getRegroup()%>&restep=<%=dto.getRestep()%>&relevel=<%=dto.getRelevel()%>'">답글</button>
              <button type="button" class="btn btn-outline-success"
              onclick="location.href=''">수정</button>
              <button type="button" class="btn btn-outline-success"
              onclick="location.href='index.jsp?main=board/deletepassform.jsp?num=<%=num%>'">삭제</button>
              <button type="button" class="btn btn-outline-success"
              onclick="location.href='index.jsp?main=board/boardlist.jsp'">목록</button>
            </div>
          
        </td>
      </tr>
    </table>
  </div>
</body>
</html>