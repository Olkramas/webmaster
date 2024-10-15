package chap06.bookManagement240930.practice;

public class Book {
	private String title;
	private int bNum;
	private int price;
	
	Book(String title, int bNum, int price) {
		this.title = title;
		this.bNum = bNum;
		this.price = price;
	}
	
	//메소드
	public void printAll() {
		System.out.println("책 이름: " + title + "\t도서번호: " + bNum + "\t책 가격: " + price);
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
