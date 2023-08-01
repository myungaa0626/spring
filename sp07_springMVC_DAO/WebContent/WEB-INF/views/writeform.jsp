<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Form Page</title>
</head>
<body>
	<h3>회사 지점 위치 추가 글쓰기</h3>

	<form action="write.do" method="post">
		지점번호: 	<input type="text" name="deptno"> <br />
		영업소명:	<input type="text" name="deptname"> <br />
		위	치:	<input type="text" name="deptloc"> <br />
	
		<input type="submit" value="지점저장"> &nbsp;
		<input type="reset" value="취소"> &nbsp;
		<input type="button" value="List Page" onclick="location.href='list.do' "> &nbsp;		
		
		
		
	</form>
	



</body>
</html>