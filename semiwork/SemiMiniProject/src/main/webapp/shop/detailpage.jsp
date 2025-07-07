<%@page import="java.text.NumberFormat"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="data.dao.ShopDao"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
  $(function(){
	  
	  $("#btncart").click(function(){
		  
		  
		//form테이타 모든값 가져오기
		  var formdatas=$("#frm").serialize();
		  //alert(formdatas);
		  
		  $.ajax({
			  
			  type:"post",
			  dataType:"html",
			  data:formdatas,
			  url:"shop/detailproc.jsp",
			  success:function(){
				  //alert("성공");
				 var a=confirm("장바구니에 저장했습니다\n장바구니로 이동하려면 [확인]을 눌러주세요");
				 if(a){
					 location.href="index.jsp?main=shop/mycart.jsp";
				 }
			  }
		  });
	  })
	  
  });

</script>
</head>
<%
  String shopnum=request.getParameter("shopnum");
  //로그인상태
  String loginok=(String)session.getAttribute("loginok");
  //로그인한 아이디
  String myid=(String)session.getAttribute("myid");
  //아이디에 해당하는 멤버 시퀀스
  MemberDao mdao=new MemberDao();
  String num=mdao.getNum(myid);
  
  //해당상품의 데이타가져오기
  ShopDao sdao=new ShopDao();
  ShopDto dto=sdao.getData(shopnum);
  
%>
<body>
<div style="margin: 100px 100px;">
  <form id="frm">
    <!-- hidden :장바구니 db에 넣어야할 값들 -->
    <input type="hidden" name="shopnum" value="<%=shopnum%>">
    <input type="hidden" name="num" value="<%=num%>">
    <table  style="width: 700px;">
        <tr>
          <td style="width: 400px;">
             <div  id="photo">
                 <img alt="" src="shopsave/<%=dto.getPhoto()%>">
             </div>
          </td>
          <td >
             <h4>카테고리:  <%=dto.getCategory() %></h4>
             <h4>상품명: <%=dto.getSangpum() %></h4>
             <%
              NumberFormat nf=NumberFormat.getCurrencyInstance();
             %>
             <h4>가격: <%=nf.format(dto.getPrice()) %></h4>
             
             <div class="input-group">
             <h4>갯수: </h3>&nbsp;&nbsp;&nbsp;&nbsp;
             <input type="number" min="1" max="10" value="1" name="cnt"></div>
             
             
             <div class="buttons" style="margin-top: 100px; ">
               <button type="button" class="btn btn-success"
               id="btncart" style="width: 100px;">장바구니</button>
               <button type="button" class="btn btn-success"
                style="width: 100px;" 
                onclick="location.href='index.jsp?main=shop/shoplist.jsp'">목록</button>
             </div>
          </td>
        </tr>
    </table>
  </form>
  </div>
</body>
</html>