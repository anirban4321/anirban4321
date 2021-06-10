package com.anirban.recursion;

//User function Template for Java


class Sudoku {

  public static void main(String[] args) {
    int grid[][] = {
        { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
        { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
        { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
        { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
        { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
        { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
        { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

    if (solveSudoku(grid))
      printGrid(grid);
    else
      System.out.println("No StringHalvesAlike exists");
  }

  static boolean solveSudoku(int grid[][]) {
    int row = grid.length;
    int column = grid[0].length;
    int N = 9;
    return solvedSudokuUtil(grid, 0, 0, N);
  }

  static boolean solvedSudokuUtil(int[][] grid, int row, int col, int N) {
    if (row == N - 1 && col == N)
      return true;
    if (col == N) {
      row++;
      col = 0;
    }
    if (grid[row][col] != 0) {
      return solvedSudokuUtil(grid, row, col + 1, N);
    }

    for (int num = 1; num <= 9; num++) {
      if (isSafe(grid, row, col, num)) {
        grid[row][col] = num;
        if (solvedSudokuUtil(grid, row, col + 1, N))
          return true;
      }

      grid[row][col] = 0;
    }
    return false;
  }

  static boolean isSafe(int[][] grid, int row, int col, int num) {
    for (int x = 0; x <= 8; x++)
      if (grid[row][x] == num)
        return false;
    for (int x = 0; x <= 8; x++)
      if (grid[x][col] == num)
        return false;
        /*int startRow = row - row % 9, startCol
                                      = col - col % 9;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (grid[i + startRow][j + startCol] == num)
                    return false;*/
    return true;
  }

  static void printGrid(int grid[][]) {
    int N = 9;
    for (int i = 0; i <= 8; i++) {
      for (int j = 0; j <= 8; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }
}




