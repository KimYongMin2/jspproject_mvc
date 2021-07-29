package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class MypageCommandImpl implements Command {

    @Override
    public String getPage(HttpServletRequest request, HttpServletResponse response) {

        //.... 핵심처리
//			<c:if test="${loginInfo eq null}">
//<script>
//				alert('로그인이 필요한 페이지입니다.\n로그인 후 사용해주세요!!');
//		location.href = '<%= request.getContextPath()%>/loginForm.jsp';
//</script>
//	</c:if>
		if (request.getSession().getAttribute("loginInfo")==null){
			return "/loginForm.do";
		}else{
            return "/mypage.jsp";
        }
    }

}
