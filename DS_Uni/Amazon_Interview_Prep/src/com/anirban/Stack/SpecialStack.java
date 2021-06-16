package DS_Uni.Amazon_Interview_Prep.src.com.anirban.Stack;

import java.util.Scanner;
import java.util.Stack;

class SpeStack {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      Stack<Integer> s = new Stack<>();
      Solution g = new Solution();
      while (!g.isEmpty(s)) {
        g.pop(s);
      }
      while (!g.isFull(s, n)) {
        g.push(sc.nextInt(), s);
      }
      System.out.println(g.min(s));
    }
  }
}// } Driver Code Ends


/*Complete the function(s) below*/
class Solution {

  int minEle;

  private int top(Stack<Integer> s) {
    if (s.size() == 0)
      return -1;
    else if (s.peek() < minEle)
      return minEle;
    else
      return s.peek();
  }

  public void push(int a, Stack<Integer> s) {
    if (s.size() == 0) {
      s.push(a);
      minEle = a;
    } else {
      if (a >= minEle)
        s.push(a);
      else {
        s.push(2 * a - minEle);
        minEle = a;
      }

    }
  }

  public int pop(Stack<Integer> s) {
    if (s.size() == 0)
      return -1;
    else {
      if (s.peek() < minEle) {
        int temp = minEle;
        minEle = 2 * minEle - s.peek();
        s.pop();
        return temp;
      } else
        return s.pop();

    }
  }

  public int min(Stack<Integer> s) {
    if (s.size() == 0)
      return -1;
    return minEle;
  }

  public boolean isFull(Stack<Integer> s, int n) {
    if (s.size() == n)
      return true;
    return false;
  }

  public boolean isEmpty(Stack<Integer> s) {
    if (s.size() == 0)
      return true;
    return false;
  }
}
