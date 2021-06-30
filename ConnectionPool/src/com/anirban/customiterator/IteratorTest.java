package com.anirban.customiterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

  public static void main(String[] args) {
    List<Integer> list= Arrays.asList(1,2,3,4,5,6);
    Iterator it =new CustomIterator<Integer>(list);
    while (it.hasNext())
      System.out.println(it.next());

    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
    Iterator<Integer> it1 = list1.stream().filter(x -> x % 2 == 1).iterator();
    while (it1.hasNext()) {
      System.out.println(it1.next());
    }
  }
}
