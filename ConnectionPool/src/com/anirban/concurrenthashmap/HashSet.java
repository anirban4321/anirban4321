package com.anirban.concurrenthashmap;

import java.util.HashMap;

// extends AbstractSet<E>
//    implements Set<E>, Cloneable, java.io.Serializable
public class HashSet<E>
{

  private transient HashMap<E,Object> map;

  // Dummy value to associate with an Object in the backing Map
  private static final Object PRESENT = new Object();

  public HashSet() {
    map = new HashMap<E,Object>();
  }

  public boolean add(E e) {
    return map.put(e, PRESENT)==null;
  }

  public boolean remove(Object o) {
    return map.remove(o)==PRESENT;
  }
}