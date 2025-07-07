<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
</head>
<body>
  <div class="alert alert-success" style="width: 800px;">
     <b>총 ${totalCount }개의 상품이 입고중입니다</b>
   </div>
  
  <table  class="table " style="width: 800px;">
     <caption>
        <span style="float: right;">
          <button type="button" class="btn btn-info"
          onclick="location.href='ipgoform'">상품추가</button>
        </span>
     </caption>
     
     <c:forEach var="dto" items="${list }" >
       <tr>
          <td width="400" rowspan="4" align="center">
             <c:if test="${dto.photoname!='no' }">
                <c:forTokens var="pn" items="${dto.photoname }" delims="," begin="0" end="0">
                   <a><img src="../save/${pn }" style="width: 150px; height: 150px;"></a>
                </c:forTokens>
             </c:if>
             <c:if test="${dto.photoname=='no' }">
                <img alt="" src="../noimage.png" style="width: 150px; height: 150px;">
             </c:if>
          </td>
          <td>
             상품명:  ${dto.sangpum }
          </td>
       </tr>
       <tr>
         <td>
             단가: <fmt:formatNumber value="${dto.price }" type="currency"/>
         </td>
       </tr>
       <tr>
         <td>
             입고일: <fmt:formatDate value="${dto.ipgoday }" pattern="yyyy-MM-dd HH:mm"/>
         </td>
       </tr>
       <tr>
         <td>
           <button type="button" class="btn btn-outline-primary"
           onclick="location.href=''">수정</button>
           <button type="button" class="btn btn-outline-danger"
           onclick="location.href=''">삭제</button>
         </td>
       </tr>
     </c:forEach>
  </table>

</body>
</html>