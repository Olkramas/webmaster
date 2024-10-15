package 최태백.Account;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AccountMainUseHashSet {

	
	static boolean noRe(Set<Account> accountSet, String ano) {
		for(Account ele : accountSet) {
			if(ele.getAno().equals(ano)) {
				return true;
			}
		}
		return false;
	}
	
	static int a(Set<Account> accountSet, String ano) {
		int count = 0;
		for(Account ele : accountSet) {
			if(ele.getAno().equals(ano)) {
				count++;
				break;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//계좌번호 중복을 피하기 위한 HashSet 선언
		Set<Account> accountSet = new HashSet<>();
		
		//입력받은 계죄 확인을 위한 변수
		String checkAno;
		
		//3, 4번 계좌 확인할때 사용할 변수
		Account getEle = null;
		
		boolean run = true;

		while (run) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.계좌삭제 | 6. 종료");
			System.out.println("------------------------------------------------------");
			System.out.print("선택 > ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			System.out.println();

			switch (menuNum) {
			case 1:
				System.out.println("***계좌생성***\n");
				while (true) {
					System.out.println("계좌번호 > ");
					String ano = scanner.nextLine();
					
					if(ano.trim().isEmpty()) {
						System.out.println("공백을 입력하셨습니다 \n초기 화면으로 돌아갑니다.\n");
						break;
					}
					
//					if(noRe(accountSet, ano) == true) {
//						System.out.println("계좌번호 중복입니다 \n초기 화면으로 돌아갑니다.\n");
//						break;
//					}
					
					if(a(accountSet, ano) == 1) {
						System.out.println("계좌번호 중복입니다 \n초기 화면으로 돌아갑니다.\n");
						break;
					}
					
					//다른방법
//					int count = 0;
//					for(Account ele : accountSet) {
//						if(ele.getAno().equals(ano)) {
//							count++;
//							break;
//						}
//					}
//					
//					if(count == 1) {
//						System.out.println("계좌번호 중복입니다 \n초기 화면으로 돌아갑니다.\n");
//						break;
//					}
					
					System.out.println("계좌주 > ");
					String owner = scanner.nextLine();

					System.out.println("초기 금액 입력");
					int balence = Integer.parseInt(scanner.nextLine());
					
					if(balence < Account.MIN_BALANCE || balence > Account.MAX_BALANCE) {
						 System.out.println("초기값은 0보다 커야하고 1,000,000원 보다 작아야합니다.\n");
						 break;
					}
					if(accountSet.size() == 100) {
						System.out.println("더이상 만들 수 없습니다.");
					} else {
						accountSet.add(new Account(ano, owner, balence));
						System.out.println("계좌가 생성되었습니다.\n");
					}
					break;
				}
				break;
			case 2:
				for(Account ele : accountSet) {
					ele.showList();
				}
				System.out.println();
				break;
			case 3:				
				System.out.println("---------------");
				System.out.println("예금");
				System.out.println("---------------");
				
				System.out.println("계좌번호: ");
				checkAno = scanner.nextLine();
				
				
				for(Account ele : accountSet) {
					if(ele.getAno().equals(checkAno)) {
						System.out.println("예금액: ");
						int inputM = Integer.parseInt(scanner.nextLine());
						//게좌번호가 맞을때의 Account 클래스의 객체를 getEle에 저장함
						getEle = ele;
						
						if (ele.getBalence() + inputM < Account.MAX_BALANCE) {
							ele.setBalence(ele.getBalence() + inputM);
							System.out.println("예금을 성공했습니다.\n");
						} else {
							System.out.println("통장 잔고가 1,000,000원을 초과합니다. \n메뉴로 돌아갑니다.\n");
						}
						break;
					}
					getEle = null;
				}
				
				if(getEle == null) {
					System.out.println("계좌번호를 확인하세요.\n");
					break;					
				}
				break;
			case 4:
				System.out.println("---------------");
				System.out.println("예금");
				System.out.println("---------------");
				
				System.out.println("계좌번호: ");
				checkAno = scanner.nextLine();
				
				for(Account ele : accountSet) {
					if(ele.getAno().equals(checkAno)) {
						System.out.println("출금액: ");
						int inputM = Integer.parseInt(scanner.nextLine());
						getEle = ele;
						
						if (ele.getBalence() - inputM > Account.MIN_BALANCE) {
							ele.setBalence(ele.getBalence() - inputM);
							System.out.println("출금을 성공했습니다.\n");
							break;
						} else {
							System.out.println("통장 잔액이 부족합니다. \n메뉴로 돌아갑니다.\n");
							break;
						}
					}
					getEle = null;
				}
				if(getEle == null) {
					System.out.println("계좌번호를 확인하세요.\n");
					break;					
				}
				break;
			case 5:
				int count = 0;
				System.out.println("---------------");
				System.out.println("계좌 삭제");
				System.out.println("---------------\n");
				
				System.out.println("----------생성된 계좌 리스트---------");
				for(Account ele : accountSet) {
					count++;
					ele.setCount(count);
					System.out.print("["+ ele.getCount() + "]   ");
					ele.showList();
				}
				System.out.println("--------------------------------\n\n");
				System.out.println("삭제할 계좌의 넘버링 번호를 입력해주세요.");
				int inputNum = Integer.parseInt(scanner.nextLine());
				
				
				//for문으로 바로 삭제하면 예외가 생김. 이터레이터를 삭제하면 오류없이 삭제가능.
				//concurrentmodificationexception
				Iterator<Account> accIr = accountSet.iterator();
				boolean retry = true;
				while(accIr.hasNext()) {
					int accCount = accIr.next().getCount();
					if(inputNum == accCount) {
						accIr.remove();
						retry = false;
						System.out.println("삭제되었습니다 \n메뉴로 돌아갑니다.\n");
					}
					
				}
				if(retry) {
					System.out.println("번호를 확인하세요\n메뉴로 돌아갑니다.\n");
					break;					
				}
				break;
				
			case 6:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
			}
		}
	}

}
