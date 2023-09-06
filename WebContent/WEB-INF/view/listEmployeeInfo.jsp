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
			<td>휴대폰</td>
			<td>이메일</td>
		</tr>
		

		<c:forEach var="employee" items="${employeePage.content }">
			<tr>
				<td>${employee.employee.classify }</td>
				<td>${employee.emp_no }</td>
				<td>${employee.employee.emp_name }</td>
				<td>${employee.employee.dept }</td>
				<td>${employee.employee.position }</td>
				<td>${employee.resident_no }</td>
				<td>${employee.join_date }</td>
				<td>${employee.phone }</td>
				<td>${employee.email }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>