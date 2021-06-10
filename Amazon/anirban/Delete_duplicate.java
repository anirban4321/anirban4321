package Amazon.anirban;
/* Remove duplicate elements from sorted Array
Given a sorted array A of size N. The function remove_duplicate takes two arguments . The first argument is the sorted array A[ ] and the second argument is 'N' the size of the array and returns the size of the new converted array A[ ] with no duplicate element.

Input Format:
The first line of input contains T denoting the no of test cases . Then T test cases follow . The first line of each test case contains an Integer N and the next line contains N space separated values of the array A[ ] .

Output Format:
For each test case output will be the transformed array with no duplicates.

Your Task:
Your task to complete the function remove_duplicate which removes the duplicate  elements from the array .

Constraints:
1 <= T <= 100
1 <= N <= 104
1 <= A[ ] <= 106

Example:
Input  (To be used only for expected output) :
2
5
2 2 2 2 2 
3
1 2 2
Output
2
1 2

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.

** For More Input/Output Examples Use 'Expected Output' option **


Link:https://www.geeksforgeeks.org/remove-duplicates-sorted-array/ */

import java.util.Scanner;

class Delete_Duplicate
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int N = sc.nextInt();
			int a[] = new int[N];
			for(int i=0; i<N; i++)
				a[i] = sc.nextInt();
			
			GfG2 g = new GfG2();
			int n = g.remove_duplicate(a,N);
			
			for(int i=0; i<n; i++)
			System.out.print(a[i]+" ");
			
			System.out.println();
			
		T--;
		}
	}
}// } Driver Code Ends


class GfG2
{
        /*You are required to complete this function */
	int remove_duplicate(int a[], int N)
	{
		if(N==0||N==1)
		  return N;
		int j=0;
		for(int i=0;i<N-1;i++){
		    if(a[i]!=a[i+1])
		       a[j++]=a[i];
		}
		    a[j++]=a[N-1];
		return j;
	}
	
}
