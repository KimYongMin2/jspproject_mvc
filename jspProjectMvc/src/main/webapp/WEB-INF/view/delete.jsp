<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    int result = (int) request.getAttribute("resultDelete");
    if (result == 1){
%>
<script>
    alert('삭제되었습니다.');
    location.href = '<c:url value="/memberList.do"/>';
</script>
<%
}else{
%>
<script>
    alert("해당 데이터를 찾지 못했습니다.");
    location.href = '<c:url value="/memberList.do"/>';
</script>
<%
    }
%>
