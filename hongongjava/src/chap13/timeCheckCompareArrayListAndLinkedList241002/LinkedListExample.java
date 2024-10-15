package chap13.timeCheckCompareArrayListAndLinkedList241002;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {
		//프로그램 실행시간 체크
		
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList 소요시간: " + (endTime - startTime));
		
		
		//시간이 덜 걸림. 추가 삽입이 많이 일어나는경우 linkedList를 사용하는게 더 좋다.
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 소요시간: "+ (endTime - startTime));
				
//		System.out.println("list2[0]" + list2.get(0));
		
	}

}
