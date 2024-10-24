package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.CalendarVO;

public interface CalendarService {
	List<Map<String, Object>> event();
	
	boolean addEvent(CalendarVO calendar);
	
	boolean removeEvent(String title);
}
