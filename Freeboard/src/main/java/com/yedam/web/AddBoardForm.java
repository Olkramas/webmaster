package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class AddBoardForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//addBoardForm.do라는 요청이 들어오면 jsp페이지와 연결해줌
		req.getRequestDispatcher("WEB-INF/jsp/boardForm.jsp").forward(req, resp);
	}

}
