<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> 멤버리스트 </h3>

<table border='1'>

<tr>
	<td>아이디</td><td>이름</td><td>나이</td>
</tr>
<c:forEach var='a' items='${memberVOList.list}'>
<c:if test="${a.state}">
<tr>
	<td>${a.id}</td>
	<td>${a.name}</td>
	<td>${a.age}</td>
</tr>
</c:if>
</c:forEach>


</table>
</body>
</html>