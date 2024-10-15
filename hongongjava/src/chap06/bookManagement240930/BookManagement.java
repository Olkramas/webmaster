package chap06.bookManagement240930;


public class BookManagement {
	//책제목, 도서번호, 도서가격
	private String bookName;
	private int bookNum;
	private int bookPrice;
//	private String[][] bookArr;
	
	//생성자
	BookManagement() {};
	BookManagement(String bookName, int bookNum, int bookPrice) {
		this.bookName = bookName;
		this.bookNum = bookNum;
		this.bookPrice = bookPrice;
	}
	
	//메소드
	//책 리스트 출력
	public void printBookList() {
		System.out.println("책 제목: " + getBookName() + "\t도서번호: " + getBookNum() + "\t책 가격:" + getBookPrice()); 
	}
	
	public String getBookName() {return bookName;}
	public void setBookName(String bookName) {this.bookName = bookName;}
	public int getBookNum() {return bookNum;}
	public void setBookNum(int bookNum) {this.bookNum = bookNum;}
	public int getBookPrice() {return bookPrice;}
	public void setBookPrice(int bookPrice) {this.bookPrice = bookPrice;}
	
	
	
}
