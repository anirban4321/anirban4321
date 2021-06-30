package com.anirban.lrucache;

public class DoublyLinkedListNode {
    int key;
    int value;
    DoublyLinkedListNode pre;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(int key, int value)
    {
      this.key = key;
      this.value = value;
    }
}
