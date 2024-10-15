package chap13;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain241002 {

	public static void main(String[] args) {
		//list컬렉션 
		//ArrayList 
		
		//String 객체를 저장하는 ArrayList P582
		
		//리스트 인터페이스의 구현 객체 ArrayList를 받았음
		List<String> list = new ArrayList<String>();
		
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");
		
		//저장된 객체의 수
		int size =list.size();
		System.out.println("총 객체의 수: " + size); 
		System.out.println();
		
		//2번 인덱스의 객체 얻기
		String skill = list.get(2);
		System.out.println("2: " + skill);
		System.out.println();
		
		//저장된 객체의 수만큼 for문
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": " + str);
		}
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": " + str);
		}
		System.out.println();
		
		//향상된 for문을 활용한 출력
		for(String obj : list) {
			System.out.println(obj);
		}
	}

}
