package com.anirban.interview;

public class MinRepeatitions {

  public static void main(String[] args) {
    String A="abcd" ;
    String B="cdabcdab";
    System.out.println(minRepeats(A,B));
  }
  static int minRepeats(String A, String B) {
    String finalString =A;
    int k=1;
    while(finalString.length()<B.length()){
      finalString +=A;
      k++;
    }
    if(check(finalString,B)==true)
      return k;
    finalString +=A;
    k++;
    if(check(finalString,B)==true)
      return k;
    else
      return -1;
  }
  static boolean check(String finalString,String B){
    //  boolean flag=false;
    for(int i=0;i<=finalString.length()-B.length();i++){
      String temp = finalString.substring(i,B.length());
      if(temp.equals(B))
        return true;
    }
             /* int j;
            for ( j = 0; j < B.length(); j++)
            if (finalString.charAt(i + j) != B.charAt(j))
                break;

        if (j == B.length()) // pattern matched
            return true;
        }*/
    return false;
  }


}
