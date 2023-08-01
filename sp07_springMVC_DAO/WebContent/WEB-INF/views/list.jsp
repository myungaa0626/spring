<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>List Page</h3>

	<c:forEach items="${list}" var="list">
	${list.deptno }
	${list.dname }
	${list.loc } <hr />
	</c:forEach>
	<p>


		<input type="button" value="지점저장"
			onclick="javascript:window.location.href='writeform.do'">&nbsp;
		<input type="button" value="Hello"
			onclick="javascript:window.location.href='hello.do'">
</body>
</html>