<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp HOME  page</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
	<h2>Welcome!</h2>
	<h2>${msg}</h2>
	<h3>${key}</h><p>
	<a href="${path}/admin/">관리자 페이지</a><br>
	<a href="${path}/user/">일반 사용자 페이지</a><br>
	<a href="${path}/user/logout.do">로그아웃</a>
</body>
</html>

























