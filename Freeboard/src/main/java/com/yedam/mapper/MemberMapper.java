package com.yedam.mapper;

import java.util.List;
import com.yedam.vo.MemberVO;


//interface 기능정의
//구현 클래스를 통해서 기능 실행(xml이 구현클래스 같은 느낌임)

public interface MemberMapper {
	
	public List<MemberVO> members();
	public int insertMember(MemberVO member);
	public int updateMember(MemberVO member);
	public int deleteMember(String memberId);
	public MemberVO selectMember(String memberId);	//단건 조회
	
}
