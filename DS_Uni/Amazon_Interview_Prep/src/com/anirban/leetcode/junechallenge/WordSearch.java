package com.anirban.leetcode.junechallenge;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {

  public static void main(String[] args) {
    /*char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };
    String word = "oath";
*/
    char[][] board = {
        { 'F', 'Y', 'C', 'E', 'N', 'R', 'D' },
        { 'K', 'L', 'N', 'F', 'I', 'N', 'U' },
        { 'A', 'A', 'A', 'R', 'A', 'H', 'R' },
        { 'N', 'D', 'K', 'L', 'P', 'N', 'E' },
        { 'A', 'L', 'A', 'N', 'S', 'A', 'P' },
        { 'O', 'O', 'G', 'O', 'T', 'P', 'N' },
        { 'H', 'P', 'O', 'L', 'A', 'N', 'O' } };
    String word = "poland";
    System.out.println(new WordSearch().exist(board, word));
  }

  private static void dfs(
      char[][] board, int i, int j, int rows, int cols, List<String> ans, TrieNode root) {
    if (i < 0 || j < 0 || i >= rows || j >= cols)
      return;
    boolean flag = false;
    int index;
    if (Character.isUpperCase(board[i][j]))
      index = board[i][j] - 'A';
    else
      index = board[i][j] - 'a';
    if (board[i][j] == '$' || root.dictionaryWords[index] == null)
      return;
    root = root.dictionaryWords[index];
    if (root.ends > 0) {
      ans.add(root.word);
      root.ends -= 1;
      flag = true;
      //return flag;
    }
    char ch = board[i][j];
    board[i][j] = '$';
    dfs(board, i - 1, j, rows, cols, ans, root);
    dfs(board, i, j - 1, rows, cols, ans, root);
    dfs(board, i + 1, j, rows, cols, ans, root);
    dfs(board, i, j + 1, rows, cols, ans, root);
    board[i][j] = ch;
  }

  private static void insert(String word, TrieNode root) {
    TrieNode current = root;
    int len = word.length();
    for (int i = 0; i < len; i++) {
      char ch = word.charAt(i);
      int index;
      if (Character.isUpperCase(ch))
        index = ch - 'A';
      else
        index = ch - 'a';
      if (current.dictionaryWords[index] == null) {
        current.dictionaryWords[index] = new TrieNode(ch);
      }
      current = current.dictionaryWords[index];
    }
    current.ends += 1;
    current.word = word;
  }

  public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;

    if (Character.isUpperCase(board[0][0]) && Character.isLowerCase(word.charAt(0)))
      return false;
    if (Character.isLowerCase(board[0][0]) && Character.isUpperCase(word.charAt(0)))
      return false;

    TrieNode root = new TrieNode('/');
    insert(word, root);
    boolean flag = true;
    List<String> ans = new ArrayList<>();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        dfs(board, i, j, rows, cols, ans, root);
      }
    }
    if (ans.size() != 0)
      return true;
    else
      return false;
  }

  static class TrieNode {

    char c;

    TrieNode[] dictionaryWords;

    int ends;

    String word;

    TrieNode(char c) {
      dictionaryWords = new TrieNode[52];
      for (int i = 0; i < 52; i++) {
        dictionaryWords[i] = null;
      }
      ends = 0;
      word = "";
      this.c = c;
    }
  }
}
