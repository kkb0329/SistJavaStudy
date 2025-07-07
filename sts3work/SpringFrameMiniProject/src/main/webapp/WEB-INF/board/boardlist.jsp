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
</head>
<body>
<table class="table table-bordered" style="width: 800px;">
   <caption align="top"><b>답변형 게시판 목록</b>
     <span><button type="button" class="btn btn-success btn-sm"
     onclick="location.href='form'">글쓰기</button></span>
   </caption>
   
   <tr>
     <th width="80">번호</th>
     <th width="280">제목</th>
     <th width="100">작성자</th>
     <th width="180">작성일</th>
     <th width="80">조회</th>
   </tr>
   
   <c:if test="${totalCount==0 }">
      <tr>
        <td colspan="5" align="center">
          <b>등록된 게시글이 없습니다</b>
        </td>
      </tr>
   </c:if>
   
   <c:if test="${totalCount>0 }">
     <c:forEach var="dto"  items="${list }">
       <tr>
         <td>${no }</td>
         <c:set var="no" value="${no-1 }"/> <!-- 출력후 감소 -->
         
         <td>
         <!-- relevel만큼 공백 -->
         <c:forEach  begin="1" end="${dto.relevel }">
            &nbsp;&nbsp;
         </c:forEach>
         
         <!-- 답글인경우에만 re.png이미지출력 -->
         <c:if test="${dto.relevel>0 }">
            <img alt="" src="../image/mini/re.png">
         </c:if>
         
         <a href="content?num=${dto.num }&currentPage=${currentPage}">${dto.subject }</a>
         
         
         
         <!-- 사진이 있을경우 아이콘표시 -->
         <c:if test="${dto.photo!='no' }">
         	<i class="bi bi-image" style="color: gray;"></i>
         </c:if>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <!--댓글갯수출력  -->
         <c:if test="${dto.acount>0 }">
           <a href="content?num=${dto.num }&currentPage=${currentPage}#answer"
           style="color: red;">[${dto.acount }]</a>
         </c:if>
         
         </td>
         
         
         
         
         
         
         
         <td>${dto.writer }</td>
         <td>
            <fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
         </td>
         <td>${dto.readcount }</td>
       </tr>
     </c:forEach>
   </c:if>
</table>

<!--페이지 번호 출력  -->
     <div style="width: 800px;">
     <ul class="pagination justify-content-center">
     
     <!-- 이전 -->
        <c:if test="${startPage>1 }">
           <li class="page-item">
        	    <a class="page-link" href="list?currentPage=${startPage-1 }"
        	    style="color: black;">
        	      이전
        	    </a>
        	  </li>
        </c:if>
        
        <!-- 페이지번호-->
        <c:forEach  var="pp" begin="${startPage }" end="${endPage }">
          <c:if test="${pp==currentPage }">
              <li class="page-item active">
       				  <a class="page-link" href="list?currentPage=${pp }">${pp }</a>
       	      </li>
          </c:if>
          <c:if test="${pp!=currentPage }">
              <li class="page-item">
       				  <a class="page-link" href="list?currentPage=${pp }">${pp }</a>
       	      </li>
          </c:if>
        </c:forEach>
       <!-- 다음 -->
       <c:if test="${endPage<totalPage }">
          <li class="page-item">
        	    <a class="page-link" href="list?currentPage=${endPage+1 }"
        	    style="color: black;">
        	      다음
        	    </a>
        	  </li>
       </c:if>
       </ul>
    </div>

</body>
</html>