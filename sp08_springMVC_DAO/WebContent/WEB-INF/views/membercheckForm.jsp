<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>membercheckForm.jsp</title>
</head>
<body>
<h1>MembercheckForm</h1>

<form action="check.kosa" method="post">
	확인할 ID : <input type="text"  name="id"> &nbsp;&nbsp;
	<input type="submit"  value="ID확인"> &nbsp;&nbsp;
	<input type="button" value="로그인"  onclick="javascript:location.href='login.kosa'" />
</form>


</body>
</html>