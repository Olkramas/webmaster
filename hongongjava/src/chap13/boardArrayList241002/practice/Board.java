package chap13.boardArrayList241002.practice;

public class Board {
	String subject;
	String content;
	String writer;
	
	public Board(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
		
	}
	
	@Override
	public String toString() {
		return this.subject + " : " + this.content + " : " + this.writer; 
	}
}
