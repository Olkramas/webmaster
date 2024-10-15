package bookManagement.강현이형꺼;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookDao dao = new BookDao();
		int cnt = 0;
		boolean run = true;
		
		while (run) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("1. 도서등록 2. 도서검색 3. 도서전체 조회 4. 도서삭제 5. 도서 정보 변경 6. 종료 ");
			System.out.println("--------------------------------------------------------------");
			System.out.println("메뉴 선택 > ");
			int SelNo = Integer.parseInt(sc.nextLine());
			switch(SelNo) {
			case 1 : //선택1번 : 도서등록
				System.out.println("[도서등록]");
				System.out.print("책제목 : ");
				String title = sc.nextLine();
				System.out.print("저자 : ");
				String writer = sc.nextLine();
				System.out.println("가격 : ");
				int price = Integer.parseInt(sc.nextLine());
				System.out.print("책번호 : ");
				String bnum = sc.nextLine();
				
				Book book = new Book(title, writer, price, bnum);
				dao = new BookDao();
				cnt = dao.insert(book);
				if(cnt == 1) {
					System.out.println("추가 성공");
				}else {
					System.out.println("추가 실패");
				}
				break;
			case 2 : //선택2번 : 도서검색 = > 책제목으로 검색
				System.out.print("책제목 : ");
				String title1 = sc.nextLine();
				dao.select(title1);
				
				break;
			case 3 : //선택3번 : 도서전체 조회
				dao.selectAll();
				break;
			case 4 : //선택4번 : 도서삭제
				System.out.print("책제목 : ");
				String title2 = sc.nextLine();
				int rows = dao.delete(title2);
				if(rows ==1 ) {
					
					System.out.println("성공");
					
				}else {
					System.out.println("실패");
				}
				
				break;

			case 5 : //선택5번 : 도서 정보 변경
				System.out.print("책제목 : ");
				String title3 = sc.nextLine();
				System.out.println("가격 : ");
				int price1 = Integer.parseInt(sc.nextLine());
				System.out.print("책번호 : ");
				String bnum1 = sc.nextLine();
//				dao.update(title3, price1, bnum1);
				int rows1 = dao.update(title3, price1, bnum1);
				if(rows1 ==1 ) {
					
					System.out.println("성공");
					
				}else {
					System.out.println("실패");
				}
				
				break;
			case 6 : //선택6번 : 프로그램 종료
				run = false;
				sc.close();
				System.out.println("프로그램 종료");

			}
		}

	}

}
