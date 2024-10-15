package chap13.hashMap20241002;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class practice02 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
				
		map.put("최태백1", 100);
		map.put("최태백2", 90);
		map.put("최태백3", 20);
		map.put("최태백4", 300);
		
		//키값으로 출력하기
		Set<String> keyset = map.keySet();
		Iterator<String> keyIr = keyset.iterator();
		while(keyIr.hasNext()) {
			String key = keyIr.next();
			Integer val = map.get(key);
			System.out.println(key + " : " + val);
		}
		System.out.println("------------------------");
		
		
		//향상된 for문으로 출력하기
		Set<Map.Entry<String, Integer>> setEntryfor = map.entrySet();
		for(Map.Entry<String, Integer> ele : setEntryfor) {
			System.out.println(ele.getKey() + " : " + ele.getValue());
		}
		
		System.out.println("-------------------------"); 
		
		//엔트리로 출력하기
		Set<Map.Entry<String, Integer>> setEntry = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIr = setEntry.iterator();
		while(entryIr.hasNext()) {
			Map.Entry<String, Integer> entry = entryIr.next();
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + " : " + val);
		}
		
		//키값으로 출력하기
		System.out.println(map.get("최태백1"));
	}

}
