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

		resp.setContentType("text/json;charset=utf-8");
		//원본 게시글 번호가 필요함, 페이지 번호
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(Integer.parseInt(bno), Integer.parseInt(page));
		
		Gson gson = new GsonBuilder().create();
		//자바객체를 json 문자열로 변경하는 메소드
		//json 문자열로 응답을 보내줘야하기때문에 사용해야됨.
		String json = gson.toJson(list);
		
		resp.getWriter().print(json);
		//http://localhost/Freeboard/replyList.do?bno=??? url에서 확인가능
		
		
	}

}
