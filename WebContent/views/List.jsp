<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
		<head>
			<meta charset="UTF-8">
			<title>メモ一覧機能</title>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		</head>
<body>

<h1>メモ一覧</h1>
<table>
	<tr>

	<c:forEach var="Mem" items="${memoinfo}">

		<label>タイトル</label>
		${Mem.title}

		<label>本文</label>
		${Mem.content}

	</c:forEach>
	</tr>
</table>
<a href="/new.jsp" class="btn btn-new">追加</a>
</body>
</html>