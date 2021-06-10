package com.anirban.Stack;

import java.util.Stack;

public class EvaluationPostFixExpression {

  public static void main(String[] args) {
    String S = "231*+9-";
    System.out.println(evaluatePostFix(S));
   /* for (int i = 0; i < S.length(); i++) {
      System.out.println(S.charAt(i));
    }*/
    //char operator = S.charAt(i);
  }

  public static int evaluatePostFix(String S) {
    int result = 0;
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < S.length(); i++) {
      if (isOperator(S.charAt(i)) && s.size() > 0) {
        // char operator = S.charAt(i);
        int first = s.peek();
        s.pop();
        int second = s.peek();
        s.pop();
        switch (S.charAt(i)) {
          case '+':
            result = first + second;
            break;
          case '-':
            result = second - first;
            break;
          case '/':
            result = first / second;
            break;
          case '*':
            result = first * second;
            break;
        }
        s.push(result);
      } else {
        s.push(Integer.parseInt(String.valueOf(S.charAt(i))));

      }
    }
    return s.pop();
  }

  private static boolean isOperator(char ch) {
    return (ch == '*' || ch == '+' || ch == '-' || ch == '/');
    //return true
  }
}
