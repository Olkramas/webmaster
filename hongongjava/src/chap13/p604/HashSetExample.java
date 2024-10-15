package chap13.p604;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashSetExample {
	static Set<Student> set = new HashSet<Student>();

	public static void main(String[] args) {
		
//		set.add(new Student(1, "홍길동"));
//		set.add(new Student(2, "신용권"));
//		set.add(new Student(1, "조민우"));
//		
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			System.out.println("학번을 입력하세요");
			int stuNum = Integer.parseInt(scanner.nextLine());
			if(noRe(stuNum) == true) {
				System.out.println("이미 존재하는 학번입니다.");
				System.out.println("프로그램을 다시 시작하세요.");
				break;
			}
			System.out.println("이름을 입력하세요");
			String stuName = scanner.nextLine();
			
			set.add(new Student(stuNum, stuName));
			
		}
		
		Iterator<Student> iterator = set.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.studentNum + ":" + student.name);
		}
		
	}
	static boolean noRe(int stuNum) {
		for(Student ele : set) {
			if(ele.studentNum == stuNum) {
				return true;
			}
		}
		return false;
	}

}
