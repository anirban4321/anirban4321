package DS_Uni.Amazon_Interview_Prep.src.com.anirban.Stack;

import java.util.Stack;

class Pair {

  int element;

  int index;

  Pair(int element, int index) {
    this.element = element;
    this.index = index;
  }
}


/*Complete the function given below*/
public class MaxRectangle {

  public static void main(String[] args) {
    int M[][] = {
        { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
    int m = 4;
    int n = 4;
    System.out.println(maxArea(M, m, n));
  }

  private static int MaxAreaUtil(int[] result) {
    int[] right = NSR(result);
    int[] left = NSL(result);
    int[] width = new int[result.length];
    int[] area = new int[result.length];
    for (int i = 0; i < result.length; i++) {
      width[i] = right[i] - left[i] - 1;
    }
    for (int i = 0; i < result.length; i++)
      area[i] = width[i] * result[i];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < area.length; i++)
      max = Math.max(max, area[i]);
    return max;
  }

  private static int[] NSR(int[] result) {
    int len = result.length;
    int[] ans = new int[len];
    Stack<Pair> s = new Stack<>();
    for (int i = len - 1; i >= 0; i--) {
      if (s.isEmpty())
        ans[i] = len;
      if (s.size() > 0 && s.peek().element <= result[i])
        ans[i] = s.peek().index;
      if (s.size() > 0 && s.peek().element >= result[i]) {
        while (s.size() > 0 && s.peek().element >= result[i]) {
          s.pop();
        }
        if (s.size() == 0)
          ans[i] = len;
        else
          ans[i] = s.peek().index;
      }
      s.push(new Pair(result[i], i));
    }
    return ans;
  }

  private static int[] NSL(int[] result) {
    int len = result.length;
    int[] ans = new int[len];
    Stack<Pair> s = new Stack<>();
    for (int i = 0; i < len; i++) {
      if (s.isEmpty())
        ans[i] = -1;
      if (s.size() > 0 && s.peek().element <= result[i])
        ans[i] = s.peek().index;
      if (s.size() > 0 && s.peek().element >= result[i]) {
        while (s.size() > 0 && s.peek().element >= result[i]) {
          s.pop();
        }
        if (s.size() == 0)
          ans[i] = -1;
        else
          ans[i] = s.peek().index;
      }
      s.push(new Pair(result[i], i));
    }
    return ans;
  }

  public static int maxArea(int M[][], int m, int n) {
    int[] result = new int[n];
    for (int i = 0; i < n; i++)
      result[i] = M[0][i];
    int max = MaxAreaUtil(result);
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (M[i][j] == 0)
          result[j] = 0;
        else
          result[j] = result[j] + M[i][j];
      }
      max = Math.max(max, MaxAreaUtil(result));
    }
    return max;
  }
}