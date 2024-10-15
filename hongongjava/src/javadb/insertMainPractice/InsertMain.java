package javadb.insertMainPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertMain {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:Oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("연결성공");
			
			String sql = "" +
			             "insert into boards (bno, " +
					     "                    btitle, " +
			             "                    bcontent, " +
					     "                    bwriter, " +
			             "                    bdate) " +
					     "values(seq_bno.nextVal, " +
			             "       ?, " +
					     "       ?, " +
			             "       ?, " +
					     "       sysdate) ";
			//sql문 실행시키기
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle"});
			pstmt.setString(1, "동동2");
			pstmt.setString(2, "내용용");
			pstmt.setString(3, "최태백");
			
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					int bno = rs.getInt(1);
					String title = rs.getString(2);
					System.out.println("저장된 번호: " + bno + "\t책 제목: " + title);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결종료");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
