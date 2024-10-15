package memo;

import java.util.Scanner;

public class MinorityCount {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int userNum = Integer.parseInt(scanner.nextLine());
		
		for(int j=2; j<userNum; j++) {
			if(userNum % 3 != 0) {
				count++;
			}
		}
		System.out.println(count);
		scanner.close();
	}

}
