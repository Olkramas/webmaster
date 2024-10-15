package chap05;

import java.util.Arrays;

public class Exam202p {

	public static void main(String[] args) {
		// 배열을 생성하는 방법
		// 배열을 이용하는 방법
		int[] scores = { 83, 90, 87 };
		
		System.out.println("scores[0]: " + scores[0]);
		System.out.println("scores[1]: " + scores[1]);
		System.out.println("scores[2]: " + scores[2]);
		
		int sum = 0;
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		
		System.out.println("총합: " + sum);
		double avg = (double) sum / scores.length;
		System.out.printf("평균: %.2f", avg);			//소수점 두번째자리까지 출력. printf사용하기!
		
		System.out.println();
		System.out.println("------------------------------------------------------------\n");
		
		//배열에 1에서 100까지의 임의의 수 10개를 저장
		//배열의 합과 평군(소수 첫째자리까지) 최대값, 최소값을 구하세요.
		
		//배열 생성 (따로)
		//배열 이용, 합, 평균, 최대, 최소 구하기 (따로)
		
		//배열생성
		int[] array = new int[10];
		int[] array2 = {10, 20, 30};
		
		//합, 평균, 최대, 최소 값을 저장할 변수 선언
		int sum2 = 0;
		int max = 0;
		int min = 100;
		
		//for문을 만들어서 랜덤수 10개를 배열안에 넣기
		for(int i=0; i<array.length; i++) {
			int random = (int) (Math.random() * 100) + 1;
			//배열에 랜덤수 저장
			array[i] = random;
			
			//중복값 제거
			
			
			//배열 합 구하기
			sum2 += array[i];
			//최대값 구하기
			if(max < array[i]) max = array[i];
			//최소값 구하기
			if(min > array[i]) min = array[i];
			
		}
		//배열 평균 구하기 sum2가 정수라서 double로 강제 타입변환을 해야됨
		double avg2 = (double) sum2 / array.length;
		
		//출력하기
		System.out.printf("배열의 합: %d \n배열의 평균: %.1f \n배열의 최대값: %d \n배열의 최소값: %d", sum2, avg2, max, min);
		
		System.out.print("\narray 배열 = {");
		for(int i=0; i<array.length; i++) {
			if(i+1 != array.length) {
				System.out.print(array[i]);
				System.out.print(", ");
			} else {
				System.out.print(array[i]);
			}
		}
		System.out.print("}");
		
		System.out.println("\n" + array);
		System.out.println(Arrays.toString(array)); //배열을 한줄에 표현할 때 사용함. Arrays를 임포트시켜야함.
		
		System.out.println();
		//최대 최소 구하는 메소드 Arrays 클래스를 임포트 시켜야 사용가능함.
		int max2 = Arrays.stream(array).max().getAsInt();
        int min2 = Arrays.stream(array).min().getAsInt();
        
        System.out.println("\n메소드 사용 결과");
        System.out.println("최대값: " + max2 + " 최소값: " + min2);
        
        
        //메인메소드 배열을 출력함.
        int args1 = Integer.parseInt(args[1]);
        System.out.println(args1 + 100);
        
        
	}

}
