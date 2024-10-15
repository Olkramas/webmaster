package chap03;

import java.util.Scanner;

public class ExamEndOfChap03 {

	public static void main(String[] args) {
		//6.
		int value = 356;
		System.out.println(value / 100 * 100);
		
		//7.
		float var1 = 10f;
		float var2 = var1 / 100;
		
		// 0.1뒤에 f를 붙여서 float 값이라고 알려줘야 함.
		if(var2 == 0.1) {
			System.out.println("10%입니다.");
		} else {
			System.out.println("10%가 아닙니다.");
		}
		
		//8.
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop + lengthBottom) * height /2;
		System.out.println("사다리꼴의 넓이: " + area);
		 
		//9. 두 실수를 입력받고 첫번째 수 / 두번째 수가 0또는 0.0이 입력됐을 경우 "결과: 무한대"가 출력되게 만들기
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("첫번째 수를 입력하세요");
		double num1 = Double.parseDouble(scanner.nextLine());
		System.out.println("두번째 수를 입력하세요");
		double num2 = Double.parseDouble(scanner.nextLine());
		
		if(num2 != 0.0) {
			System.out.println("결과: " + num1 / num2);
		} else {
			System.out.println("결과: 무한대");
		}
		
		//10.
		int var3 = 10;
		int var4 = 3;
		
	}
}
