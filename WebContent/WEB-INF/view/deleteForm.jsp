<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시물 삭제</title>
</head>
<body>
	<form action="delete.do" method="post">
		<p>
			번호: <br/>${delReq.articleNumber}
		</p>
		<p>
			제목: <br/><input type="text" name="title" value="${delReq.title}">
			
		</p>
		<p>
			내용: <br/>
			<textarea name="content" rows="5" cols="30">${delReq.content}</textarea>
		</p>
		<input type="submit" value="글 삭제">
	</form>
</body>
</html>