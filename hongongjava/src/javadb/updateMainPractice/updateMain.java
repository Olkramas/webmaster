package javadb.updateMainPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateMain {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:Oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			
			System.out.println("연결 성공");
			String sql = "" +
						 "update	boards " +
						 "set		btitle=?, " +
						 "    		bcontent=? " +
						 "where 	bno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "뽀뽀쎄");
			pstmt.setString(2, "뽀뽀쬽 고은");
			pstmt.setInt(3, 4);
			
			int rows = pstmt.executeUpdate();
			
			if(rows == 1) {
				System.out.println("변경 성공");
			} else {
				System.out.println("변경 실패");
			}
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
		}
		
	}
}
