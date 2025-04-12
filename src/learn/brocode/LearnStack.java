package learn.brocode;

import java.util.Stack;

public class LearnStack {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    stack.push("Minecraft");
    stack.push("Skyrim");
    stack.push("DOOM");
    stack.push("Borderlands");
    stack.push("FFVII");

    System.out.println(stack);
    System.out.println(stack.peek());
    System.out.println(stack.search("DOOMZ"));

    /*causes OutOfMemoryError
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      stack.push("Fallout76");
    }*/

    /*
    * uses of stacks:
    * 1. undo/redo
    * 2. browser history back/forward
    * 3. backtracking
    * 4. calling functions (add a FRAME to the CALL STACK)
    */
  }
}
