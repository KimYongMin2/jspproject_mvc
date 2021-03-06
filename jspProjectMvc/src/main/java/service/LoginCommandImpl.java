package service;

import dao.MemberDao;
import domain.Member;
import util.ConnectionProvider;
import util.CookieBox;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class LoginCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String memberId = request.getParameter("memberid");
		String password = request.getParameter("password");
		String reid = request.getParameter("reid");

		boolean loginChk = false;

		Connection conn = null;
		MemberDao dao = null;


		if(memberId!=null && password!=null && memberId.trim().length()>2 && password.trim().length()>3){

			try{
				conn = ConnectionProvider.getConnection();
				dao = MemberDao.getInstance();

				Member member = dao.selectByIdPw(conn, memberId, password);

				if(member != null){
					// 회원의 정보를 Session 객체에 저장
					//session.setAttribute("member", member);
					request.getSession().setAttribute("loginInfo", member.toLoginInfo());
					loginChk = true;
				}

			} catch (SQLException e){
				e.printStackTrace();
			}

		}

		// ID 저장을 위한 쿠키 설정
		// reid 값의 유무 체크
		if(reid!=null && reid.equals("on")){
			// 쿠키 저장 : 사용자 ID를 저장
			response.addCookie(CookieBox.makeCookie("reid", memberId, "/", 60*60*24*365));
		} else {
			// 쿠키값을 저장하지 않는다!!!
			response.addCookie(CookieBox.makeCookie("reid", memberId, "/", 0));
		}


		if(!loginChk){
			return "/WEB-INF/view/loginForm.jsp";
		}

		return "/index.jsp";
		
	}

}
