<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
  MultipartRequest multi=null;

  //톰캣에 업로드된 프로젝트 경로 구하기
  ServletContext context=getServletContext();
  //업로드된 실제경로 구하기
  String realPath=context.getRealPath("/save");
  
  System.out.println(realPath);
  
  //업로드시 허용할 사이즈 지정
  int uploadsize=1024*1024*3; //3mb
  
  
  //생성자
  try{
  multi=new MultipartRequest(request,realPath,uploadsize,"utf-8",new DefaultFileRenamePolicy());

  //입력값들 읽어오기
  String writer=multi.getParameter("writer");
  
  //파일타입이 여러개인경우
  Enumeration fileNames=multi.getFileNames(); //input의 타입이 file만 얻어옴
  
  while(fileNames.hasMoreElements())
  {
	  //파일태그의 name얻기
	  String fileName=(String)fileNames.nextElement();
	  System.out.println("file type의 name: "+fileName); //확인
	  
	  //실제 업로드된 파일명 얻기
	  String uploadFileName=multi.getFilesystemName(fileName);
	  //파일선택을 안했을경우 null값
	  if(uploadFileName!=null){%>
		  
		  <h3>작성자: <%=writer %></h3>
		  <figure>
		    <img alt="" src="../save/<%=uploadFileName%>"
		    style="max-width: 200px;">
		    <figcaption><%=uploadFileName %></figcaption>
		  </figure>
	  <%}
  }
  
  
  
  
  }catch(Exception e){
	  
  }
%>
</body>
</html>