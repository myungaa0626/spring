<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<h2>Welcome! ${name}</h2>

		<h2>관리자 페이지입니다.</h2>
		당신은 관리자 권한이시군요!!!
		<a href="${path}/user/logout.do">로그아웃</a>
		<a href=../user/updateMyForm.do>자기정보 수정</a>
</body>
</html>



















