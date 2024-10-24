package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class DelMemberCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		//유저 아이디 파라미터 하나가 넘어오게 됨.
//		String id = req.getParameter("id");
//		MemberService svc = new MemberServiceImpl();
//		
//		if(svc.retireMember(id)) {
//			resp.getWriter().print("{\"retCode\": \"OK\"}");
//		} else {
//			resp.getWriter().print("{\"retCode\": \"FAIL\"}");
//		}
		String id = req.getParameter("id");
		MemberService svc = new MemberServiceImpl();
		
		if(svc.retireMember(id)) {
			//json형식으로 요청한곳으로 retCode를 보냄
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		} else {			
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		}
		
	}

}
