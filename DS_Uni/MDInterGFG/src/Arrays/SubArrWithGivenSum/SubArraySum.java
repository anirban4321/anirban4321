package Arrays.SubArrWithGivenSum;

/*
Find subarray with given sum | Set 1 (Nonnegative Numbers)
Last Updated: 25-05-2020
Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
Examples :

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4
Sum of elements between indices
2 and 4 is 20 + 3 + 10 = 33

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4
Sum of elements between indices
1 and 4 is 4 + 0 + 0 + 3 = 7

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
There is no subarray with 0 sum
 */

public class SubArraySum {

  public static void main(String[] args)
  {
    SubArraySum arraysum = new SubArraySum();
    int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
    int n = arr.length;
    int sum = 33;
    arraysum.findSubArraySum(arr, n, sum);
  }

  private void findSubArraySum(int[] arr, int n, int sum) {
    int current_sum;
    for(int i=0;i<n;i++)
    {
      current_sum = arr[i];
      for(int j=i+1;j<=n;j++)
      {
        if(current_sum==sum)
        {
          int p=j-1;
          System.out.println(i+"::"+p);
          return;
        }
        if (current_sum > sum || j == n)
          break;
        current_sum += arr[j];
      }
    }
    System.out.println("Not found subarray");
    return;
  }
}
