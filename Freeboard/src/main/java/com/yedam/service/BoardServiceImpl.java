package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boardList(int page) {
		return mapper.listWithPage(page);
	}

	@Override
	public boolean registerBoard(BoardVO board) {
		return mapper.insertBoard(board) == 1;
	}

	@Override
	public boolean removeBoard(int boardNo) {
		return mapper.deleteBoard(boardNo) == 1;
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		return mapper.updateBoard(board) == 1;
	}

	@Override
	public BoardVO searchBoard(int boardNo) {
		//글이 조회하기도 하고 조회수를 증가하는 기능을 가짐
		mapper.updateCount(boardNo);
		return mapper.selectBoard(boardNo);
	}



	
}