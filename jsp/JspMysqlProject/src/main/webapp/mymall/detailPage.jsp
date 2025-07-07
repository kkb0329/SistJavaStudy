<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="mymall.MymallDto"%>
<%@page import="mymall.MymallDao"%>
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
	*{
		 font-family: 'Nanum Myeongjo';
	}
	tr {
	text-align: center;
	}
	.box {
		width: 40px; height: 40px;
		border-radius: 100px;
		box-shadow: 5px 5px 5px gray;
		
		
	}
</style>

</head>
<body>
  <%
	//num을 읽는다
	String num = request.getParameter("num");
	//dao선언
	MymallDao dao = new MymallDao();
	//num에 해당하는 dto얻기
	MymallDto dto = dao.getSangpum(num);
	
	NumberFormat nf = NumberFormat.getCurrencyInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH시");
%>
	<div style="margin: 100px 100px;">				
		<table class="table table-bordered" style="width: 700px; height: 50px; line-height: 50px;">
			<caption align="top"><h1><b style="color: <%=dto.getColor()%>">상품 상세보기</b></h1></caption>
			<tr>
				<td rowspan="5">
					<img src="../image/쇼핑몰사진/<%=dto.getPhoto() %>.jpg">
				</td>
			</tr>
			<tr>
				<th width="100px" >상품명</th>
				<td>
					<%=dto.getSangpum()%>
				</td>
			</tr>
			<tr>		
				<th width="100px" >색상</th>
				<td align="center">
					
					<div class="box" style="background-color: <%=dto.getColor()%>"></div>
				</td>
			</tr>
			<tr>
				<th width="100px" >가격</th>
				<td>
					<%=nf.format(dto.getPrice())%>
				</td>
			</tr>
			
			<tr>
				<th width="100px" >등록일</th>
				<td>
					<%=sdf.format(dto.getWriteday())%>
				</td>
			</tr>
			<tr>
			<td colspan="3" align="center">
				<button type="button" class="btn btn-outline-warning" 
				onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'"> 수정</button>
				<button type="button" class="btn btn-outline-primary" 
				onclick="location.href='delete.jsp?num=<%=dto.getNum()%>'"> 삭제</button>
				<button type="button" class="btn btn-outline-success" 
				onclick="location.href='mallList.jsp'"> 목록</button>
			</td>
			</tr>
		</table>
	</div>

</body>
</html>