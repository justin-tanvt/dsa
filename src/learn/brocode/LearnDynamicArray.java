package learn.brocode;

import java.util.ArrayList;

class DynamicArray {
	int size = 0;
	int capacity = 10;
	Object[] array;

	public DynamicArray() {
		this.array = new Object[this.capacity];
	}

	public DynamicArray(int capacity) {
		this.capacity = capacity;
		this.array = new Object[this.capacity];
	}

	public void add(Object data) {
		if (this.size >= this.capacity) {
			grow();
		}

		this.array[this.size] = data;
		this.size++;
	}

	public void insert(int index, Object data) {
		if (this.size >= this.capacity) {
			grow();
		}

		for (int i = this.size; i > index; i--) {
			this.array[i] = this.array[i - 1];
		}

		this.array[index] = data;
		this.size++;
	}

	public void delete(Object data) {
		for (int i = 0; i < this.size; i++) {
			// if element to-be-deleted found
			if (this.array[i] == data) {
				// for every subsequent element
				for (int j = i + 1; j < this.size; j++) {
					// shift left
					this.array[j - 1] = this.array[j];
				}
				// erase last element after shifted left
				this.array[size - 1] = null;
				this.size--;

				if (size <= (int) capacity / 3) {
					shrink();
				}

				break;
			}
		}
	}

	public int search(Object data) {
		for (int i = 0; i < this.size; i++) {
			if (this.array[i] == data) {
				return i;
			}
		}
		return -1;
	}

	private void grow() {
		int newCapacity = (int) (this.capacity * 2);
		Object[] newArray = new Object[newCapacity];

		for (int i = 0; i < this.size; i++) {
			newArray[i] = this.array[i];
		}

		this.capacity = newCapacity;
		this.array = newArray;
	}

	private void shrink() {
		int newCapacity = (int) (this.capacity / 2);
		Object[] newArray = new Object[newCapacity];

		for (int i = 0; i < this.size; i++) {
			newArray[i] = this.array[i];
		}

		this.capacity = newCapacity;
		this.array = newArray;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public String toString() {
		String str = "";

		for (int i = 0; i < this.size; i++) {
			str += array[i] + ", ";
		}
		if (str != "") {
			str = "[" + str.substring(0, str.length() - 2) + "]";
		} else {
			str = "[]";
		}

		return str;
	}
}

public class LearnDynamicArray {

	public static void main(String[] args) {
		// Java ArrayList
		// ArrayList<String> array = new ArrayList<>();

		// own DynamicArray
		DynamicArray da = new DynamicArray(5);
		da.add("A");
		da.add("B");
		da.add("C");
		da.add("D");
		da.add("E");
		da.add("F");

		da.delete("A");
		da.delete("B");
		da.delete("C");

		//insert, update, delete
		/*
		da.insert(0, "X");
		da.delete("A");
		System.out.println(da.search("C"));
		*/		

		System.out.println(da);
		System.out.println("size: " + da.size);
		System.out.println("capacity: " + da.capacity);
		System.out.println("empty: " + da.isEmpty());
	}
	
}