package dao;

import domain.Member;
import util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

	private MemberDao() {
	}

	private static MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {
		return dao;
	}

	public int insertMember(Connection conn, Member member) throws SQLException {

		int resultCnt = 0;

		PreparedStatement pstmt = null;

		String sql1 = "insert into member (memberid,password,membername) values (?, ?, ?)";
		String sql2 = "insert into member (memberid,password,membername, memberphoto) values (?, ?, ?,?)";

		try {
			
			if(member.getMemberphoto() == null) {
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, member.getMemberid());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getMembername());
			} else {
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, member.getMemberid());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getMembername());
				pstmt.setString(4, member.getMemberphoto());
			}
			
			resultCnt = pstmt.executeUpdate();

		} finally {
			JdbcUtil.close(pstmt);
		}

		return resultCnt;

	}

	public List<Member> selectList(Connection conn) {

		List<Member> list = null;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			String sql = "select * from member";

			rs = stmt.executeQuery(sql);

			list = new ArrayList<Member>();

			while (rs.next()) {
				list.add(new Member(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5),
						rs.getTimestamp(6)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return list;

	}
	
	
	public Member selectByIdPw(Connection conn, String id, String pw) {
		
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where memberid=? and password=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setMemberid(rs.getString("memberid"));
				member.setPassword(rs.getString("password"));
				member.setMembername(rs.getString("membername"));
				member.setRegdate(rs.getTimestamp("regdate"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		
		
		return member;
	}


	public int selectById(Connection connection, String memberId) throws SQLException {
		int cnt = 0;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select count(*) from member where memberid=?;";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberId);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
				cnt = resultSet.getInt(1);
			}

		} finally {
			JdbcUtil.close(resultSet);
			JdbcUtil.close(preparedStatement);
		}
		return cnt;
	}

	public int delete(Connection connection, int memberIdx){
		int result = 0;

		PreparedStatement preparedStatement = null;

		String sql = "delete from member where idx=?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,memberIdx);

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(preparedStatement);
		}

		return result;
	}

	
}
