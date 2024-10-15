package chap06.bookManagement240930.practice;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Book[] books = null;
		boolean run = true;
		
		while(run) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("-------------------------------------------------");
			System.out.println("1.도서 수 입력 | 2.도서 입력 | 3.도서목록 조회 | 4.도서분석 | 5.종료");
			System.out.println("-------------------------------------------------");
			int menuNum = Integer.parseInt(scanner.nextLine());
			
			switch(menuNum) {
				case 1: 
					System.out.println("도서 수를 입력하세요 > ");
					int NumOfBook = Integer.parseInt(scanner.nextLine());
					//배열의 길이를 생성했음.
					books = new Book[NumOfBook];
					break;
				case 2:
					System.out.println("도서명, 도서번호, 책 가격등을 안내에 따라 차례대로 입력하세요.");
					
					for(int i=0; i<books.length; i++) {
						System.out.println("도서명을 입력하세요 >");
						String title = scanner.nextLine();
						
						System.out.println("도서 번호를 입력하세요");
						int bNum = Integer.parseInt(scanner.nextLine());
						
						System.out.println("책 가격을 입력하세요.");
						int price = Integer.parseInt(scanner.nextLine());
						
						books[i] = new Book(title, bNum, price);
					}
					break;
				case 3:
					for(int i=0; i<books.length; i++) {
						books[i].printAll();
					}
					break;
				case 4:
					int sum = 0;
					int max = 0;
					for(int i=0; i<books.length; i++) {
						sum += books[i].getPrice();
						if(max < books[i].getPrice()) max = books[i].getPrice();
					}
					double avg = (double) sum / books.length;
					
					System.out.println("책 가격의 평균: " + avg + " 책 가격 최대값: " + max);
				case 5:
					run = false;
					break;
				default :
			}
		}

	}

}
