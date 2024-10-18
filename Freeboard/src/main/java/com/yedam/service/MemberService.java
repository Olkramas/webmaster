package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

//업무처리 로직
//인터페이스로 선언한 이유는 기능을 정의만하고 구현은 구현클래스에서 적용할예정
public interface MemberService {
	//업무 내용에 맞는 이름을 사용함
	boolean addMember(MemberVO member);
	boolean retireMember(String MemberId);
	//회원목록 출력을 위한 메소드
	List<MemberVO> memberList(); 
	
	//로그인
	MemberVO loginCheck(String id, String pw);
	
}
