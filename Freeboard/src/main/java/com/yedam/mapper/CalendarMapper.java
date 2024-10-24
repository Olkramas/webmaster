package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.CalendarVO;

public interface CalendarMapper {
	List<Map<String, Object>> event();
	
	int insertEvent(CalendarVO calendar);
	
	int deleteEvent(String title);
}
