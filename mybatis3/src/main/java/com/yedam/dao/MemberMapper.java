package com.yedam.dao;

import java.util.List;

import com.yedam.vo.Member;

//interface 기능정의
//구현 클래스를 통해서 기능 실행(xml이 구현클래스 같은 느낌임)

public interface MemberMapper {
	
	public List<Member> members();
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String memberId);
	public Member selectMember(String memberId);	//단건 조회
	
}
