package memo;

public class IsThisWorking {

	public static void main(String[] args) {
		//6
		
		//2차원 배열 선언
		int[][] ranPlace = new int[3][5];
		int check = 0;
		
		//5번 반복할 for문 (1을 넣기위한 반복)
		for(int i=0; i<5; i++) {
			
			//난수를 생성해서 두 수를 인덱스 번호로 사용. 무작위로 1을 넣을 수 있음.
			int rowRan = (int) (Math.random() * 3);
			int colRan = (int) (Math.random() * 5);
			//랜덤으로 생성한 2차원 배열의 인덱스 번호에 1이 아니고, check가 0,1,2,3,4일 때만 실행하는 if문.  
			if(ranPlace[rowRan][colRan] != 1 && check < 5) {				
				check++;		//check는 1이 배열에 저장되는게 얼마나 저장되는지 알기위해서 ++를 했음
				ranPlace[rowRan][colRan] = 1;	//위 조건이 만족했을 때 배열에 1추가
				i--;			
			}
			//낮은 확률로 같은 배열번호가 생성되면 1이 덜 찍히기 때문에 어떤 배열번호가 생성됐는지 확인하기 위한 프린트문 (아래)
			System.out.print(rowRan + " " + colRan + "\t");
		}
		System.out.println();
		
		//출력을 위한 for문
		for(int i=0; i<ranPlace.length; i++) {
			for(int j=0; j<ranPlace[i].length; j++) {
				System.out.print(ranPlace[i][j] + "\t");
			}
			System.out.println();
		}
		//총 몇번 1이 입력됐는지 확인할 수 있는 출력문(아래)
		System.out.println("check: " + check);

	}

}
