package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.CalendarMapper;

public class CalendarServiceImpl implements CalendarService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	CalendarMapper mapper = sqlSession.getMapper(CalendarMapper.class);
	
	@Override
	public List<Map<String, Object>> event() {
		return mapper.event();
	}

}
