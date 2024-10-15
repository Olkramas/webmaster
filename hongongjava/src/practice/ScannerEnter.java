package practice;

import java.util.Scanner;

public class ScannerEnter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "내용 > ";
		int count = 0;
		
		System.out.println("입력을 시작합니다\n입력종료를 원하시면 \"CLOSE\"를 입력하세요");
		while(true) {
			String a = sc.nextLine();
			
			if(a.equals("CLOSE")) {
				System.out.println("입력을 종료합니다.");
				break;
			}
			
			count++;
			if(count == 1) {
				result += a + "\n";
			} else {
				result += "     " + a + "\n";
			}
		}
		System.out.println(result);
		
	}

}
