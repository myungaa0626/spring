<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept2 List</title>
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
		<c:forEach var="dept" items="${dept2List}">
			<tr>

				<!-- 각 항목에 접근할 때 'dept' 변수를 이용합니다. -->
				<!-- 아래와 같이 getter 메소드 대신 속성 이름을 직접 사용할 수 있습니다. -->

				<td>${dept.dcode}</td>
				<td>${dept.dname}</td>
				<td>${dept.pdept}</td>
				<td>${dept.area}</td>

			</tr>

		</c:forEach>

	</table>


<a href="/index.jsp">처음 화면</a>
</body>
</html>







