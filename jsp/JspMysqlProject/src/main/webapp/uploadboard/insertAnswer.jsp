<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="dao" class="uploadboard.UboardAnswerDao"/>
 <jsp:useBean id="dto" class="uploadboard.UboardAnswerDto"/>
 <jsp:setProperty property="*" name="dto"/>
<%
 //request읽기
 //dto묶어서
 //insert넘기기
 dao.insertAnswer(dto);
%>