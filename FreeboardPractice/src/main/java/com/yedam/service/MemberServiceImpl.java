package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.comm.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

	@Override
	public boolean addMember(MemberVO member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retireMember(String MemberId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberVO> memberList() {
		return mapper.members();
	}
//	SqlSession sqlSession = DataSource.getInstance().openSession(true);
//	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
//	@Override
//	public boolean addMember(MemberVO member) {
//		return mapper.insertMember(member) == 1;
//	}
//
//	@Override
//	public boolean retireMember(String MemberId) {
//		return mapper.deleteMember(MemberId) == 1;
//	}
//
//	@Override
//	public List<MemberVO> memberList() {
//		return mapper.members();
//	}
	
}
