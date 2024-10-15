package memo;

public class StringExample {

	public static void main(String[] args) {
		String str1 = new String("최태백");
		String str2 = new String("최태백");
		
		if(str1 == str2) {
			System.out.println("같은 주소를 참조하고 있습니다.");
		} else {
			System.out.println("다른 주소를 참조하고 있습니다.");
		}
		
		String st3 = "ccc";
		String st4 = "ccc";
		
		if(st3 == st4) {
			System.out.println(st3);
		}
	}

}
