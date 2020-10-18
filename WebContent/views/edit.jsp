<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
			<title>メモ詳細</title>
		</head>
<body>

	<h1>メモ詳細</h1>
	<% String message = (String)request.getAttribute("message");%>
	<%= message %>


	<form action="edit" method='get'>
		<input type="hidden" name="id" value='<%=request.getAttribute("id")%>'>;

	    <label for="title">タイトル</label>
		<input type="text" name="title" value='<%=request.getAttribute("title")%>'>;

		<label for="content">本文</label>
		<input type="text" name="content" value='<%=request.getAttribute("content")%>'>;

		<button type="submit">保存する</button>
	<p>
		<a href="List">戻る</a>
		<a href="edit?id=<%= request.getAttribute("id") %>">編集する</a>
		<a href="destroy?id=<%= request.getAttribute("id") %>">削除する</a>
	</p>

	</form>

</body>
</html>

