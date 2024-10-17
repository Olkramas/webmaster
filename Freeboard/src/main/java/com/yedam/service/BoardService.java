package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardService {
	//목록 가져와야함.
	List<BoardVO> boardList();
	List<BoardVO> boardList(int page);
	
	//등록	
	boolean registerBoard(BoardVO board);
	
	//삭제
	boolean removeBoard(int boardNo);
	
	//수정
	boolean modifyBoard(BoardVO board);
	
	//단건조회
	BoardVO searchBoard(int boardNo);
	
}
