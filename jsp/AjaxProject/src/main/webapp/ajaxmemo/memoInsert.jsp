<%@page import="ajaxmemo.MemoDto"%>
<%@page import="ajaxmemo.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   // ajax의 insert 처리 페이지
   //dao선언
   MemoDao dao=new MemoDao();
   
	//엔코딩
	request.setCharacterEncoding("utf-8");
	//폼에서 넘긴값 읽기(writer,content,emot)
	String writer=request.getParameter("writer");
	String content=request.getParameter("content");
	String emot=request.getParameter("emot");
	
	//dto로 묶어서
	MemoDto dto=new MemoDto();
	dto.setWriter(writer);
	dto.setContent(content);
	dto.setEmot(emot);
	
	//인서트 메서드 호출
	dao.insertMemo(dto);

%>