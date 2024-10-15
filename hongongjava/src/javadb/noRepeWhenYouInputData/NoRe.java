package javadb.noRepeWhenYouInputData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NoRe {
	static Connection conn = null;
	
	static Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(
				"jdbc:Oracle:thin:@localhost:1521:xe",
				"java",
				"1234"
				);
	}
	
	static void closeConn(Connection conn) throws SQLException {
		if(conn != null) {
			conn.close();			
		}
	}
	
	//입력된 값을 받아서 중복이 있는지 없는지 체크하는 메소드 리턴값이 정수든 불리언이든 필요함
	static String noRe(Connection conn, String btitle) throws SQLException {
		String result = null;
		//쿼리를 통해서 db에 값이 있는지 없는지 가져와야 함.
		String sql = "" +
		             "select btitle " +
				     "from boards " +
		             "where btitle=? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, btitle);
		
		//쿼리 실행
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			//getString()안 숫자의 의미는 내가 작성한 쿼리문에서 칼럼의 숫자임
			//만약 select *일 경우에는 
			result = rs.getString(1);
		}
		rs.close();
		pstmt.close();
		return result;
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			conn = getConn();
			//연결됨
			System.out.println("연결됨 \n");
			System.out.println("책 제목을 입력하세요");
			String check = scanner.nextLine();
//			String check = noRe(conn, "동동");
			String fromDb = noRe(conn, check);
			
			if(check.equals(fromDb)) {
				System.out.println("책 제목이 중복되었습니다.");
			} else {
				System.out.println("중복되지 않았습니다.");
			}
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
