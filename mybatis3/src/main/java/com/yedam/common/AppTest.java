package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

public class AppTest {
	public static void main(String[] args) {
		//MemberDao dao = new MemberDao();
		SqlSession sqlSession = DataSource.getInstance().openSession();
		//getMapper가 xml이랑 인터페이스를 연결함.
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		//등록.
		Member mbr = new Member();
		mbr.setMemberId("test99");
//		mbr.setMemberName("연습99");
		mbr.setPhone("010-0000-8888");
		mbr.setPassword("9999");
		
//		if(dao.insertMember(mbr) == 1) {
//			sqlSession.commit();
//		}
		if(dao.updateMember(mbr) == 1) {
			sqlSession.commit();
		}
		if(dao.deleteMember(mbr.getMemberId()) == 1) {
			sqlSession.commit();
		}
		
		List<Member> result = dao.members(); //members는 인터페이스에서 만들었던 메소드
		for(Member member : result) {
			System.out.println(member.toString()); 
		}
	}
}
