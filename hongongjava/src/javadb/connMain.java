package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connMain {

	public static void main(String[] args) {
		//database 연결
		
		//1.jdbc 등록
		//커넥션을 만들어야 함. 이를 위한 변수 선언
		Connection conn = null;
		//커넥션인터페이스는 연결을 도와줌.
				
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//db연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",		//오라클에서 계정만들때 사용했던 정보들 참고
					"java",		//아이디
					"1234"		//비밀번호
					);
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			// 어떤에러가 났는지 알아야하기 때문에 출력을 넣거나 해서 바꾸지 않음.
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();		//conn이 연결됐으면 연결을 끊어줌
					System.out.println("연결끊기");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();		
				}
			}
		}
		 
		
		
	}

}
