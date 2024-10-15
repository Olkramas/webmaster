package practice.chap02_06HomePractice;

public class EqualsPractice {

	public static void main(String[] args) {
		String str1 = "최태백";
		String str2 = "최태백";
		String str3 = new String("최태백");
		String str4 = new String("최태백");
		
		if(str1 == str2) {
			//String은 같은 문자열을 값으로 저장할 경우 같은 주소를 참조하게 돼있음.
			System.out.println("str1과 str2는 동일한 주소를 참조하고 있습니다.");
		} else {
			System.out.println("주소가 다릅니다.");
		}
		
		if(str1.equals(str2)) {
			System.out.println("st1과 str2는 같은 문자열입니다.");
		}
		System.out.println("-------------------------------------------------------");
		if(str3 == str4) {
			//new로 힙영역에서 새로운 영역을 객체별로 따로 잡았기때문에 다른 주소를 참조함.
			System.out.println("str1과 str2는 동일한 주소를 참조하고 있습니다.");
		} else {
			System.out.println("다른 주소를 참조하고 있습니다.");
		}
		
		if(str3.equals(str4)) {
			System.out.println("str3과 str4는 동일한 문자열입니다.");
		} else {
			System.out.println("다른 문자열입니다.");
		}
	}

}
