<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>사원 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>구분</td>
			<td>사원번호</td>
			<td>성명</td>
			<td>부서</td>
			<td>직급</td>
			<td>생년월일</td>
			<td>입사일</td>
			<td>퇴사일</td>
			<td>휴대폰</td>
			<td>이메일</td>
			<td>상태</td>
		</tr>
		

		<c:forEach var="retire" items="${retirePage.content }">
			<tr>
				<td>${retire.employee.classify }</td>
				<td>${retire.emp_no }</td>
				<td>${retire.employee.emp_name }</td>
				<td>${retire.employee.dept }</td>
				<td>${retire.employee.position }</td>
				<td>${retire.resident_no }</td>
				<td>${retire.join_date }</td>
				<td>${retire.resign_date }</td>
				<td>${retire.phone }</td>
				<td>${retire.email }</td>
				<td>
				<c:if test="${empty retire.resign_date }">
					재직
				</c:if>
				<c:if test="${!empty retire.resign_date }">
					퇴직
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>