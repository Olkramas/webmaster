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

public class removeEventCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CalendarService svc = new CalendarServiceImpl();
		
		String title = req.getParameter("title");
		
		Map<String, String> result = new HashMap<>();
		
		if(svc.removeEvent(title)) {
			result.put("retCode", "OK");
		} else {
			result.put("retCode", "FAIL");			
		}
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(result));
	}

}
