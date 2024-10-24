package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.CalendarService;
import com.yedam.service.CalendarServiceImpl;
import com.yedam.vo.CalendarVO;

public class addEventCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		CalendarService svc = new CalendarServiceImpl();
		
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		//파라미터르 다 받아서 객체를 만들었음
		CalendarVO cal = new CalendarVO();
		cal.setTitle(title);
		cal.setStart_date(start);
		cal.setEnd_date(end);
		
		//결과를 담을 hashMap 선언. 제이슨 타입으로 만들어서 반환하려고 함.
		Map<String, Object> result = new HashMap<>();
		
		//만든 객체를 svc.addEvent에 넣었음
		if(svc.addEvent(cal)) {
			//성공하면 retCode == OK
			result.put("retCode", "OK");
		} else {
			//실패하면 retCode == FAIL
			result.put("retCode", "FAIL");
		}
		
		//만들어진 result를 제이슨 형태로 변환해서 요청한 곳으로 응답
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(result));
		
	}

}
