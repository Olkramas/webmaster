package javadb.updateMainPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice2 {
	static Connection conn = null;
	
	static public Connection getOpen() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(
				"jdbc:Oracle:thin:@localhost:1521:xe",
				"java",
				"1234"
				);
	}
	
	static public void getClose(Connection conn) throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
	
	static public void insert() {
		try {
			conn = getOpen();
			
			String sql = "" +
					 "update	boards " +
					 "set 		btitle=?, " +
					 "          bcontent=? " +
					 "where     bno=? ";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "행복");
			pstmt.setString(2, "방밥밥");
			pstmt.setInt(3, 5);
			
			int rows = pstmt.executeUpdate();
			if(rows > 0) {
				System.out.println("수정된 개수: " + rows);
			} else {
				System.out.println("수정 안됨.");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				getClose(conn);
				System.out.println("연결종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 
		
	}
	
	//메인메소드
	public static void main(String[] args) {
		insert();
	}

}
