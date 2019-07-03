<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디=${memberVO.id}<br/>
이름=${memberVO.name}<br/>

세션값(자바) : <%= session.getAttribute("login") %>
세션값(표현언어) : ${sessionScope.login } 
</body>
</html>