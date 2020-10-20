<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>新規メモ</h1>
	<% String message = (String)request.getAttribute("message");%>
	<%= message %>

	<form action="Insert" method="post">
		<label name="title">タイトル</label>
		<input type="text" name="title" value="${Memoinfo.title}">

		<label name="title">本文</label>
		<input type="textarea" name="content" value="${Memoinfo.content}">

		<input type="submit" value="追加">
	</form>

</body>
</html>