<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm</title>
<script defer="defer" type="text/javascript"></script>
</head>
<body>
	<br>
	<br>

	<form action="update.do" name="form" method=post>
		<input type="hidden" name="modify" id="modify" value="1">
		<table class="type09">
			<tbody>
				<tr>
					<th scope="row">유저 아이디</th>
					<td><input type="text" name="id" id="id" value="${map.ID}"
						readonly></td>
				</tr>
				<tr>
					<th scope="row">이름</th>
					<td><input type="text" name="name" id="name"
						value="${map.NAME}"></td>
				</tr>
				<tr>
					<th scope="row">관리자 여부</th>
					<td><input type="text" name="role" id="role"
						value="${map.ROLE}" readonly></td>
				</tr>

				<tr>
					<th scope="row">등록일</th>
					<td><input type="text" name="regDate" id="regDate"
						value="${map.REGDATE}" readonly=readonly></td>
				</tr>
				<tr>
				<td>
		<input type="submit" value="이름 수정"></td>
		<td><input type="button" value="홈으로" onclick="location.href='../home.do'"></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>