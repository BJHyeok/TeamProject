<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>급여 리스트</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>구분</td>
			<td>사원번호</td>
			<td>성명</td>
			<td>부서</td>
			<td>지급총액</td>
			<td>공제총액</td>
			<td>실제금액</td>
		</tr>


		<c:forEach var="salarylist" items="${salaryPage.content }">
			<tr>
				<td>${salarylist.salary.employee.classify }</td>
				<td>${salarylist.salary.employee.emp_no }</td>
				<td>${salarylist.salary.employee.emp_name }</td>
				<td>${salarylist.salary.employee.dept }</td>
				<td>${salarylist.total }</td>
				<td>${salarylist.deduct }</td>
				<td>${salarylist.real }</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>