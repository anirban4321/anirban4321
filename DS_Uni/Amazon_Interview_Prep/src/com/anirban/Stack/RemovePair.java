package com.anirban.Stack;

import java.util.Stack;

public class RemovePair {

  public static void main(String[] args) {
    String s = "aaabbaaccd";
    /*for (int i = 0; i < s.length(); i++)
      System.out.println(s.charAt(i));*/
    System.out.println(removePair(s));
  }

  public static String removePair(String str) {
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      // System.out.println(ch);
      if (s.size() == 0)
        s.push(ch);
      else if (ch == s.peek())
        s.pop();
      else
        s.push(ch);
    }
    String string = "";
    while (!s.isEmpty()) {
      string += s.pop();
    }
    return new StringBuffer(string).reverse().toString();
    /*StringBuffer string = new StringBuffer();
    int i = s.size();
    while (!s.isEmpty() && i >= 0) {
      string.setCharAt(i - 1, s.pop());
    }
    // System.out.println(string);
    return string.toString();*/
  }
}
