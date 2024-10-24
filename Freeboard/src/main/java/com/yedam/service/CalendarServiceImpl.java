package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.CalendarMapper;
import com.yedam.vo.CalendarVO;

public class CalendarServiceImpl implements CalendarService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
	
	@Override
	public List<Map<String, Object>> event() {
		return mapper.event();
	}

	@Override
	public boolean addEvent(CalendarVO calendar) {
		return mapper.insertEvent(calendar) == 1;
	}

	@Override
	public boolean removeEvent(String title) {
		return mapper.deleteEvent(title) == 1;
	}

}
