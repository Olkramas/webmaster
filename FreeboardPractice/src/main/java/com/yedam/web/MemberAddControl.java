package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberAddControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MemberAddControl");
		String id = req.getParameter("mid");
		String nm = req.getParameter("mname");
		String pw = req.getParameter("passwd");
		String pn = req.getParameter("phone");
		
		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo.setMemberName(nm);
		mvo.setPassword(pw);
		mvo.setPhone(pn);
		
		MemberService sbc = new MemberServiceImpl();
		try {
			sbc.addMember(mvo);
			resp.sendRedirect("memberList.do");
		} catch (Exception e) {
			resp.sendRedirect("memberAddForm.do");
		}
	}

}
