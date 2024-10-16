package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

public interface MemberService {
	boolean addMember(MemberVO member);
	boolean retireMember(String MemberId);
	//회원목록 출력을 위한 메소드
	List<MemberVO> memberList(); 
}
