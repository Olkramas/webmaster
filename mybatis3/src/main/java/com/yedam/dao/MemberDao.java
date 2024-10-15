package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.vo.Member;

public class MemberDao extends DAO{
	
	//리스트를 리턴하는 메소드
	public List<Member> memberList() {
		List<Member> list = new ArrayList<>();
		try {
			conn = getOpen();
			pstmt = conn.prepareStatement("select * from tbl_member ");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				
				//리스트에 객체 넣기
				list.add(member);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
		return list;
	}
}
