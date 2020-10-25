<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
			<title>メモ詳細</title>
		</head>
<body>

	<h1>新規メモ</h1>
	<% String message = (String)request.getAttribute("message");%>
	<%= message %>


	<form action="create" method='post'>
		<input type="hidden" name="id">;

	    <label for="title">タイトル</label>
		<input type="text" name="title" value="">;

		<label for="content">本文</label>
		<input type="textarea" name="content" value="">;

		<button type="submit">追加</button>
	<p>
		<a href="List">戻る</a>
		<a href="edit?id=<%= request.getAttribute("id") %>">編集する</a>
		<a href="destroy?id=<%= request.getAttribute("id") %>">削除する</a>
	</p>

	</form>

</body>
</html>

