package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertMain {

	public static void main(String[] args) {
		//데이터 추가
		
		//연결 - 데이터 추가 - db닫기
		Connection conn = null;
		//jdbc드라이버 등록
		try {
			//ClassNotFoundException예외처리 해야됨
			Class.forName("oracle.jdbc.OracleDriver");
			//연결 (드라이버 메니저 불러야 함. url, 계정, 비밀번호 넣어줘야 함.)
			try {
				conn = DriverManager.getConnection(
						"jdbc:Oracle:thin:@localhost:1521:xe",
						"java",
						"1234"
						);
				//try가 오류가 안뜨면 연결성공임.
				System.out.println("연결성공");
				
				//연결이 성공됨 -> 데이터 추가 가능
				//String으로 sql문을 만들어 주고 변수에 저장
				String spl = ""	//공백 만들어서 넣어줌
							+ "insert into boards (bno,"
							+ "                    btitle,"
							+ "                    bcontent,"
							+ "                    bwriter,"
							+ "                    bdate) "
							+ "values(seq_bno.nextVal,"
							+ "       ?,"
							+ "       ?,"
							+ "       ?,"
							+ "       sysdate)";
//				String spl = ""
//						    + "insert into boards (bno, btitle, bcontent, bwriter, bdate) "	//괄호 뒤에 띄어쓰기 안하면 오류남.
//						    + "values(seq_bno.nextVal, ?, ?, ?, sysdate)";
				//인터페이스 타입임. sql문을 만들어서 실행시킴
				PreparedStatement pstmt = conn.prepareStatement(spl, new String[] {"bno", "btitle"});
				//set넣어주겠다 String타입으로 (1(첫번째 물음표), "제목1")
				
				pstmt.setString(1, "눈오는 밤");
				pstmt.setString(2, "눈이 펑펑 내려용...");
				pstmt.setString(3, "snow");
				
				
				//만들어진 문장들 실행하기, 실행하면 true
				int rows = pstmt.executeUpdate(); //sql문장을 실행해줌.
				if(rows == 1) {
					//ResultSet은 데이터베이스에서 실행된 결과를 가져옴
					ResultSet rs = pstmt.getGeneratedKeys();
					if(rs.next()) {
						//1의 의미는 첫번재 칼럼에 있는애 데려와(칼럼 번호)/ bno로 써도 됨.
						int bno = rs.getInt(1);	//bno는 int타입이라서 이렇게 들고 오면 됨.
						String title = rs.getString(2);
						System.out.println("저장된 번호 : " + bno +"\t저장된 제목: " + title); //마지막 저장된 번호 출력
					}
					System.out.println("추가 성공");
					rs.close();
				} else {
					System.out.println("추가 실패");
				}
				
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				//null이 아니라는 말은 연결이 됐다는 말임
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
