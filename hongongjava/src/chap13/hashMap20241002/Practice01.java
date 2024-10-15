package chap13.hashMap20241002;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Practice01 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("최태백1", 100);
		map.put("최태백2", 90);
		map.put("최태백3", 20);
		map.put("최태백4", 300);
		
		//키 값만 가지고와서 출력하기
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			Integer val = map.get(key);
			System.out.println(key + " : " + val);
		}
		
		map.remove("최태백1");
		System.out.println("--------------------------------------------");
		
		//향상된 for문으로 hashMap출력하기
		Set<Map.Entry<String, Integer>> entryKeySet = map.entrySet();
		for(Map.Entry<String, Integer> ele : entryKeySet) {
			System.out.println(ele.getKey() + " : " + ele.getValue());
		}
		
		System.out.println("--------------------------------------------");
		//엔트리로 키, 값 따로따로 처리하기
		Set<Map.Entry<String, Integer>>	setKey = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = setKey.iterator();
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + " : " + val);
		}
	}

}
