package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardService {
	//목록 가져와야함.
//	List<BoardVO> boardList()
	
	List<BoardVO> boardList(SearchDTO search);
	
	//등록	
	boolean registerBoard(BoardVO board);
	
	//삭제
	boolean removeBoard(int boardNo);
	
	//수정
	boolean modifyBoard(BoardVO board);
	
	//단건조회
	BoardVO searchBoard(int boardNo);
	
	//페이징 카운트
	int getTotalCount(SearchDTO search);
	
	//사용자별 게시글 개수 카운트
	List<Map<String, Object>> countByWriter();
}
