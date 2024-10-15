package memo;

public class NotRepetitionRandomNumInArray {

	public static void main(String[] args) {
		
		int[] array = new int[10];
		//교수님이 작성하신 코드
		
		
		for(int i=0; i<array.length; i++) {
			int cnt = 0;
			int rNum = (int) (Math.random() * 10) + 1;
			for(int j=0; j<=i; j++) {
				if(array[j] == rNum) {
					cnt++;
				}
			}
			if(cnt == 0) {
				array[i] = rNum;
			} else {
				i--;
			}
			
		}
		
		
		//내가 하던거
//		for(int i=0; i<=array.length; i++) {
//			int random = (int) (Math.random() * 10) + 1;
//			int num1 = i-1;
//			for(int j=1; j<=array.length; j++) {
//				int num2 = j - 1;
//				if(random != array[num2]) {
//					i--;
//					array[num2] = random;
//				} else {
//					i--;
//				}
//			}
//		}
		System.out.print("array 배열 = {");
		for(int i=0; i<array.length; i++) {
			if(i+1 != array.length) {
				System.out.print(array[i]);
				System.out.print(", ");
			} else {
				System.out.print(array[i]);
			}
		}
		System.out.print("}");
	}

}
