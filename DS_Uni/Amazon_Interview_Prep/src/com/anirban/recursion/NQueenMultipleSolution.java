package DS_Uni.Amazon_Interview_Prep.src.com.anirban.recursion;

import java.util.ArrayList;

public class NQueenMultipleSolution {

  public static void main(String[] args) {
    System.out.println(nQueen(4));
  }
  static ArrayList<ArrayList<String>> nQueen(int n) {
    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    char[][] board=new char[n][n];
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        board[i][j] = '.';
      }
    }
    solveNQueensUtil(board, 0, res);
    return res;
  }
  static void solveNQueensUtil(char[][] board,int row,ArrayList<ArrayList<String>> res){
    int n=board[0].length;

    if(n==row){
      res.add(construct(board));
      return;
    }

    for(int col=0;col<n;col++){
      if(isSafe(board,row,col)){
        board[row][col]='Q';
        solveNQueensUtil(board,row+1,res);
        board[row][col]='.';
      }
    }
  }

  static ArrayList<String> construct(char[][] board){
    ArrayList<String> res = new ArrayList<>();
    for(int i=0;i<board.length;i++){
      String s = new String(board[i]);
      /*if(s.equals("Q"))*/
        res.add(s);
    }
    return res;
  }

  static boolean isSafe(char[][] board, int row, int col){
    int n=board.length;
    //checking for vertically above square
    for(int i=row-1,j=col;i>=0;i--){
      if(board[i][j]=='Q')
       return false;
    }
    //checking for left top diagonally square
    for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
      if(board[i][j]=='Q')
       return false;
    }

    //checking for right top diagonally square
    for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
      if(board[i][j]=='Q')
       return false;
    }
    return true;
  }
}
