<%@page import="data.dao.SmartAnswerDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SmartDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.SmartDao"%>
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
<script type="text/javascript">
  $(function(){
	  
	  //전체클릭시 체크값모두얻어서 그체크값 전달하기
	  $(".alldelcheck").click(function(){
		  
		  //전체체크얻기
		  var chk=$(this).is(":checked");
		  console.log(chk);
		  
		  //전체체크를 번호의 체크에 일괄전달(prop)
		  $(".alldel").prop("checked",chk);
		  
		  
		  
	  });
	  
	//삭제버튼클릭시 삭제
	  $("#btndel").click(function(){
		  
		  //체크된길이
		  var len=$(".alldel:checked").length;
		 // alert(len);
		 
		 if(len==0){
			 alert("최소1개이상의 글을 선택해주세요");
		 }else{
			 
			 var a=confirm(len+"개의 글을 삭제하려면 [확인]을 눌러주세요");
			 
			 //체크된 value의 num값 얻기
			 var n="";
			 
			 $(".alldel:checked").each(function(idx){
				 
				 n+=$(this).val()+",";
			 });
			 
			 //마지막컴마제거
			 n=n.substring(0,n.length-1);
			 console.log(n);
			 
			 //삭제파일로 전송
			 location.href="smart/alldelete.jsp?nums="+n;
		 }
		 
		  
	  });
	  
  });
</script>
<title>Insert title here</title>
</head>
<%
  //dao
  SmartDao dao=new SmartDao();
  List<SmartDto> list=dao.getAllDatas();
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
  
  
  SmartAnswerDao adao=new SmartAnswerDao(); //댓글에 관한 dao
  
  for(SmartDto dto:list)
  {
	  //댓글변수에 댓글총갯수 넣기
	  int acount=adao.getAnswerList(dto.getNum()).size();
	  dto.setAnswercount(acount);
  }
%>
<body>
  <div>
    <button type="button" class="btn btn-success"
    onclick="location.href='index.jsp?main=smart/smartform.jsp'">스마트폼</button>
  </div>
  
  <div class="board">
  <table class="table table-bordered" style="width: 800px;">
     <caption align="top"><b>총<%=list.size() %>개의 게시글이 있습니다</b></caption>
     <tr class="table-success">
       <th width="80">번호</th>
       <th width="380">제목</th>
       <th width="120">작성자</th>
       <th width="180">작성일</th>
       <th width="80">조회</th>
     </tr>
     <%
       if(list.size()==0)
       {%>
    	   <tr>
    	     <td colspan="5" align="center">
    	       <b>등록된 게시글이 없습니다</b>
    	     </td>
    	   </tr>
       <%}else{
       
    	   for(int i=0;i<list.size();i++)
    	   {
    	     SmartDto dto=list.get(i);
    	   %>
    		   <tr>
    		     <td align="center">
    		     <input type="checkbox" value="<%=dto.getNum()%>" class="alldel">
    		     <%=list.size()-i %>
    		     </td>
    		     <td>
    		            		        
    		        <a href="index.jsp?main=smart/content.jsp?num=<%=dto.getNum()%>"
    		        style="text-decoration: none; color: black;">
    		           <%=dto.getSubject() %></a>
    		           
    		           <!-- 댓글갯수 -->
    		           <%
    		             if(dto.getAnswercount()>0)
    		             {%>
    		            	 <a style="color: red;"
    		            	 href="index.jsp?main=smart/content.jsp?num=<%=dto.getNum()%>#alist">[<%=dto.getAnswercount() %>]</a>
    		             <%}
    		           %>
    		           
    		     </td>
    		     <td><%=dto.getWriter() %></td>
    		     <td><%=sdf.format(dto.getWriteday()) %></td>
    		     <td><%=dto.getReadcount() %></td>
    		   </tr>
    		   
    	   <%}%>
    	   
    	   <tr>
    	     <td colspan="5" >
    	       <input type="checkbox" class="alldelcheck"
    	       style="margin-left: 20px;">전체선택&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	       <span>
    	         <button type="button" class="btn btn-danger" id="btndel">삭제</button>
    	         &nbsp;&nbsp;&nbsp;
    	         <button type="button" class="btn btn-success" 
    	         onclick="location.href='index.jsp?main=smart/smartform.jsp'">글쓰기</button>
    	       </span>
    	     </td>
    	   </tr>
            
       <%}
     %>
  </table>
</div>
</body>
</html>