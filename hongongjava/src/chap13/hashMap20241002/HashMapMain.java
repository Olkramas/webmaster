package chap13.hashMap20241002;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapMain {

	public static void main(String[] args) {
		//map : 키와 값으로 구성된 entry 저장
		//key: String val: int 뒤 꺽쇠에는 안써도 
		Map<String, Integer> map = new HashMap<>();
		
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		
		//map 크기
		System.out.println("map 크기 " +map.size());
		
		//객체 찾기
		System.out.println("\t홍길동: " + map.get("홍길동"));
		System.out.println();
		
		//객체를 하나씩 처리
//		Set<String> keySet = map.keySet();
//		Iterator<String> keyIterator = keySet.iterator();
//		while(keyIterator.hasNext()) {
//			String key = keyIterator.next();
//			Integer value = map.get(key);
//			System.out.println("\t" + key + ": " + value); 
//		}
//		System.out.println();
		System.out.println("-------------------");
		Set<String>	keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer val = map.get(key);
			System.out.println(key + " : " + val);
		}
		System.out.println("-------------------");
		
		
//		Set<Map.Entry<String, Integer>> entrySet1 = map.entrySet();
//		Iterator<Map.Entry<String, Integer>> entryIterator1 = entrySet1.iterator();
//		while(entryIterator1.hasNext()) {
//			Map.Entry<String, Integer> entry = entryIterator1.next();
//			String key = entry.getKey();
//			Integer val = entry.getValue();
//			System.out.println("key: " + key + "val: " + val);
//			
//			
//		}
//		
//		for(Entry<String, Integer> ele : entrySet1) {
//			System.out.println("key: " + ele.getKey() + "val: " + ele.getValue());
//		}
		
		
		
		
		//객체삭제
		map.remove("홍길동");
		System.out.println("총 Entry 수: " + map.size());
		
		//객체를 하나씩 처리
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		
		//이터레이터 사용 안하고 for문으로만 사용
		for(Map.Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		map.clear();
		System.out.println("총 Entry 수: " + map.size());
	}

}
