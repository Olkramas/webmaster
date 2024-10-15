package memo;

import java.util.Arrays;

public class TwoThreeDementionalArrPractice {

	public static void main(String[] args) {
		int[][] arr1 = new int[2][2];
		
		int[][][] arr2 = new int[][][]{
			{{1,2,3}, {1,2}, {1}, {2,3,4}},
			{{1}, {2}, {3}},
			{{1}, {2}, {3}, {4}, {3}}
		};
		
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				for(int b=0; b<arr2[i][j].length; b++) {
					System.out.print(arr2[i][j][b]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println(Arrays.toString(arr2));
	}

}
