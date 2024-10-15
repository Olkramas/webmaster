package chap04;

import java.util.Scanner;

public class Exam173p {

	public static void main(String[] args) {
		//50~ 100까지 3의 배수 합 구하기
		//3의 배수 출력, 마지막에 3의 배수 합 출력
		//3의 배수 개수도 출력하기
		int sum = 0;
		int count = 0;
		
		System.out.print("50부터 100까지 3의 배수는 ");
		for(int i=50; i<=100; i++) {
			if(i%3 == 0) {
				sum += i;
				count++;
				//자바스크립트 처럼 변수를 만들고 거기에 i값을 문자열로 만들어서 저장할수도 있음.
				//그러나 자바에는 print메소드가 있기 때문에 이를 사용하면 한줄에 모두 출력가능함.
				System.out.print(i + " ");
			}
		}
		System.out.print("입니다.");
		System.out.println("\n50부터 100까지 3의 배수의 합은 " + sum);
		System.out.println("3의 배수의 개수는 " + count + "개 입니다.");
		
		//1에서 n까지의 합이 300이 넘는 순간 n값 구하기
		//7의 배수의 합이 300이 넘는 순간의 7의 배수 찾기
		//while문으로 만들기
		
		int sum2 = 0;
		int count1 = 0;
		
		while(true) {
			count1++;
			sum2 += 7 * count1;
			if(sum2 > 300) {
				break;
			}
		}
		System.out.println("7의 배수의 합이 300이 넘는 순간의 n값: " + count1 + "\n7의 배수는 " + (count1 * 7) + "입니다");
		System.out.println("7의 배수의 합은 " + sum2 + "입니다");
		
		
		
		//교수님 해설 if없이 만들기
		int su = 0;
		sum = 0;
		while(sum < 300) {
			su += 7;
			sum += su;
		}
		System.out.println("7의 배수는 " + su + "입니다.");
		System.out.println("7의 배수의 합은 " + sum + "입니다." );
		
		//while문 안에서 조건을 제대로 안걸면, 무한루프에 빠지기 쉬움
		
		//구구단 : 중첩 for문
		for(int i=2; i<10; i++) {
			System.out.println("\n====== " + i + "단 ======");
			for(int j=1; j<10; j++) {
				//System.out.println(i + " X " + j + "\t=   " + i*j);
				System.out.printf("%d X %d = %02d\n", i, j, i*j);   //----------> %02d를 통해 1의 자리 수도 09 이런식으로 출력가능. d 앞의 수는 몇자리를 표현해줄건지 표시할 수 있음. 
			}
		}
		
		
		//구구단 프로그램
		
		for(int n=2; n<10; n++) {
			System.out.print("=" + n + "단=\t");				
		}
		System.out.println();
		for(int i=1; i<10; i++) {
				
			for(int j=2; j<10; j++) {
				System.out.print(j + "X" + i + "=" + i*j + "\t" );
			}
			System.out.println();
		}
		
		
		//1부터 입력받은 수까지의 소수의 개수 구하기
		//소수 조건 나눴을 때 나머지가 1, 자기자신으로 나눴을 때 몫이 1
//		Scanner scanner = new Scanner(System.in);
//		int count2 = 0;
//		
//		System.out.println("1부터 입력한 수까지의 소수의 개수를 구하겠습니다. \n 수 입력: ");
//		int userNum = Integer.parseInt(scanner.nextLine());
//		
//		for(int i=1; i<=userNum; i++) {
//			if(i / 2 == 0) {
//				System.out.println("소수가 아닙니다.");
//			} else {
//				if(userNum % userNum == 0) {
//					System.out.println();
//				}
//				
//			}
//			
//		}
		
		
	}

}
