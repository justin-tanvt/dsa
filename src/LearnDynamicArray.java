import java.util.ArrayList;

class DynamicArray {
	int size;
	int capacity = 10;
	Object[] array;

	public DynamicArray() {
		this.array = new Object[this.capacity];
	}

	public DynamicArray(int capacity) {
		this.capacity = capacity;
		this.array = new Object[this.capacity];
	}
}

public class LearnDynamicArray {

	public static void main(String[] args) {
		// Java ArrayList
		// ArrayList<String> array = new ArrayList<>();

		// own DynamicArray
		DynamicArray da = new DynamicArray();
		System.out.println(da.capacity);
	}
	
}