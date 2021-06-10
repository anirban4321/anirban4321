package com.anirban;

// { Driver Code Starts
//Initial Template for Java

import java.util.ArrayList;
import java.util.List;

class WordBoggle {

  public static void main(String args[]) {
    /*Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int N = sc.nextInt();
      String[] dictionary = new String[N];
      for (int i = 0; i < N; i++) {
        dictionary[i] = sc.next();
      }

      int R = Integer.parseInt(sc.next());
      int C = Integer.parseInt(sc.next());

      char board[][] = new char[R][C];
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          board[i][j] = sc.next().charAt(0);
        }
      }*/
    String[] dictionary = { "GEEKS", "FOR", "QUIZ", "GO" };
    char[][] board = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };

    Solution obj = new Solution();
    System.out.println(obj.wordBoggle(board, dictionary));

   /* if (ans.length == 0)
      System.out.println("-1");
    else {
      Arrays.sort(ans);
      for (int i = 0; i < ans.length; i++) {
        System.out.print(ans[i] + " ");
      }
      System.out.println();
    }*/

    // t--;
  }
}
//}
// } Driver Code Ends

//User function Template for Java


class Solution {

  private static void dfs(char[][] board, int i, int j, int rows, int cols, List<String> ans, TrieNode root) {

    if (i < 0 || j < 0 || i >= rows || j >= cols)
      return;
    int index = board[i][j] - 'A';

    if (board[i][j] == '$' || root.dictionaryWords[index] == null)
      return;
    root = root.dictionaryWords[index];
    if (root.ends > 0) {
      ans.add(root.word);
      root.ends -= 1;
    }

    char ch = board[i][j];
    board[i][j] = '$';
    dfs(board, i - 1, j, rows, cols, ans, root);
    dfs(board, i, j - 1, rows, cols, ans, root);
    dfs(board, i + 1, j, rows, cols, ans, root);
    dfs(board, i, j + 1, rows, cols, ans, root);
    dfs(board, i - 1, j - 1, rows, cols, ans, root);
    dfs(board, i + 1, j + 1, rows, cols, ans, root);
    board[i][j] = ch;
  }

  private static void insert(String word, TrieNode root) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int index = ch - 'A';
      if (current.dictionaryWords[index] == null) {
        current.dictionaryWords[index] = new TrieNode(ch);
      }
      current = current.dictionaryWords[index];
    }
    current.ends += 1;
    current.word = word;
  }

  public List<String> wordBoggle(char[][] board, String[] words) {

    TrieNode root = new TrieNode('/');

    int rows = board.length;
    int cols = board[0].length;

    int len = words.length;
    for (int i = 0; i < len; i++) {
      insert(words[i], root);
    }

    List<String> ans = new ArrayList<>();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        dfs(board, i, j, rows, cols, ans, root);
      }
    }
    return ans;
  }

  static class TrieNode {

    TrieNode dictionaryWords[];

    int ends;

    char c;

    String word;

    TrieNode(char c) {
      dictionaryWords = new TrieNode[26];
      for (int i = 0; i < 26; i++)
        dictionaryWords[i] = null;
      ends = 0;
      word = "";
      this.c = c;
    }
  }
}
