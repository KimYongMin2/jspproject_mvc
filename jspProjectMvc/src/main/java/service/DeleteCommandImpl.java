package service;

import dao.MemberDao;
import domain.Member;
import util.ConnectionProvider;
import util.CookieBox;
import util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DeleteCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int memberIdx = Integer.parseInt(request.getParameter("memberIdx"));

		int result = 0;

		Connection connection = null;
		MemberDao memberDao = null;

		try {
			connection = ConnectionProvider.getConnection();
			memberDao = MemberDao.getInstance();
			result = memberDao.delete(connection, memberIdx);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection);
		}

		request.setAttribute("resultDelete",result);
		return "/WEB-INF/view/delete.jsp";
	}
}
