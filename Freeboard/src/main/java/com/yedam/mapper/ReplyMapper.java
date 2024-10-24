package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {

	//댓글 리스트
	List<ReplyVO> selectList(int boardNo);
	
	
	List<ReplyVO> selectListPaging(@Param("bno") int boardNo, @Param("page") int page);
	
	//댓글 삭제
	int deleteReply(int replyNo);
	
	//댓글 등록
	int insertReply(ReplyVO reply);
	
	//단건 조회
	ReplyVO selectReply(int replyNo);
	
	//댓글 건수 가져오기
	int selectCount(int boardNo);
	
	
	
}
