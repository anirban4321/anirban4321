package DS_Uni.Amazon_Interview_Prep.src.com.anirban.dynamicprogramming.MatrixChainMultiplication;

public class EggDroppingPyzzle {

  public static void main(String[] args) {
    int N = 2, K = 10;
    int res=eggDrop(N,K);
    System.out.println(res);
  }
  static int eggDrop(int n, int k)
  {
    int[][] dp=new int[n+1][k+1];
    for(int i=0;i<=n;i++){
      for(int j=0;j<=k;j++){
        dp[i][j]=-1;
      }
    }
    return eggDropUtil(n,k,dp);
  }

  static int eggDropUtil(int n,int k,int[][]dp){
    if(k==0||k==1)
      return k;
    if(n==1)
      return k;
    if(dp[n][k]!=-1){
      return dp[n][k];
    }
    int min=Integer.MAX_VALUE;
    int low;
    int high;
    for(int i=1;i<=k;i++){
      if(dp[n-1][i-1]!=-1)

       low = dp[n - 1][i - 1];
      else{
        low=eggDropUtil(n-1,i-1,dp);
      }

      if(dp[n][k-i]!=-1)

        high = dp[n][k-i];
      else{
        high=eggDropUtil(n,k-i,dp);
      }
      //int temp=1+Math.max(eggDropUtil(n-1,i-1,dp),eggDropUtil(n,k-i,dp));
      int temp=1+Math.max(low,high);
      min=Math.min(min,temp);
    }
    return dp[n][k]=min;
  }
}
