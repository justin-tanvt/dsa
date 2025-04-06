import java.util.LinkedList;

class ListNode {
	int value;
	ListNode next;

	public ListNode(int init) {
		this.value = init;
	}

	public ListNode(int init, ListNode next) {
		this.value = init;
		this.next = next;
	}
}

public class LearnLinkedList {
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<>();

		// Linked List as Stack
		// linkedList.push("A");
		// linkedList.push("B");
		// linkedList.push("C");
		// linkedList.push("D");
		// linkedList.push("F");
		// linkedList.pop();

		// Linked List as Queue
		linkedList.offer("A");
		linkedList.offer("B");
		linkedList.offer("C");
		linkedList.offer("D");
		linkedList.offer("F");
		// linkedList.poll();
		linkedList.add(4, "E");
		linkedList.remove("E");

		System.out.println(linkedList.peekFirst());
		System.out.println(linkedList.peekLast());
		linkedList.addFirst("0");
		linkedList.addLast("G");
		String first = linkedList.removeFirst();
		String last = linkedList.removeLast();

		System.out.println(linkedList);
	}
}