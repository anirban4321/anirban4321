package com.anirban.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurenceOfAnagrams {

  public static void main(String[] args) {
    /*String text = "forxxorfxdofr";
    String word = "for";*/
    String text = "aabaabababaa";
    String word = "aaba";
    System.out.print(countAnagrams(text, word));
  }

  private static int countAnagrams(String text, String word) {
    int ans = 0;
    int count = 0;
    int i = 0;
    int j = 0;
    int k = word.length();
    Map<Character, Integer> hm = new HashMap<Character, Integer>();
    for (int start = 0; start < word.length(); start++) {
      char ch = word.charAt(start);
      if (!hm.containsKey(word.charAt(start)))
        hm.put(ch, 1);
      else
        hm.put(ch, hm.get(ch) + 1);
    }
    count = hm.size();
    while (j < text.length()) {
      if (hm.containsKey(text.charAt(j))) {
        hm.put(text.charAt(j), hm.get(text.charAt(j)) - 1);
        if (hm.get(text.charAt(j)) == 0)
          count--;
      }
      if (j - i + 1 < k)
        j++;
      else if (j - i + 1 == k) {
        if (count == 0)
          ans++;

        if (hm.containsKey(text.charAt(i))) {
          hm.put(text.charAt(i), hm.get(text.charAt(i)) + 1);
          if (hm.get(text.charAt(i)) == 1)
            count++;
        }
        i++;
        j++;
      }

    }
    return ans;
  }

}
