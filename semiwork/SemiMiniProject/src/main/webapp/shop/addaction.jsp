<%@page import="data.dto.ShopDto"%>
<%@page import="data.dao.ShopDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String uploadPath=getServletContext().getRealPath("/shopsave");
	System.out.println(uploadPath);
	int uploadSize=1024*1024*2;//2mb;
	
	MultipartRequest multi=null;
	try{
		multi=new MultipartRequest(request,uploadPath,uploadSize,
				"utf-8",new DefaultFileRenamePolicy());
		String sangpum=multi.getParameter("sangpum");
		String category=multi.getParameter("category");
		String ipgoday=multi.getParameter("ipgoday");
		int price=Integer.parseInt(multi.getParameter("price"));
		String sang_photo=multi.getFilesystemName("sang_photo");
		System.out.println(sang_photo);
		
		//dao 선언
		ShopDao dao=new ShopDao();
		//dto 에 데이타 넣기
		ShopDto dto=new ShopDto();
		dto.setSangpum(sangpum);
		dto.setCategory(category);
		dto.setIpgoday(ipgoday);
		dto.setPhoto(sang_photo);
		dto.setPrice(price);
		
		//db 에 추가
		dao.insertShop(dto);
		
		//다시 상품폼으로 이동
		response.sendRedirect("../index.jsp?main=shop/addform.jsp");
	}catch(Exception e){
		System.out.println("업로드 오류 :"+e.getMessage());
	}
%>

    