package chap06;

//import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
//		학생 객체 생성 class
//		필드 : 학번 이름 국어 영어 수학 => 객체생성
//		생성자 : 필드 초기화
//		메소드 : 총점 평균 등급
//
//		실행 클래스
//		학생 : 이름, 국어, 영어, 수학, 총점, 평균, 등급 출력
//
//		학생은 5명
		
		//값을 입력받아서 할 수 있을까?
		//우선 아무 의미없는 객체를 하나 만들어서 Student클래스의 메소드를 사용할 수 있게 만듦.
		//get 국어, 영어, 수학을 다 하나씩 만들어서 menu라고 메소드를 만듦. 그리고 menu안에 모두 집어넣기
		//그리고 받은 값들은 필드에 저장할 수 있게 하기
		//메뉴에서 정보들을 다 받음과 동시에 show()메소드를 호출해서 모두 출력할 수 있게 만들기
		
		
		//동일한 형태(Student)의 정보가 반복되고 있음. 그래서 배열에 넣어서 for문으로 출력
		Student[] stuArr = {
				new Student("최태백1", 90, 91, 90),
				new Student("최태백2", 80, 81, 80),
				new Student("최태백3", 70, 71, 70),
				new Student("최태백4", 60, 61, 60),
				new Student("최태백5", 50, 51, 50)
		};

		for(int i=0; i<stuArr.length; i++) {
			stuArr[i].show();
		}
		
		
		
		
//		Student stu1 = new Student();
//		stu1.getinfo();
//		
	}

}
