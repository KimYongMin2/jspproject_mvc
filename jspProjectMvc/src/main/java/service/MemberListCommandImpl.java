package service;

import dao.MemberDao;
import util.ConnectionProvider;
import util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class MemberListCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		//.... 핵심처리
		Connection conn = null;
		MemberDao dao = MemberDao.getInstance();

		try {
			// jdbcUrl
			conn = ConnectionProvider.getConnection();

			// 6. 결과 데이터 request 의 속성에 저장 -> 데이터 공유(전달)
			request.setAttribute("result", dao.selectList(conn));

		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			JdbcUtil.close(conn);
		}

		return "/list_view.jsp";
	}

}
