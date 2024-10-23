package com.yedam.control.reply;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ReplyListCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//응답하는 데이터에 한글이 있는 경우를 처리하기 위한 코드
		resp.setContentType("text/json;charset=utf-8");
		
		String bno= req.getParameter("bno");
		String page= req.getParameter("page");
		
		ReplyService svc = new ReplyServiceImpl();
		//댓글 리스트 가져왔음
		List<ReplyVO> list = svc.replyList(Integer.parseInt(bno), Integer.parseInt(page));
		
		Gson gson = new GsonBuilder().create();
		//자바 객체를 json문자열로 바꿔줌
		String json = gson.toJson(list);
		
		//요청한곳으로 응답을 보냄
		resp.getWriter().print(json);
		
	}

}
