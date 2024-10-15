package chap13.Member20241002;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MemberMain {

	public static void main(String[] args) {
		
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 35));
		set.add(new Member("동길동", 30));
		
		System.out.println("총 객체 수: " + set.size());
		
		//hashset출력
		Iterator<Member> iterator = set.iterator(); 
		while(iterator.hasNext()) {
			Member element = iterator.next();
			System.out.println("이름: " + element.name + "\t나이: " + element.age);
		}
		
		
		
//		iterator = set.iterator();
//		while(iterator.hasNext()) {
//			Member element = iterator.next();
//			iterator.remove();
//		}
		
		System.out.println(set.size());
		
		System.out.println();
		iterator = set.iterator();
		for(Member element : set) {
			System.out.println("이름: " + element.name + "\t나이: " + element.age);
		}
		
		
	}

}
