package memo;

public class ArrayMemo {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int arr2[] = {1,2,3,4,5};
		
		int[] arr3;
		arr3 = new int[] {1,2,3,4,5};
		
		//합을 저장할 변수선언.
		int sum = 0;
		//총 합구하기
		for(int i=0; i<arr3.length; i++) {
			sum += arr3[i];
		}
		//평균구하기
		double avg = (double) sum / arr3.length;
		//출력하기
		System.out.printf("총합 : %d, 평균 : %.2f", sum, avg);
		
		System.out.println();
		
		int[] arr4;
		arr4 = new int[3];
		System.out.println(arr4.length);
		
		String[] arr5;
		arr5 = new String[5];
		System.out.println(arr5.length);
		
		
	}

}
