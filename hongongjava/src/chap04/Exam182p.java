package chap04;

import java.util.Scanner;

public class Exam182p {

	public static void main(String[] args) {
		//4
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				if(i+j == 13 && i < j) {
					System.out.println("(" + i + "," + j + ")");
				}
			}
		}
		
		//5
		String star1 = "*";
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(star1);
			}
			System.out.println();
		}
		System.out.println("=================");
		
		//6
		String str1 = "";
		String str2 = "";
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=4-i; j++) {
				str1 += "b";
			}
			str2 += "*";
			System.out.println(str1 + str2);
			str1 = "";
		}
		
		String str3 = "";
		String str4 = "";
		
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=4-i; j++) {
				str3 += "b";
				System.out.print(str3);
				str3 = "";
			}
			str4 += "*";
			System.out.print(str4);
			System.out.println();
		}
		
		
		
		//7.
		boolean run = true;
		int userMoney = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("---------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.print("메뉴 선택 > ");
			
			String menuNum = scanner.nextLine();												
			
			
			
			//각 숫자가 입력됐을 때 해당 기능을 해야됨.
			
			switch(menuNum) {
			case "1": 
				System.out.println("입금할 금액을 입력하세요.");
			    int inMoney = Integer.parseInt(scanner.nextLine());
			    userMoney += inMoney;
			    break;
			case "2":
				System.out.println("출금할 금액을 입력하세요.");
				int outMoney = Integer.parseInt(scanner.nextLine());
				if(userMoney - outMoney > 0) {
					userMoney -= outMoney;					
				} else {
					System.out.println("잔액이 부족합니다.");
					System.out.println("출금 가능 금액: " + userMoney + "원");
				}
				break;
			case "3":
				System.out.println("잔고: " + userMoney + "원");
				break;
			case "4": 
				System.out.println("프로그램 종료");
				run = false;
				break;
			default : System.out.println("잘못된 값을 입력하셨습니다. \n다시 입력하세요.");
			
			scanner.close();
			}
			
		}
		
		
		
		
	}

}
