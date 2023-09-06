<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	게시글을 삭제했습니다.
	<br>
	${ctxPath=pageContext.request.contextPath}
	<a href="${ctxPath}/article/list.do">[게시글 목록 보기]</a>
</body>
</html>