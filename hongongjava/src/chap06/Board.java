package chap06;

public class Board {
	//필드
	String title;
	String content;
	String writer;
	String date;
	int hitcount;
	
	//생성자
	//기본생성자가 없으면 객체를 만들때 생성자()안에 아무것도 안넣고는 만들 수 없음.
	Board(){};
	
	Board(String title, String content) {
		//이 this는 생성자의 제일 첫번째에 작성해야 함.
		this(title, content, "로그인한 회원아이디1", "현재 컴퓨터 날짜1", 0);
	}
	
	Board(String title, String content, String writer) {
		this(title, content, writer, "현재 컴퓨터 날짜2", 0);
	}
	
	Board(String title, String content, String writer, String date) {
		this(title, content, writer, date, 0);
	}
	
	
	Board(String title, String content, String writer, String date, int hitcount) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.date = date;
		this.hitcount = hitcount;
	}
	
	//메소드
	
}
