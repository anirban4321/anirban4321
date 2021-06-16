package DS_Uni.Amazon_Interview_Prep.src.com.anirban.recursion;

import java.util.ArrayList;

public class JosephusCircle {

  public static void main(String[] args) {
    int N = 40;
    int index = 0;
    int k = 7;
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
      list.add(i);
    }
    k--;
    int ans = josephus(list, k, index);
    System.out.println(ans);
  }

  private static int josephus(ArrayList<Integer> list, int k, int index) {
    if (list.size() == 1)
      return list.get(0);
    index = (index + k) % list.size();
    list.remove(index);
    return josephus(list, k, index);
  }

}
