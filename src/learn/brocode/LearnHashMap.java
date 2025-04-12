package learn.brocode;

import java.util.HashMap;

public class LearnHashMap {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>(10);	

		map.put(100, "Spongebob");
  	map.put(123, "Patrick");
  	map.put(321, "Sandy");
  	map.put(555, "Squidward");
  	map.put(777, "Gary");

  	for (Integer key : map.keySet()) {
  		System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + map.get(key));
  	}
	}
}