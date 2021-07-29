<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="<c:url value='/css/default.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/regForm.css' />">
    <style>
    </style>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="script/regForm.js"></script>
    <script>
    </script>
</head>
<body>

<%@ include file="/WEB-INF/frame/header.jsp"%>

<%@ include file="/WEB-INF/frame/nav.jsp"%>

<div class="contents">

    <h2>회원가입</h2>
    <hr>
    <form action="memberReg.do" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>아이디</td>
                <td>
                    <input type="text" name="memberid" id="memberid">
                    <span id="msg" class="display_none"></span>
                    <img id="loadingimg" class="display_none" alt="loading" src="<c:url value="/img/loading.gif"/>">
                </td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="membername"></td>
            </tr>
            <tr>
                <td>사진</td>
                <td><input type="file" name="photo"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit">
                    <input type="reset" >
                </td>
            </tr>
        </table>
    </form>


</div>


</body>
</html>