package javadb.selectMainPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javadb.Board;

public class SelectMain2 {
	static Connection conn = null;
	
	static void getConn() {
		 try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:Oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void closeConn() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static void select() {
	getConn();
	String spl = "" +
             "select * "+
             "from   boards ";
	
	PreparedStatement pstmt;
	try {
		pstmt = conn.prepareStatement(spl);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Board bd = new Board();
			bd.setBno(rs.getInt(1));
			bd.setBtitle(rs.getString(2));
			bd.setBcontent(rs.getString(3));
			bd.setBwriter(rs.getString(4));
			bd.setBdate(rs.getDate(5));
			
			System.out.println(bd);
		}
		rs.close();
		pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {		
		closeConn();
	}
	
	}
	public static void main(String[] args) {
		select();
	}

}
