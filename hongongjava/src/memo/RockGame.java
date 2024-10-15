package memo;

import java.util.Scanner;

public class RockGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//6
		
		boolean game6 = true;
		int userWin = 0;
		int comWin = 0;
		
		while(game6) {
			int random = (int) (Math.random() * 2) + 1;
			System.out.println("랜덤수" + random);
			System.out.println("##가위(0) 바위(1) 보(2)");
			int userInput = Integer.parseInt(scanner.nextLine());
			
			if(userInput == 0) {
				userInput = 3;
			}
			if(random == 0) {
				random =3;
			}
			
			if(userInput == 3 && random == 1) {
				System.out.println("사람 " + userWin + "\t컴 " + ++comWin + " 컴 승리");
				System.out.println("-------------");
			} else if(userInput < random) {
				System.out.println("사람" + userWin + " 컴" + ++comWin + " 컴 승리");
			} else if(userInput > random) {
				System.out.println("사람" + ++userWin + " 컴" + comWin + " 사람 승리");
			} else {
				System.out.println("gameover");
				game6 = false;
			} 
		}
		scanner.close();
	}

}
