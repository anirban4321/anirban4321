package com.anirban.leetcode.MayChallenge;

import java.util.HashMap;

public class FIrstUniqueCharacter {

  public static void main(String[] args) {
    String s = "leetcode";
    System.out.println(firstUniqChar(s));
  }

  public static int firstUniqChar(String s) {
    int length = s.length();
    int index = -1;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < length; i++) {
      Character ch = s.charAt(i);
      if (map.containsKey(ch)) {
        int val = map.get(ch);
        map.put(ch, val + 1);
      } else {
        map.put(ch, 1);
      }
    }

    for (int i = 0; i < length; i++) {
      Character ch = s.charAt(i);
      if (map.get(ch) == 1) {
        index = i;
        break;
      } else {
        index = -1;
      }
    }

    // for(Map.Entry entry : map.entrySet()){
    //     if(entry.getValue().equals(1))
    //         index = s.indexOf(entry.getKey());
    // }
    return index;
  }
}
