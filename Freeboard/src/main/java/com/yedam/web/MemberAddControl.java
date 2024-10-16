package com.yedam.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

//"저장"을 눌렀을때 등록처리를 하는 컨트롤
public class MemberAddControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		System.out.println("MemberAddControl");
		
		//파라미터 가져오기
		String id = req.getParameter("mid");
		String nm = req.getParameter("mname");
		String pw = req.getParameter("passwd");
		String pn = req.getParameter("phone");
		
		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo.setMemberName(nm);
		mvo.setPassword(pw);
		mvo.setPhone(pn);
		
		MemberService svc = new MemberServiceImpl();
		
		try {
			//멤버 추가 성공하면 목록페이지로 이동.
			svc.addMember(mvo);
			//멤버가 성공적으로 추가되면 
			resp.sendRedirect("memberList.do");
		} catch (Exception e) {
			//그게 아닐경우 사용자 등록화면으로 이동
			resp.sendRedirect("memberAddForm.do");
		}
		
	}
	
}
