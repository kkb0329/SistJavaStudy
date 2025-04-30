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
<body>
<div style="margin: 100px 100px; width: 600px;">

	<form action="addAction.jsp" method="post" name="frm">
	  <table class="table table-bordered">
	     <tr>
	       <th>이름</th>
	       <td>
	         <input type="text" name="name" required="required"
	         class="form-control" style="width: 150px;">
	       </td>
	     </tr>
	     
	     <tr>
	       <th>연령대</th>
	       <td>
	         <select name="age" class="form-control" style="width: 200px;">
	           <option value="10">10대</option>
	           <option value="20">20대</option>
	           <option value="30">30대</option>
	           <option value="40">40대</option>
	           <option value="50">50대</option>
	           <option value="기타">해당연령없음</option>
	         </select>
	       </td>
	     </tr>
	     
	     <tr>
	       <th>연락처</th>
	       <td class="input-group">
	         <select name="hp1" class="form-control" style="width: 50px;">
	           <option>010</option>
	           <option>011</option>
	           <option>02</option>
	           <option>031</option>
	         </select>&nbsp;&nbsp;
	         <b>-</b>&nbsp;&nbsp;
	         <input type="text" name="hp2" required="required"
	         class="form-control" style="width: 50px;"
	         onkeyup="goFocus(this)">&nbsp;&nbsp;
	         <b>-</b>&nbsp;&nbsp;
	         <input type="text" name="hp3" required="required"
	         class="form-control" style="width: 50px;">&nbsp;&nbsp;
	       </td>
	     </tr>
	     <tr>
	       <th>가능언어</th>
	       <td>
	         <input type="checkbox" name="lang1" value="영어">영어&nbsp;
	         <input type="checkbox" name="lang1" value="일본어">일본어&nbsp;
	         <input type="checkbox" name="lang1" value="중국어">중국어&nbsp;
	         <input type="checkbox" name="lang1" value="스페인어">스페인어&nbsp;
	         <input type="checkbox" name="lang1" value="불어">불어&nbsp;
	       </td>
	     </tr>
	     <tr>
	       <th>생년월일</th>
	       <td>
	         <input type="date" name="birth" class="form-control"
	         style="width: 200px;" value="2000-01-01" required="required">
	       </td>
	     </tr>
	     <tr>
	       <td colspan="2" align="center">
	         <input type="submit" value="db저장" class="btn btn-outline-info">
	         <input type="button" value="목록가기" class="btn btn-outline-success"
	         onclick="location.href='gaipList.jsp'">
	       </td>
	     </tr>
	  </table>
	</form>
</div>
</body>
</html>