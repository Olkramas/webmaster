package 최태백;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		//2024.09.26 과제
		
		//1
		
		int[] ranArr = new int[10]; 
		int sum = 0;
		int max = 0;
		int min = 0;
		
		for(int i=0; i<ranArr.length; i++) {
			int ranNum = (int) (Math.random() * 100) + 1; 
			ranArr[i] = ranNum;
			sum += ranArr[i];
			if(max < ranArr[i]) max = ranArr[i];
			if(min > ranArr[i]) min = ranArr[i];
		}
		System.out.println("배열출력: " + Arrays.toString(ranArr));
		System.out.printf("배열의 합계: %d, 최대값: %d, 최소값: %d", sum, max, min);
		System.out.println("\n\n----------------------------------------------\n");
		
		//2
		int[][] arr2 = {
				{1,2,3},
				{1,2},
				{1,},
				{1,2,3}
		};
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		
		//3
		//3행 10열 2차연 배열 만들기
		int[][] arr3 = new int[3][10];
		int count3 = 0;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<10; j++) {
				int ranNum3 = (int) (Math.random() * 10) % 2; 
				arr3[i][j] = ranNum3;
				System.out.print(arr3[i][j] + "\t");
				if(ranNum3 == 1) {
					count3++;
				}
			}
			System.out.println();
		}
		System.out.println("현재 관객수는" + count3 + "명 입니다.");
		
		//난수를 만들어 0,1이 랜덤하게 나오게 만들기.
		System.out.println("------------------------------------------");
		
		
		//4
		
		//2차원 배열을 만들어서 행이 학생, 열이 점수
		int[][] arr4 = new int[3][5];
		for(int i=0; i<arr4.length; i++) {
			for(int j=0; j<arr4[i].length; j++) { 
				int ranNum4 = (int) (Math.random() * 51) + 50; 
				arr4[i][j] = ranNum4;
			}
		}
		
		for(int i=0; i<arr4.length; i++) {
			for(int j=0; j<arr4[i].length; j++) { 	
				System.out.print(arr4[i][j] + "\t");
			}
			System.out.println();
		}
		for(int i=0; i<arr4.length; i++) {
			int studentSum = 0;
			double studentAvg = 0;
			for(int j=0; j<arr4[i].length; j++) { 
				studentSum += arr4[i][j];
			}
			studentAvg = studentSum / arr4[i].length;
			System.out.println(i + "번 학생의 평균 = " + studentAvg); 
		}
		
		//5
		
		//배열 두개를 만들어서 기호 + 숫자 조합하기
		String[] shape = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] trumpNum = {"2","3","4", "5", "6","7","8","9","10","Jack","Queen","King","Ace"};
		
		//난수를 만들기 - 난수가 인덱스 번호가 됨. 위 배열이 두개이기 때문에 각각을 위한 난수를 만들어야함.
		
		//for문은 총 5번 돌아야 함.
		for(int i=0; i<5; i++) {
			int shapeRan = (int) (Math.random() * 4);
			int trumpRan = (int) (Math.random() * 12);
			
			System.out.println(shape[shapeRan] + "의 " + trumpNum[trumpRan]);
		}
		System.out.println();
		
		//6
		
		//2차원 배열 선언
		int[][] ranPlace = new int[3][5];
		
		//5번 반복할 for문 (1을 넣기위한 반복)
		for(int i=0; i<5; i++) {
			//난수를 생성해서 두 수를 인덱스 번호로 사용. 무작위로 1을 넣을 수 있음.
			int rowRan = (int) (Math.random() * 3);
			int colRan = (int) (Math.random() * 5);
			//랜덤으로 생성한 2차원 배열의 인덱스 번호에 1이 아니고, check가 0,1,2,3,4일 때만 실행하는 if문.  
			if(ranPlace[rowRan][colRan] != 1) {				
				ranPlace[rowRan][colRan] = 1;	//위 조건이 만족했을 때 배열에 1추가
			//만약 인덱스 번호안에 1이 있다면 i를 하나빼서 for문을 다시 반복하게 만들었음.
			} else {
				i--;
			}
		}
		System.out.println();
		
		//출력을 위한 for문
		for(int i=0; i<ranPlace.length; i++) {
			for(int j=0; j<ranPlace[i].length; j++) {
				System.out.print(ranPlace[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		
		
		
		
		//cnt를 하나 만들거임. 그걸로 조건 맞을때 1을 출력하면, 카운트가 올라가고 그 카운트가 5가 되면 정지함.
		//1이 5개보다 적어서는 안됨. == 만약 적다면, cnt가 5이하라면 for문 다시 수행
		
		
//		int count6 = 0;
//		int check = 0;
//		
//		for(int i=0; i<ranPlace.length; i++) {
//			for(int j=0; j<ranPlace[i].length; j++) {
//				int oneOrTwo = (int) (Math.random() * 10) % 2;
//				if((i == ranPlace.length && j == ranPlace[i].length) && (count6 != 5) ) {
//					//i가 3이고, j가 5일때, count6(1을 출력한 횟수)가 5가 아닐때 i를 0으로 만들어서 for문을 처음부터 돌려버림. 될때까지 하는겨
//					i = 0;
//					check++;
//				} else if(oneOrTwo == 1 && count6 != 5) {
//					count6++;
//					ranPlace[i][j] = oneOrTwo;
//				}
//				
//				System.out.print(ranPlace[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("check: " + check);
//		System.out.println("count6: " + count6);
//		System.out.println("ranPlcae.length: " + ranPlace.length);
//		System.out.println("ranPlace[0].length: " + ranPlace[0].length);
		
		
		
	}

}
