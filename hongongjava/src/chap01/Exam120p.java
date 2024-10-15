package chap01;

import java.util.Scanner;

public class Exam120p {

	public static void main(String[] args) {
		//1. 출력문 연습
		String name = "감자바";
		int age = 25;
		String tel1="010", tel2="123", tel3="4567";
		
		System.out.println("이름: " + name);
		System.out.print("나이: " + age + "\n");
		System.out.printf("전화: %s-%s-%s", tel1, tel2, tel3);
		
		System.out.println();
		
		
		//2. scanner 이용 방법 연습
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 수: ");
		String strNum1 = scanner.nextLine();
		
		System.out.print("두번째 수: ");
		String strNum2 = scanner.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("덧셈결과: " + result);
		
		
		//3. scanner 이용 방법 연습
		System.out.print("이름: ");
		String realName = scanner.nextLine();
		
		System.out.print("\n주민번호 앞 6자리: ");
		String privateNum = scanner.nextLine();
		
		System.out.print("\n전화번호: ");
		String tel = scanner.nextLine();
		
		System.out.println("[입력된 내용]");
		System.out.println("이름: " + realName);
		System.out.println("주민번호 앞 6자리: " + privateNum);
		System.out.println("전화번호: " + tel);
		
		//두수를 입력 받아서 큰수 - 작은수
		
		//수 입력 받기
		System.out.print("첫번째 숫자를 입력하세요");
		int num3 = Integer.parseInt(scanner.nextLine());
		System.out.println("두번째 숫자를 입력하세요");
		int num4 = Integer.parseInt(scanner.nextLine());
		
		int result1;
		int result2 = num3 - num4;
		
		//if문을 사용해서 값이 -가 되지 않게 하기
		if(num3 > num4) {
			result1 = num3 - num4;
		} else {
			result1 = num4 - num3;
		}
		System.out.println("뺄셈 결과는: " + result1 + "입니다.");
		System.out.println("뺄셈 결과는: " + Math.abs(result2) + "입니다.");
		scanner.close();
	}

}
