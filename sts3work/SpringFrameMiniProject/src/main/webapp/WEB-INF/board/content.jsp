<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
  $(function(){
	  $("i.adel").click(function(){
		 var idx= $(this).attr("idx");
		 //alert(idx);
		 
		 var pass=prompt("비밀번호를 입력해주세요");
		 //alert(pass);
		 if(pass==null) //취소시 함수종료
			 return;
		 
		 
		 $.ajax({
			 type:"get",
			 url:"adelete",
			 dataType:"json",
			 data:{"idx":idx,"pass":pass},
			 success:function(res){
				 if(res.check==0){
					 alert("비밀번호가 맞지않습니다");
				 }else{
					 alert("댓글을 삭제했습니다");
					 location.reload();
				 }
			 }
		 });
	  })
  })
  
  
  
  
</script>
</head>
<body>
  <table class="table table-bordered" style="width: 600px;">
     <tr>
       <td>
         <h3>${dto.subject }</h3>
         
         <span style="float: right; margin-right: 20px;">조회  ${dto.readcount }&nbsp;&nbsp;&nbsp;&nbsp;
           <fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd"/>
         </span>
         <br>
         <h6>작성자  ${dto.writer }</h6>
         <br>
         <div>
           <c:if test="${dto.photo!='no' }">
              <c:forTokens var="pho" items="${dto.photo }" delims=",">
                <div>
                 <a href="../board/download?clip=${pho }">
                    <i class="bi bi-download"></i>
                    <span>${pho }</span>
                 </a></div>
              </c:forTokens>
           </c:if>
         </div>
       </td>
     </tr>
     
     <tr height="200">
       <td>
         <pre>
            ${dto.content }
         </pre>
         
         <c:if test="${dto.photo!='no' }">
            <c:forTokens var="im" items="${dto.photo }" delims=",">
               <a href="../photo/${im }"><img src="../photo/${im }" 
               style="width: 80px; height: 80px; border-radius: 20px;
               border: 2px solid purple;"></a>
            </c:forTokens>
         </c:if>
       </td>
     </tr>
     
     <!--댓글  -->
     <tr>
       <td>
          <div id="answer">
          <b>댓글 ${acount }</b><br><br>
          <c:forEach var="a"  items="${alist }">
             ${a.nickname } : ${a.content } &nbsp;&nbsp;&nbsp;
             <span style="color: gray; font-size: 0.9em;">
                <fmt:formatDate value="${a.writeday }" pattern="yyyy-MM-dd HH:mm"/>
             </span> &nbsp;&nbsp; 
             <i class="amod bi bi-pencil-fill" style="cursor: pointer;"></i>
             <i class="adel bi bi-x" style="cursor: pointer;" idx=${a.idx }></i><br>
          </c:forEach>
          
          
          </div>
          
          <form action="ainsert" method="post">
            <input type="hidden" name="num" value="${dto.num }">
            <input type="hidden" name="currentPage" value="${currentPage }">
            <div class="input-group">
            
            <input type="text" name="nickname" class="form-control"
            style="max-width: 100px;" required="required" placeholder="닉네임">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="password" name="pass" class="form-control"
            style="max-width: 100px;" required="required" placeholder="비밀번호"></div>
            <br>
            <input type="text" name="content" class="form-control"
            style="width: 500px;" required="required" placeholder="댓글내용입력">
            <button type="submit" class="btn btn-info btn-sm">확인</button>
          </form>
       </td>
     </tr>
     
     
     <tr>
       <td align="right">
         <button type="button" class="btn btn-outline-warning"
         onclick="location.href='form'">글쓰기</button>
          <button type="button" class="btn btn-outline-warning"
         onclick="location.href='form?num=${dto.num}&regroup=${dto.regroup }&restep=${dto.restep }&relevel=${dto.relevel }&currentPage=${currentPage }'">답글</button>
          <button type="button" class="btn btn-outline-warning"
         onclick="location.href='updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
          <button type="button" class="btn btn-outline-warning"
         onclick="location.href='delete?num=${dto.num}&currentPage=${currentPage}'">삭제</button>
          <button type="button" class="btn btn-outline-warning"
         onclick="location.href='list'">목록</button>
       </td>
     </tr>
  </table>
</body>
</html>