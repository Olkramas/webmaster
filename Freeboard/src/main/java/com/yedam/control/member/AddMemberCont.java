package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class AddMemberCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// id, name, phone, pw:'1111'
		MemberVO member = new MemberVO();
		member.setMemberId(req.getParameter("id"));
		member.setMemberName(req.getParameter("name"));
		member.setPhone(req.getParameter("phone"));
		member.setPassword("1111");
		
		MemberService svc = new MemberServiceImpl();
		try {			
			svc.addMember(member);
			// 리턴 코드 ok로 출력	{"retCode":OK}
			//제이슨 형태로 값이 넘어가기때문에 키, 값에 모두 큰따옴표
			resp.getWriter().print("{\"retCode\": \"OK\"}");
		} catch (Exception e) {
			resp.getWriter().print("{\"retCode\": \"FAIL\"}");
		}
		
	}

}
