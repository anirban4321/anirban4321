package DS_Uni.Amazon_Interview_Prep.src.com.anirban.dynamicprogramming;

public class MustDoInterviewQuestions {

  public static void main(String[] args) {
    int N=5;
    System.out.println(minOperation(N));
  }
  public static int minOperation(int n)
  {
    int dp[] =new int[n+1];
    dp[0]=0;
    dp[1]=1;
    for(int i=2;i<=n;i++){
      dp[i] = Integer.MAX_VALUE;
      if(i%2==0){
        int value = dp[i/2];
        if(value+1<dp[i])
          dp[i]=value+1;
      }
      int x = dp[i-1];
      if(x+1<dp[i])
        dp[i]=x+1;
    }
    return dp[n];

  }
}
