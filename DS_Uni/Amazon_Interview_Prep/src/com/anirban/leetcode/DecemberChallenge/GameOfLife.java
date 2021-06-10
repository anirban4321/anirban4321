package com.anirban.leetcode.DecemberChallenge;

public class GameOfLife {

  public static void main(String[] args) {
    int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
    gameOfLife(board);
  }

  public static void gameOfLife(int[][] board) {
    int rows = board.length;
    int cols = board[0].length;
    int liveCells = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        liveCells = countLiveCells(board, i, j, rows, cols);

        if (board[i][j] == 1 && liveCells < 2)
          board[i][j] = -1;
        //        if (board[i][j] == 1 && liveCells == 2 || liveCells == 3)
        //          board[i][j] = 2;
        if (board[i][j] == 1 && liveCells > 3)
          board[i][j] = -1;
        if (board[i][j] == 0 && liveCells == 3)
          board[i][j] = 2;
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("updting");

    updateCells(board, rows, cols);

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }

  }

  private static void updateCells(int[][] board, int rows, int cols) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == -1)
          board[i][j] = 0;
        else if (board[i][j] == 2)
          board[i][j] = 1;
      }
    }
  }

  private static int countLiveCells(int[][] board, int i, int j, int rows, int cols) {
    int count = 0;
    if (safe(i - 1, j - 1, rows, cols)) {
      if (board[i - 1][j - 1] == -1 || board[i - 1][j - 1] == 1)
        count++;
    }

    if (safe(i, j - 1, rows, cols)) {
      if (board[i][j - 1] == -1 || board[i][j - 1] == 1)
        count++;
    }

    if (safe(i, j + 1, rows, cols)) {
      if (board[i][j + 1] == -1 || board[i][j + 1] == 1)
        count++;
    }

    if (safe(i - 1, j + 1, rows, cols)) {
      if (board[i - 1][j + 1] == -1 || board[i - 1][j + 1] == 1)
        count++;
    }

    if (safe(i - 1, j, rows, cols)) {
      if (board[i - 1][j] == -1 || board[i - 1][j] == 1)
        count++;
    }

    if (safe(i + 1, j + 1, rows, cols)) {
      if (board[i + 1][j + 1] == -1 || board[i + 1][j + 1] == 1)
        count++;
    }

    if (safe(i + 1, j, rows, cols)) {
      if (board[i + 1][j] == -1 || board[i + 1][j] == 1)
        count++;
    }

    if (safe(i + 1, j - 1, rows, cols)) {
      if (board[i + 1][j - 1] == -1 || board[i + 1][j - 1] == 1)
        count++;
    }
    return count;
  }

  private static boolean safe(int i, int j, int rows, int cols) {
    if (i < 0 || j < 0 || i >= rows || j >= cols)
      return false;
    return true;
  }
}
