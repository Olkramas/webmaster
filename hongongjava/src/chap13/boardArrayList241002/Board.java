package chap13.boardArrayList241002;

public class Board {
	//field
	String subject;
	String content;
	String writer;
	
	//constructor
	public Board(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
	
	 @Override
	public String toString() {
		return subject + " : "  + content + " : " + writer; 
	}
}
