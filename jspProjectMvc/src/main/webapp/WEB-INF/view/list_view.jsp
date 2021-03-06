<%@page import="domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td {
		text-align: center;
		padding: 5px 10px;
	}
	
	button {
		margin: 5px 0;
	}
</style>
<link rel="stylesheet" href="<c:url value='/css/default.css'/>">
<script>
</script>
</head>
<body>


	<%@ include file="/WEB-INF/frame/header.jsp"%>

	<%@ include file="/WEB-INF/frame/nav.jsp"%>
	
	<h1>부서 리스트</h1>
	<hr>
	
	<!-- <button onclick="location.href='dept_regForm.jsp';">부서정보 등록</button> -->
	
	<table border=1>
		<tr>
			<th>idx</th>			
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>가입일</th>
			<th>관리</th>
		</tr>
		

				
		<c:if test="${resultList ne null and not empty resultList }">
		<c:forEach items="${resultList}" var="member">
		<tr>
			<td>${member.idx}</td>
			<td>${member.memberid}</td>
			<td>${member.password}</td>
			<td>${member.membername}</td>
			<td>${member.regdate}</td>
			<td>
				<a href="javascript:delDept(${member.idx})">삭제</a>
			</td>
		</tr>
		</c:forEach>
		</c:if>

	</table>

	<script>

		function delDept(idx){

			if(confirm('정말 삭제하시겠습니까?')) {

				location.href = 'delete.do?memberIdx=' + idx;
			}
		}

	</script>


</body>
</html>