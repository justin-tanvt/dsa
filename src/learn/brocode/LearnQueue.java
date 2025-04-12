package learn.brocode;

import java.util.LinkedList;
import java.util.Queue;

public class LearnQueue {
  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<>();
    queue.offer("Karen");
    queue.offer("Chad");
    queue.offer("Steve");
    queue.offer("Harold");
    System.out.println(queue);
    System.out.println(queue.peek());

    // remove 3 of the 4 customers
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue);

    // remove the final customer
    System.out.println(queue.poll());

    // attempt to remove a customer from an empty queue
    // both will return null without any execption
    System.out.println(queue.poll());
    System.out.println(queue.peek());

    // Collections class methods
    System.out.println(queue.isEmpty());
    System.out.println(queue.size());
    System.out.println(queue.contains("Chad"));

    /*
    * uses of queues:
    * 1. keyboard buffer (letters should appear on screen in the order they are pressed)
    * 2. printer queue (print jobs in order of submission)
    * 3. used in LinkedList, PriorityQueue, BFS
    */
  }
}
