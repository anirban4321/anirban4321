package com.anirban.interview;

import java.util.ArrayList;
import java.util.Arrays;

public class QueueReconstruction {

private static class Person {
    public final int height;
    public final int frontCount;

    Person(int height, int frontCount) {
      this.height = height;
      this.frontCount = frontCount;
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> A= new ArrayList<>();
    A.add(3);A.add(2);A.add(1);
    ArrayList<Integer> B=new ArrayList<>();
    B.add(0);B.add(1);B.add(1);
    ArrayList<Integer>result=new QueueReconstruction().arrange(A,B, A.size());
    for(Integer i:result)
      System.out.println(i);
  }
  ArrayList<Integer>arrange(ArrayList<Integer> A, ArrayList<Integer> B, int n)
  {
    Person[] persons = new Person[n];

    for (int i = 0; i < persons.length; i++)
      persons[i] = new Person(A.get(i), B.get(i));

    Arrays.sort(persons, (p1, p2) -> {
      int rtn = p2.height-p1.height;
      if(rtn==0)
        return p1.frontCount-p2.frontCount;
      return rtn;
    });

    for(Person person:persons){
      System.out.println(person.height + " "+person.frontCount);
    }

    ArrayList<Integer> ans = new ArrayList<>();
    for(int i=0;i<n;i++)
      ans.add(i,-1);
    for(int i=0;i<n;i++)
    {
      int count = persons[i].frontCount;
      for(int j=0;j<n;j++)
      {
        if(ans.get(j)==-1 && count==0)
        {
          ans.add(j,persons[i].height);
                    /*ans[j][0] = people[i][0];
                    ans[j][1] = people[i][1];*/
          break;
        }
        else if(ans.get(j)==-1 || ans.get(j)>=persons[i].height)
          count-=1;
      }
    }
    return ans;
  }
}