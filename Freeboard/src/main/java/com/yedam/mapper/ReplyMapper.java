package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {

	//댓글 리스트
	List<ReplyVO> selectList(int boardNo);
	
	//댓글 삭제
	int deleteReply(int replyNo);
	
	//댓글 등록
	int insertReply(ReplyVO reply);
	
	//
	ReplyVO selectReply(int replyNo);
}
