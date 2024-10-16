package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

// mysql으로 프로젝트를 시작했음 -> 예산이 넉넉해져서oracle이라는 데이터베이스 프로그램을 사용하게된 상황을 가정
//mysql(insertMember, updateMember)
//oracle(memberInsert, memberupdate)이렇게 메소드를 바꿨다고 가정하면 이전에 있었던 메소드 이름을 다 바꿔야함.

//implements MemberService를 통해 인터페이스의 메소드를 구현해야됨 그래서 이름이 안바뀜.(인터페이스를 선언하는 이유)
public class MemberServiceImpl implements MemberService{
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public boolean addMember(MemberVO member) {
		return mapper.insertMember(member) == 1;
	}

	@Override
	public boolean retireMember(String MemberId) {
		return mapper.deleteMember(MemberId) == 1;
	}

	@Override
	public List<MemberVO> memberList() {
		//유저 리스트 리턴
		return mapper.members();
	}
	
}
