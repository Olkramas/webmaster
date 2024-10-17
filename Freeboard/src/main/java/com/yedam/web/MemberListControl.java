package com.yedam.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberListControl"); 
		
		//MemberService인터페이스의 구현클래스로 객체를 만듦
		MemberService svc = new MemberServiceImpl();
		
		//만들어진 객체가 mapper의 구현체의 members를 리턴받음(리스트 타입)
		List<MemberVO> list = svc.memberList();
		
		//"memberList"가 키역할을 함. 이를통해 저장된 데이터에 jsp페이지가 접근할 수 있음.
		req.setAttribute("memberList", list);
		
		// memberList.do로 요청된 페이지에서 memberList.jsp로 요청 재지정
		try {
			//getRequestDispatcher지정된 경로에 대한 객체를 생성함.
			//forward는 그 객체를 통해 jsp파일에 유저의 요청과 응답을 전달할 수 있는 메소드
			req.getRequestDispatcher("WEB-INF/jsp/memberList.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
