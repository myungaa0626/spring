<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8">
<title></title>
</head>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
function send() {
var formData = {
        name: $("input[name='name']").val(),
        age: $("input[name='age']").val(),
        message: $("input[name='message']").val()
    };

    $.ajax({
        url: '/rest/sample/data', // REST API 호출
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(formData), // JSON 형태로 데이터 전송
        success: function(data) {
            console.log("success");
        },
        error: function(xhr, status, error) {
            console.log("error");
        }
    });
};
</script>
<body>
	<%--1.--%>
	
	<a href="getText"> 1. 문자열 반환 </a>  <br/>
	
	<%--2.--%>
	<a href="getObject"> 1. Object Return</a> <br/>
	<%--3.--%>
	
	<a href="getList"> 1. List Object Return</a> <br/>
	
	<%--4. --%>	
	<a href="sample/it/100"> 4. 쿼리스팅 처리</a> <br/>
	<a href="sample/novel/2023"> 4. 쿼리스팅 처리</a> <br/>

	<%--5. --%>
	<form action="sample/data" method="post" id="form">
		<input type="text" name="name" placeholder="이름 입력"><br />
		<input type="text" name="age" placeholder="나이 입력"><br />
		<input type="text" name="message" placeholder="메세지 입력"><br />
		<input type="button" value="전송하기" onclick="send()">
	</form>
</body>
</html>