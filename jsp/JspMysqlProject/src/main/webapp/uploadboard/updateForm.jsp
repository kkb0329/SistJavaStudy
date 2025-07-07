<%@page import="uploadboard.UploadDto"%>
<%@page import="uploadboard.UploadDao"%>
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
  #showimg{
    position: absolute;
    left: 650px;
    top: 100px;
  }
</style>
<script type="text/javascript">
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#showimg').attr('src', e.target.result); 
		}
		reader.readAsDataURL(input.files[0]);
	}
}

</script>
</head>
<%
  String num=request.getParameter("num");
  UploadDao dao=new UploadDao();
  UploadDto dto=dao.getData(num);
  String currentPage=request.getParameter("currentPage");
%>
<body>
<div style="margin: 100px 100px; width: 500px;">
  <form action="updateAction.jsp" method="post" enctype="multipart/form-data">
  <!-- hidden num -->
  <input type="hidden" name="num" value="<%=num%>">
  <input type="hidden" name="currentPage" value="<%=currentPage%>">
	  <table class="table table-bordered">
	     <tr>
	       <th class="table-warning">작성자</th>
	       <td>
	         <b><%=dto.getWriter() %></b>
	       </td>
	     </tr>
	     <tr>
	       <th class="table-warning">제목</th>
	       <td>
	         <input type="text" name="subject" class="form-control"
	         style="width: 350px;" required="required"
	         value="<%=dto.getSubject()%>">
	       </td>
	     </tr>
	     
	     <tr>
	       <th class="table-warning">사진업로드</th>
	       <td>
	         <input type="file" name="photo" class="form-control"
	         style="width: 250px;" required="required"
	         onchange="readURL(this);" >
	       </td>
	     </tr>
	     <tr>
	       <th class="table-warning">비밀번호</th>
	       <td>
	         <input type="text" name="pass" class="form-control"
	         style="width: 150px;" required="required">
	       </td>
	     </tr>
	     <tr>
	       <td colspan="2">
	         <textarea style="width: 500px; height: 150px;"
	         class="form-control" name="content"
	         required="required"><%=dto.getContent() %></textarea>
	       </td>
	     </tr>
	     <tr>
	       <td colspan="2" align="center">
	         <button type="submit" class="btn btn-outline-info"
	         >수정하기</button>
	         <button type="button" class="btn btn-outline-warning"
	         onclick="history.back()">이전으로</button>
	       </td>
	     </tr>
	  </table>
  </form>
  <img id="showimg" style="max-width: 300px;" src="../save/<%=dto.getImgname()%>">
</div>
</body>
</html>