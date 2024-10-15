package practice.chap02_06HomePractice;

public class RangeOflocalVariable {

	public static void main(String[] args) {
		//혼공자 80p exam4
		int v1 = 0;
		if(true) {
			int v2 = 0;
			if(true) {
				int v3 = 3;
				v1 = 1;
				v2 = 1;
				v3 = 1;
			}
			//v1 = v2 + v3; v3가 바로 위 if문 안의 로컬 변수였는데, if문을 벗어나게 돼서 
			//외부에서는 사용할 수 없게 됐음. 그래서 컴파일 에러
		}
	}

}
