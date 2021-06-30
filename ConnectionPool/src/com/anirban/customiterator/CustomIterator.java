package com.anirban.customiterator;

import java.util.Iterator;
import java.util.List;

public class CustomIterator<T> implements Iterator {
  private List<T> list;
  private int currentPosition;
  private int skipBy;

  public CustomIterator(List<T> l){
    this(l,2);
  }

  public CustomIterator(List<T> list, int skipBy) {
    this(list,skipBy,0);
  }

  public CustomIterator(List<T>l,int skip,int startPosition){
    this.list=l;
    this.skipBy=skip;
    currentPosition = startPosition;
  }

  @Override
  public boolean hasNext() {
    return currentPosition < list.size();
  }

  @Override
  public T next() {
    T result = list.get(currentPosition);
    currentPosition+=skipBy;
    return result;
  }

  @Override
  public void remove() {

  }
}
