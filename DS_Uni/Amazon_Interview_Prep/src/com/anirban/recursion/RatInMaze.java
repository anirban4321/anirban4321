package DS_Uni.Amazon_Interview_Prep.src.com.anirban.recursion;

import java.util.ArrayList;

class RatInMaze {

  public static void main(String[] args) {
   /* int maze[][] = {
        { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };*/
    //int maze[][] = { { 0, 1, 1, 1 }, { 1, 1, 1, 0 }, { 1, 0, 1, 1 }, { 0, 0, 1, 1 } };

    /*int maze[][] = {
        { 1, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 1 } };
    */
    int maze[][] = {
        { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 1, 1, 1, 1 } };
    int n = 4;
    ArrayList<String> res = printPath(maze, n);
    if (res.size() > 0) {
      for (int i = 0; i < res.size(); i++)
        System.out.print(res.get(i) + " ");
      System.out.println();
    } else {
      System.out.println(-1);
    }
  }

  private static boolean isSafe(int[][] m, int n, int row, int col, boolean[][] visited) {
    if (row < 0 || col >= n || row >= n || col < 0 || m[row][col] == 0 || visited[row][col] == true)
      return false;
    else
      return true;
  }

  public static ArrayList<String> printPath(int[][] m, int n) {
    int row = m.length;
    int col = m[0].length;
    ArrayList<String> list = new ArrayList<>();
    boolean[][] visited = new boolean[n][n];
    String path = "";
    printPathUtil(m, n, 0, 0, path, visited, list);
    return list;
  }

  public static ArrayList<String> printPathUtil(
      int[][] matrix, int n, int row, int col, String path, boolean[][] visited, ArrayList<String> list) {
    if (row == n - 1 && col == n - 1 && matrix[row][col] == 1) {
      list.add(path);
      return list;
    }
    if (row == 0 && col == 0 && matrix[row][col] == 0)
      return list;
    visited[row][col] = true;
    if (isSafe(matrix, n, row + 1, col, visited)) {
      //System.out.println(path);
      path += "D";
      printPathUtil(matrix, n, row + 1, col, path, visited, list);
      path = path.substring(0, path.length() - 1);
    }

    if (isSafe(matrix, n, row, col - 1, visited)) {
      //System.out.println(path);
      path += "L";
      printPathUtil(matrix, n, row, col - 1, path, visited, list);
      path = path.substring(0, path.length() - 1);
    }

    if (isSafe(matrix, n, row, col + 1, visited)) {
      //System.out.println(path);
      path += "R";
      printPathUtil(matrix, n, row, col + 1, path, visited, list);
      path = path.substring(0, path.length() - 1);
    }

    if (isSafe(matrix, n, row - 1, col, visited)) {
      // System.out.println(path);
      path += "U";
      printPathUtil(matrix, n, row - 1, col, path, visited, list);
      path = path.substring(0, path.length() - 1);
    }
    visited[row][col] = false;
    return list;
  }
}
