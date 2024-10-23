package com.yedam.control.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class ReplyCountCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청한 곳에서 bno파라미터 가져오기
		String bno = req.getParameter("bno");
		
		ReplyService svc = new ReplyServiceImpl();
		//게시글 총 댓글 개수 세기
		int totalCnt = svc.replyCount(Integer.parseInt(bno));
		
		//{"totalCount": 10} 이 형식으로 반환해주려고 함.
		resp.getWriter().print("{\"totalCount\":\""+totalCnt + "\"}");
		
	}

}
