<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세보기</title>


<style type="text/css">
	th {text-align: right; background: orange}

</style>

</head>
<body>
<h1>글 수정</h1>
<form name = "detailform" action="detail.htm" method="post">
<table width="600">
	<tr>
		<th>이름</th>
		<td>
			<input type="hidden" name="num" value="${dto.num}"/>
			<input type="text" name="name" maxlength="5" size="12" value="${dto.name}"/>
		</td>
	</tr>
	
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="password" name="pwd" maxlength="12"  size="13" value="${dto.pwd}"/>
		</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>
			<input type="text" name="email" maxlength="30"  size="30" value="${dto.email}" />
		</td>
	</tr>
	
	<tr>
		<th>제목</th>
		<td>
			<input type="text" name="subject" maxlength="50" size="65" value="${dto.subject}" />
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
			<textarea name="content" rows="5" cols="50">${dto.content}</textarea>
		</td>
	</tr>
	<tr>
		
		<td colspan="2">
			<input type="button" value="수정" onclick="board_update()"/>
			<input type="reset" value="취소" />
		</td>
	</tr>
	
</table>
</form>
</body>
</html>