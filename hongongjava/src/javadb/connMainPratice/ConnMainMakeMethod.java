package javadb.connMainPratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnMainMakeMethod {
	static Connection conn = null;
	
	static Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
	}
	
	static void closeConn(Connection conn) throws SQLException {
		conn.close();
	}
	
	
	public static void main(String[] args) {
		try {
			conn = getConn();
			System.out.println("연결완료");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConn(conn);
				System.out.println("연결 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
