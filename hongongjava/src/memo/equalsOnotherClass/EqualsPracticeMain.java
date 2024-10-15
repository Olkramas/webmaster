package memo.equalsOnotherClass;

public class EqualsPracticeMain {

	public static void main(String[] args) {
		EqualsPractice eq1 = new EqualsPractice("최태백");
		EqualsPractice eq2 = new EqualsPractice("최태백");
		
		if(eq1.st1.equals(eq2.st1)) {
			System.out.println("같은 문자열입니다.");
		} else {
			System.out.println("다른 문자열입니다.");
		}

	}

}
