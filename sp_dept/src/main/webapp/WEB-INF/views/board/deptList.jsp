<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>Dept2 List</h1>

	<table border="1">
		<tr>
			<th>부서 코드</th>
			<th>부서 이름</th>
			<th>상위 부서</th>
			<th>지역</th>
		</tr>
		<!-- 부서 리스트 내용 출력 -->
		<c:forEach var="dept" items="${dept}">
			<tr>
				<td>${dept.getDcode()}</td>
				<td>${dept.getDname()}</td>
				<td>${dept.getPdept()}</td>
				<td>${dept.getArea()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
