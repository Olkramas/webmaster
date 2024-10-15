package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMain {

	public static void main(String[] args) {
		//연결하기 = Connection변수 만들기
		Connection conn = null;
		
		try {
			//jdbc드라이버 등록하기
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:Oracle:thin:@localhost:1521:xe", //url연결
					"java",
					"1234"
					);
			System.out.println("연결성공");
			
			//데이터 수정하기(update)
			String sql = "" +
			             "update boards " +
					     "set btitle=?, bcontent=?" +
			             "where bno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle", "bcontent"});
			pstmt.setString(1, "행복");
			pstmt.setString(2, "바람이 간지러워요");
			pstmt.setInt(3, 4);
			
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 갯수 : " + rows);
//			if(rows == 1) {    
//				ResultSet rs = pstmt.getGeneratedKeys();
//				if(rs.next()) {
//					int bno = rs.getInt("bno");
//					String btitle = rs.getString("btitle");
//					String bcontent = rs.getString("bcontent");
//					System.out.println("저장된 번호: " + bno + "\t제목: " + btitle + "\t내용: " + bcontent);
//				}
//				System.out.println("추가 성공");
//				rs.close();
//			} else {
//				System.out.println("추가 실패");
//			}
			
			pstmt.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결끊기");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
