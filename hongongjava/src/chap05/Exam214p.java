package chap05;

public class Exam214p {

	public static void main(String[] args) {
		//2차원 
		int[][] scores = {
				{10,20,30},
				{40,50,60}
		};
		
		for(int i=0; i<scores.length; i++) {
			for(int j=0; j<scores[i].length; j++) {
				System.out.print(scores[i][j] + " ");	
			}
			System.out.println();
		}
		System.out.println(scores[0][2]);
		System.out.println("-------------------------------------------------");
		//향상된 for문 사용하기
		
		for(int i=0; i<scores.length; i++) {
			for(int j : scores[i]) {
				System.out.print(j + " ");	
			}
			System.out.println();
		}
		System.out.println(scores[0][2]);
		
		
		//2*3배열을 선언하고
		//1부터 10까지 무작위 수를 입력하세요.
		//같은 수 입력가능
		
		int[][] nums = new int[2][3];
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				int random = (int) (Math.random() * 10) + 1;
				nums[i][j] = random;
			}
		}
		
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				System.out.print(nums[i][j] + "\t");	
			}
			System.out.println();
		}
	
		//향상된 for문 사용하기
		//합, 최대/최소값을 구하기
		int[] su = {10, 200, 30, 40, -50, 777, 555};
		int sum = 0;
		int max = Integer.MIN_VALUE;	//int 값 중에 최소값
		int min = Integer.MAX_VALUE;	//int 값 중에 최댓값
//		int max = 0;
//		int min = 999999999;
		//ele: 배열의 값을 하나씩 가져옴
		for(int ele : su) {
			sum += ele;
			if(max < ele) max = ele;
			if(min > ele) min = ele;
		}
		System.out.println("향상된 for문을 사용하여 구한 배열의 합: " + sum);
		System.out.println("max = " + max + "\tmin = " + min);
		int cnt = 0;
		System.out.println(scores[0]);
		for(int[] row : scores) {
			for(int j: row) {
				cnt++;
				System.out.print( row + " " + j + " ");
			}
			System.out.println();
		}
		System.out.println("cnt: " + cnt);
	}

}
