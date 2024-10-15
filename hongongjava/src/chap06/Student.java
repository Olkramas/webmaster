package chap06;

import java.util.Scanner;

public class Student {
	//필드
	String name;
	int korean;
	int english;
	int math;
	
	
	//생성자
	Student() {
		
	}
	
	Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	//메소드
	//총점, 평균, 등급을 모두 한번에 출력하는 메소드 생성
	void getinfo() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("학생이름을 입력하세요.");
		String stuname = scanner.nextLine();
		System.out.println("국어 점수를 입력하시오.");
		int koreanScore = Integer.parseInt(scanner.nextLine());
		System.out.println("영어 점수를 입력하시오.");
		int englishScore = Integer.parseInt(scanner.nextLine());
		System.out.println("수학 점수를 입력하시오.");
		int mathScore = Integer.parseInt(scanner.nextLine());
		
		this.name = stuname;
		this.korean = koreanScore;
		this.english = englishScore;
		this.math = mathScore;
		
		show();
	}
	void show() {
//		System.out.println("이름: " + this.name + "\t총점: " + getSum() + "\t평균: " + getAvg() + "\t등급: " + getGrade());
		System.out.printf("이름: %S 국어: %d 영어: %d 수학: %d \t총점: %d \t평균: %.1f\t등급: %S \n\n"
				, this.name, this.korean, this.english, this.math, getSum(), getAvg(), getGrade());
	}
	
	int getSum() {
		int sum  = this.korean + this.english + this.math;
		return sum;
	}
	
	double getAvg() {
		double avg = getSum() / 3.0;
		return avg;
	}
	
	String getGrade() {
		String gradeVal = null;
		int grade = (int) (getAvg() / 10);
		
		//gradeVal말고 "A"이런식으로 리턴하면 나중에 무슨값인지 구별이 안될 수 있음. 알수있게 사용하는게 좋음.
		switch(grade) {
		case 10:
		case 9: gradeVal = "A"; break;
		case 8: gradeVal = "B"; break;
		case 7: gradeVal = "C"; break;
		case 6: gradeVal = "D"; break;
		case 5: gradeVal = "E"; break;
		default : gradeVal = "F";
		}
		return gradeVal;
		
	}

}

