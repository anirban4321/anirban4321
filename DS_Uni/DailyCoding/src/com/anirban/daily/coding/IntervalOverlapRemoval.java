package com.anirban.daily.coding;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalOverlapRemoval {


  public static void main(String[] args) {
    //int [][] matrix={{19,25},{10,20},{16,20}};
    int [][] matrix={{7,9},{2,4},{5,8}};
  //  (7, 9), (2, 4), (5, 8)
    System.out.println(minRemoval(matrix));
  }

  private static int minRemoval(int[][] matrix) {
    int rem=0;
    Arrays.sort(matrix, Comparator.comparingInt(o -> o[0]));
    int prevEnd=matrix[0][1];
    for (int i=1;i<matrix.length;i++){
      int currEnd=matrix[i][0];
      if(currEnd<prevEnd){
        rem++;
        prevEnd=Math.min(matrix[i][1],prevEnd);
      }
      prevEnd=matrix[i][1];
    }
    return rem;
  }

}
