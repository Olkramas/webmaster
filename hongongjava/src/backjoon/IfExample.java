package backjoon;

import java.util.Arrays;

public class IfExample {

	public static void main(String[] args) {
		//7 주사위 세번 던지기 https://www.acmicpc.net/problem/2480
		
		//1) 주사위 세번 던지는 for문 만들기 이걸 배열에 저장
		
		//배열 선언
		int[] resultNum = new int[3];
		
		//중복되는 값이 나올때(if) 중복되는 값이 몇개인지에 따라 달라질 숫자를 저장할 변수 선언
		int judge = 0;
		
		//랜덤 수 생성, 저장하는 for문
		for(int i=0; i<3; i++) {
			int random = (int) (Math.random() * 6) + 1;
			resultNum[i] = random;
		}
		
		//2) for문으로 배열을 한번씩 다 돌리고 if문을 만들어서 조건을 만족할 때마다 cnt가 올라감.
		//2-2) 같은눈 구별, 두개로 나뉨. 눈 세개가 같은경우, 두개가 같은경우. 세개는 셋 다 ==으로 구별 가능.
		//2-3) 이중 for문을 돌려서 index[n] - index[n] 이 경우 빼고, index[0] - index[1, 2, 3]
		//2-4) 배열 하나씩 돌리면서 max보다 큰 배열 값을 저장. 그중 가장 큰 눈 구별
		//3) cnt개수에 따라서 switch로 각각의 상황을 만듦.
		//4) 계산해서 출력
		
		
		//확인을 위한 배열 출력
		System.out.println(Arrays.toString(resultNum));
		
	}

}
