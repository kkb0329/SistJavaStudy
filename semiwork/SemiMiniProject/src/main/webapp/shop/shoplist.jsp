<%@page import="java.text.NumberFormat"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Hi+Melody&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<title>Insert title here</title>
<style type="text/css">
   img.photo{
      width: 200px;
      height: 230px;
      border: 1px solid gray;
      margin: 10px 10px;
   }
</style>
<script type="text/javascript">
  $(function(){
	  $("a.godetail").click(function(){
		  
		  //shopnum
		  var shopnum=$(this).attr("shopnum");
		 // alert(shopnum);
		 //디테일페이지로 이동
		 location.href="index.jsp?main=shop/detailpage.jsp?shopnum="+shopnum;
	  })
  })

</script>
</head>
<%
  ShopDao dao=new ShopDao();
  List<ShopDto> list=dao.getAllSangpums();
%>
<body>
<nav>
  <div class="nav nav-tabs" id="nav-tab" role="tablist">
    <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-total" type="button" role="tab" aria-controls="nav-home" aria-selected="true">전체목록</button>
    <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-outer" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">아우터</button>
    <button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#nav-sang" type="button" role="tab" aria-controls="nav-contact" aria-selected="false">상의</button>
    <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-ha" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">하의</button>
    <button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab" data-bs-target="#nav-acc" type="button" role="tab" aria-controls="nav-contact" aria-selected="false">액세서리</button>
    <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-blah" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">기타</button>

  </div>
