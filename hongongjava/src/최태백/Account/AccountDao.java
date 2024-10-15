package 최태백.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
	private Connection conn = null;
	
	public Connection getOpen() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(
				"jdbc:Oracle:thin:@localhost:1421:xe",
				"java",
				"1234"
				);
	}
	
	public void getClose(Connection conn) throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
	
	//처음 시작 메소드 로그인/종료
	public void Start() {
		
	}
	
	//메인메뉴 
	
	//중복확인 메소드
	public String noReAno(String checkAno) {
		String returnCheck = null;
		try {
			conn = getOpen();
			
			String spl = "" +
			             "select ano " +
			             "from   account " + 
			             "where  ano=?";
			
			PreparedStatement pstmt = conn.prepareStatement(spl);
			pstmt.setString(1, checkAno);
			
			ResultSet rs = pstmt.executeQuery();
			returnCheck = rs.getString(1);
			
			rs.close();
			pstmt.close();
			return returnCheck;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				getClose(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnCheck;
	}
}
