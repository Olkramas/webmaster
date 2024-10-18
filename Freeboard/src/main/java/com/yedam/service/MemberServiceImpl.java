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
	
	//데이터 베이스 연결을 관리하는 객체를 리턴받았음DataSource.getInstance()
	//openSession(true)새로운 sql세션을 생성하는 메소드, true는 자동 커밋
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	//sqlSession객체에서 .getMapper메소드를 호출하여 MemberMapper인터페이스의 구현체(xml파일)을 가져옴
	//이를 dao라는 객체에 담았기 때문에 dao.~~xml파일에서 정의했던 것들을 사용할 수 있음.
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	//유저 추가
	@Override
	public boolean addMember(MemberVO member) {
		//insertMember의 실행결과가 1과 같으면 참 아니면 거짓
		return mapper.insertMember(member) == 1;
	}
	
	//유저 삭제
	@Override
	public boolean retireMember(String MemberId) {
		return mapper.deleteMember(MemberId) == 1;
	}

	//멤머 리스트 리턴받음
	@Override
	public List<MemberVO> memberList() {
		//유저 리스트 리턴
		return mapper.members();
	}
	
	@Override
	public MemberVO loginCheck(String id, String pw) {
		return mapper.loginMember(id, pw);
	}
}
