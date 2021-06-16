package DS_Uni.Amazon_Interview_Prep.src.com.anirban.recursion;

import java.util.Stack;

public class ReverseStack {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(3);
    stack.push(2);
    stack.push(5);
    stack.push(1);
    stack.push(7);

    Stack<Integer> a = reverse(stack);
    while (!a.empty()) {
      System.out.print(a.peek() + " ");
      a.pop();
    }
  }

  private static Stack<Integer> reverse(Stack<Integer> stack) {
    if (stack.size() == 1)
      return stack;
    int temp = stack.peek();
    stack.pop();
    reverse(stack);
    insert(stack, temp);
    return stack;
  }

  private static void insert(Stack<Integer> stack, int temp) {
    if (stack.size() == 0) {
      stack.push(temp);
      return;
    }
    int val = stack.peek();
    stack.pop();
    insert(stack, temp);
    stack.push(val);
  }

}
