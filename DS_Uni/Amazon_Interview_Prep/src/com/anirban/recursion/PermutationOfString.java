package DS_Uni.Amazon_Interview_Prep.src.com.anirban.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationOfString {

  public static void main(String[] args) {
    String s="ABC";
    System.out.println(find_permutation(s));
  }

  private static List<String> list = new ArrayList<String>();;

  public static List<String> find_permutation(String S) {
    int start=0;
    int end = S.length();
    return generatePermutation(S,start,end);
  }

  private static String swap(String S, int i, int j){
    char [] charArray = S.toCharArray();

    char temp = charArray[i];
    charArray[i]=charArray[j];
    charArray[j]=temp;
    return String.valueOf(charArray);
  }

  private static List<String> generatePermutation(String S, int start, int end){

    if(start==end-1)
      list.add(S);
    else{
      for(int i=start;i<end;i++){
        S=swap(S,start,i);
        generatePermutation(S,start+1,end);
        S=swap(S,start,i);
      }
    }
    Collections.sort(list);
    return list;
  }

}
