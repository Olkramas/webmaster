package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	//멤버 추가
	@Override
	public boolean addMember(MemberVO member) {
		return mapper.insertMember(member) == 1;
	}
	//멤버 삭제
	@Override
	public boolean retireMember(String memberId) {
		return mapper.deleteMember(memberId) == 1;
	}
	//멤버리스트 가져오기
	@Override
	public List<MemberVO> memberList() {
		return mapper.members();
	}
	

	
}
