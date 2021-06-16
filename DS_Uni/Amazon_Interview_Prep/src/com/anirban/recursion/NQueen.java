package DS_Uni.Amazon_Interview_Prep.src.com.anirban.recursion;

public class NQueen {

  public static void main(String[] args) {
    int N=4;
    Position[] positions=nQueen(N);
    for(int i=0;i<positions.length;i++)
      System.out.println(positions[i].row+" "+positions[i].col);
  }
  static class Position{
    int row;
    int col;
    Position(int row, int col){
      this.row=row;
      this.col=col;
    }
  }
  static Position[] nQueen(int n) {
    Position[] positions = new Position[n];
    boolean hasSolution = solveNQueenUtil(n,0,positions);
    if(hasSolution)
      return positions;
    else return new Position[0];
  }

  static boolean solveNQueenUtil(int n,int row,Position[] position) {
    if(n==row)
      return true;
    for(int col=0;col<n;col++){
      boolean isSafe=true;
      for(int queen=0;queen<row;queen++)
        if(position[queen].col==col||position[queen].row==row||
            position[queen].row-position[queen].col==row-col||
            position[queen].row-position[queen].col==row+col){
          isSafe=false;
          break;
        }
      if(isSafe){
        position[row]=new Position(row,col);
        if(solveNQueenUtil(n,row+1,position))
          return true;
      }
    }
    return false;
  }

}
