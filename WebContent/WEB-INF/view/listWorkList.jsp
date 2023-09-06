<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근태 관리</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>구분</td>
			<td>사원번호</td>
			<td>성명</td>
			<td>부서</td>
			<td>직급</td>
		</tr>


		<c:forEach var="working" items="${workPage.content }">
			<tr>
				<td>${working.classify }</td>
				<td>${working.emp_no }</td>
				<td>${working.emp_name }</td>
				<td>${working.dept }</td>
				<td>${working.position }</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>