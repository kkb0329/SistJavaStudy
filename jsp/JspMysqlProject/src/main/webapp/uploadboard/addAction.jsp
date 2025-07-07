<%@page import="uploadboard.UploadDao"%>
<%@page import="uploadboard.UploadDto"%>
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
	//한글 엔코딩
	request.setCharacterEncoding("utf-8");
	
	//업로드에 필요한 변수 선언
	//1.업로드할 경로(톰켓에 올라가는 프로젝트 경로)
	String realFolder=getServletContext().getRealPath("/save");
	System.out.println(realFolder);
	
	//2.업로드 사이즈
	int uploadSize=1024*1024;//1mb
	
	try{
		//생성자 파라미터
		//request,업로드폴더,업로드사이즈,한글타입,
		//같은이름일경우 뒤에 1,2,3 붙이기
		MultipartRequest multi=
				new MultipartRequest(request,realFolder,
						uploadSize,"utf-8",
						new DefaultFileRenamePolicy());
		//입력값 읽기
		String writer=multi.getParameter("writer");
		String subject=multi.getParameter("subject");
		String content=multi.getParameter("content");
		String pass=multi.getParameter("pass");
		
		//실제 업로드 이미지이름 읽어오기
		String imgname=multi.getFilesystemName("photo");
		
		//dto 에 담기
		UploadDto dto=new UploadDto();
		dto.setWriter(writer);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setPass(pass);
		dto.setImgname(imgname);
		
		//db 선언
		UploadDao db=new UploadDao();
		
		//insert 메서드 호출
		db.insertBoard(dto);
		
		//목록으로 이동
		response.sendRedirect("boardList.jsp");
	}catch(Exception e)
	{
		System.out.println("업로드 오류:"+e.getMessage());
	}
%>

</body>
</html>