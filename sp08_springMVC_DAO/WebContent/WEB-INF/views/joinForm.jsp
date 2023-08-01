<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">
<title>joinForm.jsp</title>
</head>
<body>
<form action="join.kosa"  method="post">
	ID : <input type="text"  name="id"> <br />
	Name : <input type="text"  name="name"> <br />
	PassWd : <input type="password"  name="pwd"> <br />
	Email : <input type="email"  name="email"> <br />
	Age : <input type="text"   name="age"> <p />
	
	 <input type="submit"  value="가입" > &nbsp;&nbsp;
	 <input type="reset"  value="취소" >
	 <input type="button" value="로그인"  onclick="javascript:location.href='login.kosa'" /> 
</form>
</body>
</html>