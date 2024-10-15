package memo;

public class EqualsMemo {

	public static void main(String[] args) {
		String str1 = new String();
		String str2 = new String();
		
		
		if(str1 == str2) {
			System.out.println("같다");
		} else {
			System.out.println("같지않다");
		}
		
		if(str1.equals(str2)) {
			System.out.println("같다");
		} else {
			System.out.println("같지않다");
		}
		
		String str3 = "최태백";
		String str4 = "최태백";
		if(str3 == str4) {
			System.out.println("같다");
		} else {
			System.out.println("같지않다");
		}
		
	}

}