</nav>
<div class="tab-content" id="nav-tabContent">
  <div class="tab-pane fade show active" id="nav-total" role="tabpanel" aria-labelledby="nav-home-tab">
     
        <table class="table table-bordered"  style="width: 1000px;">
          <caption align="top"><b>전체목록</b></caption>
          <tr>
             <%
               NumberFormat nf=NumberFormat.getCurrencyInstance();
               int i=0;
               for(ShopDto dto:list)
               {
            	   //20~40까지 난수발생
            	   int discount=(int)(Math.random()*21)+20;
            	   %>
            	   <td>
            	      <a class="godetail" shopnum=<%=dto.getShopnum() %>
            	      style="cursor: pointer;">
            	        <img alt="" src="shopsave/<%=dto.getPhoto()%>" class="photo">
            	        <br>
            	        <%=dto.getSangpum() %>
            	        <br>
            	        <b style="color: red;">
            	          <%=discount %>%
            	        </b>
            	        <span>
            	          <strike><%=nf.format(dto.getPrice()) %></strike>
            	        </span>
            	        <span>
            	           <%
            	             int price=(int)(dto.getPrice()-(dto.getPrice()*(discount/100.0)));
            	           %>
            	           <%=nf.format(price) %>
            	        </span>
            	      </a>
            	   </td>
               <%
                 if((i+1)%5==0)
                 {%>
                	 </tr>
                	 <tr>
                <% }
               i++;
               
               }
             %>
          </tr>
        </table>
     
  </div>
  <div class="tab-pane fade" id="nav-outer" role="tabpanel" aria-labelledby="nav-profile-tab">
     <table class="table table-bordered"  style="width: 1000px;">
          <caption align="top"><b>아우터</b></caption>
          <tr>
             <%
                nf=NumberFormat.getCurrencyInstance();
                i=0;
               for(ShopDto dto:list)
               {
            	   
            	   if(dto.getCategory().equals("아우터")){
            	   //20~40까지 난수발생
            	   int discount=(int)(Math.random()*21)+20;
            	   %>
            	   <td>
            	      <a class="godetail" shopnum=<%=dto.getShopnum() %>
            	      style="cursor: pointer;">
            	        <img alt="" src="shopsave/<%=dto.getPhoto()%>" class="photo">
            	        <br>
            	        <%=dto.getSangpum() %>
            	        <br>
            	        <b style="color: red;">
            	          <%=discount %>%
            	        </b>
            	        <span>
            	          <strike><%=nf.format(dto.getPrice()) %></strike>
            	        </span>
            	        <span>
            	           <%
            	             int price=(int)(dto.getPrice()-(dto.getPrice()*(discount/100.0)));
            	           %>
            	           <%=nf.format(price) %>
            	        </span>
            	      </a>
            	   </td>
               <%
                 if((i+1)%5==0)
                 {%>
                	 </tr>
                	 <tr>
                <% }
               i++;
            	  }
               }
             %>
          </tr>
        </table>
  </div>
  <div class="tab-pane fade" id="nav-sang" role="tabpanel" aria-labelledby="nav-contact-tab">
     <table class="table table-bordered"  style="width: 1000px;">
          <caption align="top"><b>상의</b></caption>
          <tr>
             <%
                nf=NumberFormat.getCurrencyInstance();
                i=0;
               for(ShopDto dto:list)
               {
            	   
            	   if(dto.getCategory().equals("상의")){
            	   //20~40까지 난수발생
            	   int discount=(int)(Math.random()*21)+20;
            	   %>
            	   <td>
            	      <a class="godetail" shopnum=<%=dto.getShopnum() %>
            	      style="cursor: pointer;">
            	        <img alt="" src="shopsave/<%=dto.getPhoto()%>" class="photo">
            	        <br>
            	        <%=dto.getSangpum() %>
            	        <br>
            	        <b style="color: red;">
            	          <%=discount %>%
            	        </b>
            	        <span>
            	          <strike><%=nf.format(dto.getPrice()) %></strike>
            	        </span>
            	        <span>
            	           <%
            	             int price=(int)(dto.getPrice()-(dto.getPrice()*(discount/100.0)));
            	           %>
            	           <%=nf.format(price) %>
            	        </span>
            	      </a>
            	   </td>
               <%
                 if((i+1)%5==0)
                 {%>
                	 </tr>
                	 <tr>
                <% }
               i++;
            	  }
               }
             %>
          </tr>
        </table>
  </div>
  
  <div class="tab-pane fade" id="nav-ha" role="tabpanel" aria-labelledby="nav-contact-tab">
     <table class="table table-bordered"  style="width: 1000px;">
          <caption align="top"><b>하의</b></caption>
          <tr>
             <%
                nf=NumberFormat.getCurrencyInstance();
                i=0;
               for(ShopDto dto:list)
               {
            	   
            	   if(dto.getCategory().equals("하의")){
            	   //20~40까지 난수발생
            	   int discount=(int)(Math.random()*21)+20;
            	   %>
            	   <td>
            	      <a class="godetail" shopnum=<%=dto.getShopnum() %>
            	      style="cursor: pointer;">
            	        <img alt="" src="shopsave/<%=dto.getPhoto()%>" class="photo">
            	        <br>
            	        <%=dto.getSangpum() %>
            	        <br>
            	        <b style="color: red;">
            	          <%=discount %>%
            	        </b>
            	        <span>
            	          <strike><%=nf.format(dto.getPrice()) %></strike>
            	        </span>
            	        <span>
            	           <%
            	             int price=(int)(dto.getPrice()-(dto.getPrice()*(discount/100.0)));
            	           %>
            	           <%=nf.format(price) %>
            	        </span>
            	      </a>
            	   </td>
               <%
                 if((i+1)%5==0)
                 {%>
                	 </tr>
                	 <tr>
                <% }
               i++;
            	  }
               }
             %>
          </tr>
        </table>
  </div>
  
  <div class="tab-pane fade" id="nav-acc" role="tabpanel" aria-labelledby="nav-contact-tab">
     <table class="table table-bordered"  style="width: 1000px;">
          <caption align="top"><b>액세서리</b></caption>
          <tr>
             <%
                nf=NumberFormat.getCurrencyInstance();
                i=0;
               for(ShopDto dto:list)
               {
            	   
            	   if(dto.getCategory().equals("액세서리")){
            	   //20~40까지 난수발생
            	   int discount=(int)(Math.random()*21)+20;
            	   %>
            	   <td>
            	      <a class="godetail" shopnum=<%=dto.getShopnum() %>
            	      style="cursor: pointer;">
            	        <img alt="" src="shopsave/<%=dto.getPhoto()%>" class="photo">
            	        <br>
            	        <%=dto.getSangpum() %>
            	        <br>
            	        <b style="color: red;">
            	          <%=discount %>%
            	        </b>
            	        <span>
            	          <strike><%=nf.format(dto.getPrice()) %></strike>
            	        </span>
            	        <span>
            	           <%
            	             int price=(int)(dto.getPrice()-(dto.getPrice()*(discount/100.0)));
            	           %>
            	           <%=nf.format(price) %>
            	        </span>
            	      </a>
            	   </td>
               <%
                 if((i+1)%5==0)
                 {%>
                	 </tr>
                	 <tr>
                <% }
               i++;
            	  }
               }
             %>
          </tr>
        </table>
  </div>
  
  <div class="tab-pane fade" id="nav-blah" role="tabpanel" aria-labelledby="nav-contact-tab">
     <table class="table table-bordered"  style="width: 1000px;">
          <caption align="top"><b>기타</b></caption>
          <tr>
             <%
                nf=NumberFormat.getCurrencyInstance();
                i=0;
               for(ShopDto dto:list)
               {
            	   
            	   if(dto.getCategory().equals("기타")){
            	   //20~40까지 난수발생
            	   int discount=(int)(Math.random()*21)+20;
            	   %>
            	   <td>
            	      <a class="godetail" shopnum=<%=dto.getShopnum() %>
            	      style="cursor: pointer;">
            	        <img alt="" src="shopsave/<%=dto.getPhoto()%>" class="photo">
            	        <br>
            	        <%=dto.getSangpum() %>
            	        <br>
            	        <b style="color: red;">
            	          <%=discount %>%
            	        </b>
            	        <span>
            	          <strike><%=nf.format(dto.getPrice()) %></strike>
            	        </span>
            	        <span>
            	           <%
            	             int price=(int)(dto.getPrice()-(dto.getPrice()*(discount/100.0)));
            	           %>
            	           <%=nf.format(price) %>
            	        </span>
            	      </a>
            	   </td>
               <%
                 if((i+1)%5==0)
                 {%>
                	 </tr>
                	 <tr>
                <% }
               i++;
            	  }
               }
             %>
          </tr>
        </table>
  </div>
  
  
</div>
</body>
</html>