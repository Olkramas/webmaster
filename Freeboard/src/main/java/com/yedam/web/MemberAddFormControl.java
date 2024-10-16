package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class MemberAddFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//jsp페이지 열어줄 수 있음
		//인터페이스에서 exec예외를 호출한 곳으로 떠넘기도록 throws를 했음
		req.getRequestDispatcher("WEB-INF/jsp/memberAddForm.jsp").forward(req, resp);
	}

}
