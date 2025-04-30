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
</head>
<body>
<form action="ex9_action.jsp" method="post">
   <table class="table" style="width: 300px;">
      <tr>
        <th width="100">거주지역</th>
        <td>
          <select  class="form-control" name="city">
             <option value="서울">서울</option>
             <option value="경기">경기</option>
             <option value="대구">대구</option>
             <option value="대전">대전</option>
             <option value="부산">부산</option>
             <option value="제주">제주</option>
             <option value="세종">세종</option>
          </select>
        </td>
      </tr>
      
      <tr>
        <th width="100">희망 거주 지역</th>
        <td>
          <select size="7"  class="form-control" name="city2" multiple="multiple">
             <option value="서울">서울</option>
             <option value="경기">경기</option>
             <option value="대구">대구</option>
             <option value="대전">대전</option>
             <option value="부산">부산</option>
             <option value="제주">제주</option>
             <option value="세종">세종</option>
          </select>
        </td>
      </tr>
      
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="희망지역선택">
        </td>
      </tr>
   </table>
</form>
</body>
</html>