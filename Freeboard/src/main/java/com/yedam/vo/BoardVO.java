package com.yedam.vo;

import java.util.Date;

import lombok.Data;

//@Data getter setter toString 외에도 해쉬코드 등 많은것들이 오버라이딩 돼있음.
@Data
public class BoardVO {
	private int boardNo;	//board_no - boardNo오라클과 자바가 매칭이 되게 만들어놨음
	private String title;
	private String content;
	private String writer;
	private String writerName;
	private int viewCnt;
	private Date writeDate;
	private Date updateDate;
	private String img;
}
