<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
		<head>
			<meta charset="UTF-8">
			<title>メモ一覧機能</title>
			<%@include file="/WEB-INF/css/main.css" %>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		</head>
<body>
<div class="Memo_main">
<h1>メモ一覧</h1>
<div class="Memo_main-display">
  <table>
	<tr>
		<c:forEach var="Mem" items="${memoinfo}">
			<label class="title">タイトル</label>
			${Mem.title}

			<label class="content">本文</label>
			${Mem.content}

		</c:forEach>
	</tr>
  </table>
 </div>
</div>
<a href="Insert.jsp" class="btn btn-new">追加</a>
</body>
</html>