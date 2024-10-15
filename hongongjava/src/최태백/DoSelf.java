package 최태백;

import java.util.Scanner;

public class DoSelf {

	public static void main(String[] args) {
		//1 윤년 계산 프로그램
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("##년도 입력 > ");
		int year = Integer.parseInt(scanner.nextLine());
		
		if(year % 4 == 0 && year % 100 != 0) {
			System.out.println(year + "은 윤년입니다.");
		} else {
			System.out.println(year + "은 평년입니다.");
		}
		
		
		//2
		
		System.out.print("##교환할 금액: ");
		int toCoin = Integer.parseInt(scanner.nextLine());
		
		int coin500 = toCoin / 500;
		int coin100 = toCoin % 500 /100;
		int coin50 = toCoin % 100 / 50;
		int coin10 = toCoin % 50 / 10;
		int restOfCoin = toCoin % 10;
		
		System.out.println("500원 짜리 : " + coin500 + "개");
		System.out.println("100원 짜리 : " + coin100 + "개");
		System.out.println("50원 짜리 : " + coin50 + "개");
		System.out.println("10원 짜리 : " + coin10 + "개");
		System.out.println("교환 금액 : " + toCoin);
		System.out.println("남은 금액 : " + restOfCoin);
		
		//3
		
		int ranNum = (int) (Math.random() * 51) + 50;
		System.out.println(ranNum);
		
		while(true) {
		System.out.print("숫자 입력: ");
		
		int guessNum = Integer.parseInt(scanner.nextLine());
		
		if(guessNum > ranNum) {
			System.out.println("down하세요!!");
		} else if(guessNum < ranNum) {
			System.out.println("up하세요!");
		} else {
			System.out.println("축하합니다!!");
			break;
		}
		
		
		//4
		for(int i=2; i<=9; i++) {
			System.out.print(i + "단 \t");
		}
		System.out.println();
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=9; j++) {
				System.out.print(j + "X" + i + "=" + j*i + "\t");
			}
			System.out.println();
		}
		
		//5
		
		boolean temp = true;
		while(temp) {
			//온도를 저장할 변수 선언
			
			//메뉴 만들기
			System.out.println("------------------");
			System.out.println("1.화씨 => 섭씨");
			System.out.println("2.섭씨 => 화씨");
			System.out.println("3.종료");
			System.out.println("------------------");
			System.out.print("> 번호선택 :");
			int menuNum1 = Integer.parseInt(scanner.nextLine());
			
			switch(menuNum1) {
			case 1:
				System.out.print("> 화씨 온도 입력: ");
				double f = Double.parseDouble(scanner.nextLine());
				System.out.println("섭씨온도 = " + ((f-32)/1.8));
				break;
			case 2:
				System.out.println("> 섭씨 온도 입력: ");
				double c = Double.parseDouble(scanner.nextLine());
				System.out.println("화씨온도 = " + (c*1.8+32));
				break;
			case 3:
				System.out.println("program end");
				temp = false;
				break;
			default: System.out.println("잘못된 값을 입력하셨습니다.");
			}
		}
		
		
		
		//6
		
		boolean game6 = true;
		int userWin = 0;
		int comWin = 0;
		
		
		while(game6) {
			int random = (int) (Math.random() * 2) + 1;
			System.out.println("랜덤수" + random);
			System.out.println("##가위(0) 바위(1) 보(2)");
			int userInput = Integer.parseInt(scanner.nextLine());
			
			if(userInput == 0) {
				userInput = 3;
			}
			if(random == 0) {
				random =3;
			}
			
			if(userInput == 3 && random == 1) {
				System.out.println("사람 " + userWin + "\t컴 " + ++comWin + " 컴 승리");
				System.out.println("-------------");
			} else if(userInput < random) {
				System.out.println("사람" + userWin + " 컴" + ++comWin + " 컴 승리");
			} else if(userInput > random) {
				System.out.println("사람" + ++userWin + " 컴" + comWin + " 사람 승리");
			} else {
				System.out.println("gameover");
				game6 = false;
			}
		}
		
		//7.
		int num1 = 1;
		int num2 = 0;
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=10; j++) {
				num2++;
				if((j == 3 || j == 6 || j == 9) && (num1 % 30 == 0)) {
					System.out.print("**" + "\t");
				} else if((j == 3 || j == 6 || j == 9) || (num1 % 30 == 0 && j < 10) || (num2 % 30 == 0)) {
					System.out.print("*" + "\t");
				} else {
					System.out.print(num2 + "\t" );
				}
				
			}
			num1 = i*10;
			System.out.println();
		}
		
	}

	}
}	
