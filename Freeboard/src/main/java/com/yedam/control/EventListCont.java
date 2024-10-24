package com.yedam.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.CalendarService;
import com.yedam.service.CalendarServiceImpl;

public class EventListCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CalendarService svc = new CalendarServiceImpl();
		List<Map<String, Object>> result = svc.event();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//제이슨 문자열로 만들기
		String json = gson.toJson(result);
	}

}
