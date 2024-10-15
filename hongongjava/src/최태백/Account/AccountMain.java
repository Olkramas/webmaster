package 최태백.Account;

import java.util.Scanner;

public class AccountMain {
	
	static int count = 0;
	
	// 배열 선언
	static Account[] bank = new Account[100];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		
		boolean run = true;

		while (run) {
			System.out.println("------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택 > ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			System.out.println();

			switch (menuNum) {
			case 1:
				System.out.println("계좌생성");

				while (true) {
					if (bank[count] == null && count < 100) {
						System.out.println("계좌번호: ");
						String ano = scanner.nextLine();
						System.out.println(ano);
						//계좌가 존재한다면 1이 리턴되는 noRepetition메소드를 통해 계좌의 중복을 피함.
						if(noRepetition(ano) == 1) {
							System.out.println("계좌번호 중복입니다. 초기화면으로 돌아갑니다.");
							break;
						}
						
						//trim().은 입력받은 문자열 양 옆 공백을 없앰 isEmpty()는 공백(스페이스, 탭, 엔터)이 있으면 true를 리턴함.
						if(ano.trim().isEmpty()) {
							System.out.println("공백을 입력하셨습니다 계좌번호를 입력하세요.");
							break;
						}

						System.out.println("계좌 주: ");
						String owner = scanner.nextLine();

						System.out.println("초기 금액 입력");
						int balence = Integer.parseInt(scanner.nextLine());
						
						if(balence < Account.MIN_BALANCE || balence > Account.MAX_BALANCE) {
							 System.out.println("초기값은 0보다 커야하고 1,000,000원 보다 작아야합니다.");
							 break;
						}

						bank[count] = new Account(ano, owner, balence);

						System.out.println("계좌가 생성되었습니다.");
						count++;
						break;
					}

				}
				break;

			case 2:
				for (int i = 0; i <= count - 1; i++) {
					bank[i].showList();
				}
				break;

			case 3:
				System.out.println("---------------");
				System.out.println("예금");
				System.out.println("---------------");

				System.out.println("계좌번호: ");
				String checkAno = scanner.nextLine();
				if(noRepetition(checkAno) != 1) {
					System.out.println("계좌번호를 확인하세요.");
				}
				
				for (int i = 0; i < count; i++) {
					if (bank[i].getAno().equals(checkAno)) {
						System.out.println("예금액: ");
						int inputM = Integer.parseInt(scanner.nextLine());
						
						if (bank[i].getBalence() + inputM <= Account.MAX_BALANCE) {
							bank[i].setBalence(bank[i].getBalence() + inputM);
							System.out.println("예금을 성공했습니다.");
						} else {
							System.out.println("통장 잔고가 1,000,000원을 초과합니다. \n메뉴로 돌아갑니다.");
						}
						
					}
					
//					if (i+1 == count) {
//						System.out.println("계좌번호를 확인해주세요.");
//						break;
//					}
				}
				
				break;
			case 4:
				System.out.println("---------------");
				System.out.println("출금");
				System.out.println("---------------");

				System.out.println("계좌번호: ");
				String checkAno1 = scanner.nextLine();
				if(noRepetition(checkAno1) != 1) {
					System.out.println("계좌번호를 확인하세요.");
				}
				
				for (int i = 0; i < count; i++) {
					if (bank[i].getAno().equals(checkAno1)) {
						System.out.println("출금액: ");
						int inputM = Integer.parseInt(scanner.nextLine());
						if (bank[i].getBalence() - inputM >= Account.MIN_BALANCE) {
							bank[i].setBalence(bank[i].getBalence() - inputM);
							System.out.println("출금을 성공했습니다.");
						} else {
							System.out.println("통장 잔액이 부족합니다.");
						}
					}
					
//					if (i+1 == count) {
//						System.out.println("계좌번호를 확인해주세요.");
//						break;
//					}
				}
				break;
			case 5:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
			}
		}
	}
	
	//중복을 피하기 위한 메소드
	static int noRepetition(String ano) {
		int noRe = 0;
		for(int i=0; i<count; i++) {
			if(bank[i].getAno().equals(ano)) {
				//만약 같은 계좌번호가 있다면 1이 리턴됨.
				noRe++;
			}
		}
		return noRe;
	}

}