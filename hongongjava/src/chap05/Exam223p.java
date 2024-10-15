package chap05;

import java.util.Scanner;

public class Exam223p {

	public static void main(String[] args) {
		//확인문제 6번
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("------------------------------------");
			System.out.print("선택 > \n");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			switch(selectNo) {
				case 1: 
					System.out.print("학생수 > ");
					studentNum = Integer.parseInt(scanner.nextLine());
					scores = new int[studentNum];
					break;
				case 2:  
					for(int i=0; i<studentNum; i++) {
						System.out.print("scores[" + i + "] > ");	
						scores[i] = Integer.parseInt(scanner.nextLine());
					}
					break;
				case 3:  
					for(int i=0; i<studentNum; i++) {
						System.out.println("scores[" + i + "] > " + scores[i]);
					}
					if(scores == null) {
						System.out.println("점수를 먼저 입력해주세요.");
					}
					break;
				case 4: 
					if(scores == null) {
						System.out.println("점수를 먼저 입력해주세요.");
					} else {						
						int maxScore = 0;
						int sum = 0;
						double avgScore = 0;
						
						for(int i=0; i<studentNum; i++) {
							//합구하기
							sum += scores[i];
							if(maxScore < scores[i]) maxScore = scores[i];
						}
						avgScore = (double) sum / scores.length;
						System.out.println("최고점수: " + maxScore);
						System.out.println("평균점수: " + avgScore);
					}
					break;
				case 5:
					run = false;
					break;
				default : System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}
		System.out.println("프로그램 종료");
	}

}
