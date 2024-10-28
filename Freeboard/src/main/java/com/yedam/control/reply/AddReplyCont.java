package com.yedam.control.reply;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		
		//parameter: bno, reply(댓글내용), replyer
		String bno = req.getParameter("bno");
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");
		
		ReplyService svc = new ReplyServiceImpl();
		
		//replyVo객체 만들기
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
				
		//reply_seq.nextval가 없어서 웹에 바로 적용을 못함
		//http://localhost/Freeboard//addReply.do?bno=173&reply=test&replyer=user01
		
		//반환값을 선언
		//Object ok, rvo가 같이 들어가야하기때문에 
		Map<String, Object> result = new HashMap<>();
		
		try {
			//reCode:OK, retVal: rvo
			svc.addReply(rvo);
			
			result.put("retCode", "OK");
			result.put("retVal", rvo);
			
			System.out.println(rvo);
		} catch(Exception e) {
			e.printStackTrace();
			//실패했을때 넘어가는 값
			result.put("retCode", "FAIL");
			result.put("retVal", null);
		}
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(result));
		
	}

}
