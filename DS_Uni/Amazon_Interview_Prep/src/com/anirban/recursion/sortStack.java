package DS_Uni.Amazon_Interview_Prep.src.com.anirban.recursion;

import java.util.Stack;

public class sortStack {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(3);
    stack.push(2);
    stack.push(5);//7 1 5 2 3
    stack.push(1);
    stack.push(7);
    Stack<Integer> a = sort(stack);
    while (!a.empty()) {
      System.out.print(a.peek() + " ");
      a.pop();
    }
  }

  private static Stack<Integer> insert(Stack<Integer> s, int element) {
    if (s.size() == 0 || s.peek() <= element) {
      s.push(element);
      return s;
    }
    int temp = s.peek();
    s.pop();
    insert(s, element);
    s.push(temp);
    return s;
  }

  public static Stack<Integer> sort(Stack<Integer> s) {
    if (s.size() == 1)
      return s;
    int temp = s.peek();
    s.pop();
    sort(s);
    insert(s, temp);
    return s;
  }

}
