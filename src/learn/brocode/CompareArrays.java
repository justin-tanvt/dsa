package learn.brocode;

import java.util.ArrayList;
import java.util.LinkedList;

public class CompareArrays {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		long startTime;
		long endTime;
		long elapsedTime;

		for (int i = 0; i < 1000000; i++) {
			linkedList.add(i);
			arrayList.add(i);
		}

		// ********** LinkedList **********
		startTime = System.nanoTime();
		// ***** get()
		// linkedList.get(0);				// fast but slower than arraylist
		// linkedList.get(500000); 	// very slow, much slower than arraylist
		// linkedList.get(999999);	// fast but slower than arraylist
		// ***** remove()
		// linkedList.remove(0);				// fast
		// linkedList.remove(500000);		// super slow, 10x slower than arrayList.remove(0)
		// linkedList.remove(999999);		// fast, but still slower than arraylist
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("LinkedList:\t" + elapsedTime + " ns");

		//********** ArrayList **********
		startTime = System.nanoTime();
		// ***** get()
		// arrayList.get(0);				// equally fast among arraylist
		// arrayList.get(500000);		// equally fast among arraylist
		// arrayList.get(999999);		// equally fast among arraylist
		// ***** remove()
		// arrayList.remove(0);					// very slow
		// arrayList.remove(500000);		// not as slow, 10x slower than linkedList.remove(0)
		// arrayList.remove(999999);		// super fast
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("ArrayList:\t" + elapsedTime + " ns");
	}
}