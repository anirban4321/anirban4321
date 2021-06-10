package com.anirban.daily.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//Find Non-overlapping intervals
// among a given set of intervals
/*
Given N set of time intervals,
the task is to find the intervals
which don’t overlap with the given set of intervals.
Examples:


Input: interval arr[] = { {1, 3}, {2, 4},
                          {3, 5}, {7, 9} }
Output:
[5, 7]
Explanation:
The only interval which
doesn’t overlaps with the other
intervals is [5, 7].
Input: interval arr[] = { {1, 3}, {9, 12},
                          {2, 4}, {6, 8} }
Output:
[4, 6]
[8, 9]
Explanation:
There are two intervals which
don’t overlap with other intervals are [4, 6], [8, 9].
 */
public class NonOverlapInterval {
  static class Interval
  {
    int start, end;

    Interval(int start, int end)
    {
      this.start = start;
      this.end = end;
    }
  }
  public static void main(String[] args) {
    int[][] arr = { { 1, 3 },
        { 2, 4 },
        { 3, 5 },
        { 7, 9 } };

    int N = arr.length;

    // Function Call
    ArrayList<Interval>list=findFreeinterval(arr, N);
    for(Interval interval:list)
      System.out.println(interval.start+" "+interval.end);

  }

  private static ArrayList<Interval> findFreeinterval(int[][] arr, int n) {
    Arrays.sort(arr, Comparator.comparingInt(a->a[0]));
    ArrayList<Interval> list=new ArrayList<>();
    for (int i=1;i<n;i++){
      int prevEnd=arr[i-1][1];
      int currStart=arr[i][0];
      if(prevEnd<currStart){
        Interval interval=new Interval(prevEnd,currStart);
        list.add(interval);
      }
    }
    return list;
  }
}
