package chap06;

import java.util.Scanner;

public class MemberServiceMain {

	public static void main(String[] args) {
		//1.메뉴를 띄워주기
		//2. 1,2,3...메뉴를 보여주기
		//예를 들어 4가 로그아웃이면 4눌렀을 때 아이디 치고 로그아웃 되도록 만들어보기
		
		//hong, 12345들어갔을 때 로그인 성공
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 > ");
		String userId = scanner.nextLine();
		System.out.println();
		System.out.print("비밀번호를 입력하세요 > ");
		String userPassword = scanner.nextLine();
		System.out.println();
		
		MemberService memberService = new MemberService();
		boolean result = memberService.login(userId, userPassword);
		
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
		} else {
			System.out.println("id또는 password가 올바르지 않습니다.");
		}
		
		
	}

}
