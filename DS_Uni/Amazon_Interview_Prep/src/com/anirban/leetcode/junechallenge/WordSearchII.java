package com.anirban.leetcode.junechallenge;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

  public static void main(String[] args) {
    char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };
    String[] words = { "oath", "pea", "eat", "rain" };
    System.out.println(new WordSearchII().findWords(board, words));
  }

  private static void dfs(char[][] board, int i, int j, int rows, int cols, List<String> ans, TrieNode root) {
    if (i < 0 || j < 0 || i >= rows || j >= cols)
      return;
    int index = board[i][j] - 'a';

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
    board[i][j] = ch;
  }

  private static void insert(String word, TrieNode root) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int index = ch - 'a';
      if (current.dictionaryWords[index] == null) {
        current.dictionaryWords[index] = new TrieNode(ch);
      }
      current = current.dictionaryWords[index];
    }
    current.ends += 1;
    current.word = word;
  }

  public List<String> findWords(char[][] board, String[] words) {

    TrieNode root = new TrieNode('/');

    int rows = board.length;
    int cols = board[0].length;

    for (String word : words) {
      insert(word, root);
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

    TrieNode[] dictionaryWords;

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
