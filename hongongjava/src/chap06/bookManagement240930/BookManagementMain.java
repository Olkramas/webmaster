package chap06.bookManagement240930;

import java.util.Scanner;

public class BookManagementMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//bookManagement배열 객체 생성하기.
		//배열변수 초기화 = 배열 변수에 null을 넣는다는 의미는 배열이 연결되지 않았다는 의미
		BookManagement[] bookArr = null;
		boolean run = true;
		
		while(run) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("------------------------------------------------------");
			System.out.println("1.도서 수 입력 | 2.도서 입력 | 3.도서목록 조회 | 4.도서분석 | 5.종료");
			System.out.println("------------------------------------------------------");
			
			int menuNum = Integer.parseInt(scanner.nextLine());
			switch(menuNum) {
				case 1: 
					System.out.println("저장할 도서의 개수를 입력해주세요.");
					int NumOfBook = Integer.parseInt(scanner.nextLine());
					//배열 길이 입력받아서 배열 만들기
					bookArr = new BookManagement[NumOfBook];
					break;
				case 2:					
					System.out.println("책의 제목과 도서번호 도서목록을 차례로 입력해주세요.");
					for(int i=0; i<bookArr.length; i++) {
						System.out.print("책 제목 입력 > \n");
						String bookName = scanner.nextLine();
						
						System.out.println("도서번호 입력 > \n");
						int bookNum = Integer.parseInt(scanner.nextLine());
						
						System.out.println("도서 가격 입력 > \n");
						int bookPrice = Integer.parseInt(scanner.nextLine());
						
						//setter로 하면 셋으로 받고 그걸 다시 배열에 넣고 복잡해짐.
						//그냥 생성자로 하면 훨씬 편함.
						bookArr[i] = new BookManagement(bookName, bookNum, bookPrice);
					}
					break;
				case 3:
					//책 목록 출력
					for(int i=0; i<bookArr.length; i++) {
						bookArr[i].printBookList();
					}
					break;
				case 4:
					int priceSum = 0;
					int maxPrice = 0;
					int minPrice = Integer.MAX_VALUE;
					String title = null;
					for(int i=0; i<bookArr.length; i++) {
						priceSum += bookArr[i].getBookPrice();
						if(maxPrice < bookArr[i].getBookPrice()) {
							maxPrice = bookArr[i].getBookPrice();
							title = bookArr[i].getBookName();
						}
						if(minPrice > bookArr[i].getBookNum()) {
							minPrice = bookArr[i].getBookNum();
						}
					}
					double priceAvg = priceSum / bookArr.length;
					
					System.out.println("가격의 평균: " + priceAvg + "\t가격의 최대값: " + maxPrice + "\t가격의 최소값: " + minPrice);
					System.out.println("가장 비산 책: " + title);
					break;
				case 5:
					System.out.println("시스템을 종료합니다");
					run = false;
					break;
				default : 
			}
		}
	}

}
