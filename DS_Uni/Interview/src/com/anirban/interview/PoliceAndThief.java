package com.anirban.interview;

import java.util.ArrayList;



public class PoliceAndThief {

  public static void main(String[] args) {
    char[][] A={{'P', 'T', 'P'},
        {'T' ,'P','T'},
        {'T','T','P'}};
    int K=1;
   int res= policeThief(A,K);
    System.out.println(res);
  }
    static int policeThief(char[][] A, int K){
      int res = 0;
      ArrayList<Integer> thief = new ArrayList<Integer>();
      ArrayList<Integer> police = new ArrayList<Integer>();

      // store indices in the ArrayList
      for(int j=0;j<A.length;j++) {
        for (int i = 0; i < A[0].length; i++) {
          if (A[j][i] == 'P')
            police.add(i);
          if (A[j][i] == 'T')
            thief.add(i);
        }
        System.out.println(police);
        System.out.println(thief);

        int l = 0, r = 0;
        while (l < thief.size() && r < police.size()) {
          if (Math.abs(thief.get(l) - police.get(r)) <= K) {
            res++;
            l++;
            r++;
          }

          // increment the minimum index
          else if (thief.get(l) < police.get(r))
            l++;
          else
            r++;
        }
        police.clear();
        thief.clear();
      }
      return res;
    }

}
