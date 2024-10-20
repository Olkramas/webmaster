package com.yedam.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control
{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList();
		req.setAttribute("memberList", list);
		
		try {
			req.getRequestDispatcher("WEB-INF/jsp/memberList.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
