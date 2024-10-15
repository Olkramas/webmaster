package chap04;

public class Exam162 {

	public static void main(String[] args) {
		//주사위 2개를 던져서 합이 5가되면 종료 - gameover
		//5가 아니면 (1,3) 주사위 눈 표시
		
		int count1 = 0;
		int count2 = 0;
		
		while(true) {			
			int num1 = (int)(Math.random() * 6 + 1);
			int num2 = (int)(Math.random() * 6 + 1);
			count1++;
			System.out.print("(" + num1 + "," + num2 + ")\t");
			if(num1 + num2 == 5) {
				System.out.print(count1 + "회 시도했습니다. ");
				System.out.println("gameover");
				break;
			}
		}
		
		while(true) {
			int num1 = (int)(Math.random() * 6 + 1);
			int num2 = (int)(Math.random() * 6 + 1);
			count2++;
			System.out.printf("(%d,%d) \t", num1, num2);
			if(num1 + num2 == 5) {
				System.out.print(count2 + "회 시도했습니다. ");
				System.out.print("gameover \n");
				break;
			}
		}
		
		//주사위 눈이 1이면 1등, ~ 6이면 6등이라고 출력
		int num3 = (int)(Math.random() * 6 + 1);
		
		if(num3 == 1) {
			System.out.println("1등");
		} else if(num3 == 2) {
			System.out.println("2등");
		} else if(num3 == 3) {
			System.out.println("3등");
		} else if(num3 == 4) {
			System.out.println("4등");
		} else if(num3 == 5) {
			System.out.println("5등");
		} else {
			System.out.println("6등");
		}
		
		switch(num3) {
		case 1: System.out.println("1등"); break;
		case 2: System.out.println("2등"); break;
		case 3: System.out.println("3등"); break;
		case 4: System.out.println("4등"); break;
		case 5: System.out.println("5등"); break;
		case 6: System.out.println("6등"); break;
		default: System.out.println("잘못된 값이 입력되었습니다.");
		}
		
		System.out.println(num3 + "등");
		
		//50에서 100까지 수를 발생, 90이상이면 A, 80이상이면 B, 70이상이면 C, 60이상 D, 나머지 F
		//switch문으로 작성
		
		//50곱하고, 50더하면 100점이 절대 안나와서 51을 곱했음.
		
		//곱수는 최종값 - 초기값 + 1
		double num4 = (Math.random() * 51) + 50;
		int num5 = (int) num4 / 10;
		
		switch(num5) {
		case 10:
		case 9: System.out.println("점수는 " + (int)num4 + "점" + " A 등급입니다"); break;
		case 8: System.out.println("점수는 " + (int)num4 + "점" + " B 등급입니다"); break;
		case 7: System.out.println("점수는 " + (int)num4 + "점" + " C 등급입니다"); break;
		case 6: System.out.println("점수는 " + (int)num4 + "점" + " D 등급입니다"); break;
		case 5: System.out.println("점수는 " + (int)num4 + "점" + " F 등급입니다"); break;
		default: System.out.println("잘못된 값입니다.");
		}
		
		//50이 나오는지 확인
		int count3 =0;
		while(true) {
			double num6 = (Math.random() * 51) + 50;
			int num7 = (int) num6 / 10;
			count3++;
			if((int)num6 == 50) {
				System.out.println("\nnum7는 " + num7 + "입니다." + "\n" + count3 + "회 실행했습니다.");
				break;
			}
		}
	}

}
