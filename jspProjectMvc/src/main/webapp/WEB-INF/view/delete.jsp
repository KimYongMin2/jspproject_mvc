<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<%--%>
<%--    int result = (int) request.getAttribute("resultDelete");--%>
<%--    if (result == 1){--%>
<%--%>--%>
<%--<script>--%>
<%--    alert('삭제되었습니다.');--%>
<%--    location.href = '<c:url value="/memberList.do"/>';--%>
<%--</script>--%>
<%--<%--%>
<%--}else{--%>
<%--%>--%>
<%--<script>--%>
<%--    alert("해당 데이터를 찾지 못했습니다.");--%>
<%--    location.href = '<c:url value="/memberList.do"/>';--%>
<%--</script>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>
<c:if test="${resultDelete == 1}">
    <script>
        alert('삭제되었습니다.');
        location.href='<c:url value="/memberlist.do"/>';
    </script>
</c:if>
<c:if test="${resultDelete == 0}">
    <script>
        alert('오류 발생으로 삭제되지 않았습니다.');
        window.history.go(-1);
    </script>
</c:if>