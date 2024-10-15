package practice.chap02_06HomePractice;

public class ConditionalOperationExample148p {

	public static void main(String[] args) {
		int score = 65;
		
		char grade = (score >= 90) ? 'A' : ((score >= 80) ? 'B' : ((score >= 70) ? 'C' : 'D'));
		
		System.out.println("점수는 " + grade + "입니다.");
	}

}
