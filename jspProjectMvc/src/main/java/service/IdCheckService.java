package service;

import dao.MemberDao;
import util.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;

public class IdCheckService {
    private IdCheckService(){}
    private static IdCheckService service = new IdCheckService();
    public static IdCheckService getInstance(){
        return service;
    }
    public String idCheck(String memberId){
        // String result = "N";
        int cnt = 0;
        Connection connection = null;
        MemberDao memberDao = null;

        try {
            connection = ConnectionProvider.getConnection();
            memberDao = MemberDao.getInstance();

            cnt = memberDao.selectById(connection, memberId);
            // result = cnt > 0 ? "N" : "Y";
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cnt > 0 ? "N" : "Y";
    }
}
