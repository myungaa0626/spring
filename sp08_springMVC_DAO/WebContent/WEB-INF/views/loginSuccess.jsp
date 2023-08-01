<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginSuccess.jsp</title>
</head>
<body>
	<h3>${USERID } 님 회원이십니다. 어서와요!!</h3><br />

	<form action="logout.kosa" method="post" >
		<input type= "submit" value="로그아웃">
	</form>

</body>
</html>