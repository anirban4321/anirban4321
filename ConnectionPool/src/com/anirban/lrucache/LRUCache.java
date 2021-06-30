package com.anirban.lrucache;

import java.util.HashMap;

class LRUCache {
  private HashMap<Integer, DoublyLinkedListNode> map;
  private int capacity, count;
  private DoublyLinkedListNode head, tail;

  public LRUCache(int capacity)
  {
    this.capacity = capacity;
    map = new HashMap<>();
    head = new DoublyLinkedListNode(0, 0);
    tail = new DoublyLinkedListNode(0, 0);
    head.next = tail;
    tail.pre = head;
    head.pre = null;
    tail.next = null;
    count = 0;
  }

  public void deleteDoublyLinkedListNode(DoublyLinkedListNode node)
  {
    node.pre.next = node.next;
    node.next.pre = node.pre;
  }

  public void addToHead(DoublyLinkedListNode node)
  {
    node.next = head.next;
    node.next.pre = node;
    node.pre = head;
    head.next = node;
  }

  // This method works in O(1)
  public int get(int key)
  {
    if (map.get(key) != null) {
      DoublyLinkedListNode node = map.get(key);
      int result = node.value;
      deleteDoublyLinkedListNode(node);
      addToHead(node);
     /* System.out.println("Got the value : " + result
          + " for the key: " + key);*/
      return result;
    }
    System.out.println("Did not get any value"
        + " for the key: " + key);
    return -1;
  }

  // This method works in O(1)
  public void set(int key, int value)
  {
   /* System.out.println("Going to set the (key, "
        + "value) : (" + key + ", "
        + value + ")");*/
    if (map.get(key) != null) {
      DoublyLinkedListNode node = map.get(key);
      node.value = value;
      deleteDoublyLinkedListNode(node);
      addToHead(node);
    }
    else {
      DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
      map.put(key, node);
      if (count < capacity) {
        count++;
        addToHead(node);
      }
      else {
        map.remove(tail.pre.key);
        deleteDoublyLinkedListNode(tail.pre);
        addToHead(node);
      }
    }
  }
}