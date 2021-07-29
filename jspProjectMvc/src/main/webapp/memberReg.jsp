<%@page import="service.MemberRegService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int result = MemberRegService.getInstance().regMember(request);
%>
<jsp:forward page="reg_view.jsp"/>





