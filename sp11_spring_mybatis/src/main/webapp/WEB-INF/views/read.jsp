<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>read.jsp 상세페이지</title>
<style type="text/css">
/* table{ width: 500; } */
/* 	table, tr, td, th { border: 1px solid black; } */
th {
	text-align: left;
	background: orange;
}

textarea {
	background-color: #ddd;
	border: 1px solid blick;
}

a {
	text-decoration: none;
}
</style>
</head>

<script type="text/javascript">
	function board_update() {
		//alert("수정");
		location.href = "updateform.htm?num=${dto.num}&pg=${pg}";

	}
	function board_delete() {
		//alert("삭제");
		location.href = "deleteform.htm?num=${dto.num}&pg=${pg}";
	}
	function board_reply() {
		//alert("답변");
		location.href = "replyform.htm?num=${dto.num}&pg=${pg}";
	}
</script>


<body>
	<a href="list.htm?pg=${ pg }">목록 보기</a>
	<br />
	<table>
<%-- 		<c:forEach items="${list}" var="dto"> --%>
			<tr>
				<th colspan="4">${dto.subject}</th>
			</tr>

			<tr>
				<td>${dto.name}</td>
				<td>${dto.email}</td>&nbsp;&nbsp;&nbsp;
				<td><fmt:formatDate value="${ dto.regdate }"
						pattern="yyyy-MM-dd" /></td>
				<td>${dto.hit}</td>
			</tr>
			<tr>
				<td colspan="4"><textarea rows="10" cols="100">${dto.content}</textarea></td>
			</tr>
			<tr>
				<td align="center" colspan="4"><input type="button" value="수정"
					onclick="board_update()" /> <input type="button" value="삭제"
					onclick="board_delete()" /> 
					<input type="button" value="답변" onclick="board_reply()"/>
				</td>
			</tr>
<%-- 		</c:forEach> --%>
	</table>
</body>
</html>