package com.anirban.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Node{
  int data;
  Node left;
  Node right;
  Node(int data){
    this.data = data;
    left=null;
    right=null;
  }
}
public class VerticalSum {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    verticalSum(root);
  }

  static TreeMap<Integer,Integer> map= new TreeMap<Integer,Integer>();

  public static void verticalSum(Node root) {
    int level=0;
    verticalSumUtil(root,0);
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
    list.addAll(map.entrySet());
    System.out.println(list);
  }
  public static void verticalSumUtil(Node root,int level){
    verticalSumUtil(root.left,level-1);
    int prevSum=map.get(level)==null ? 0:map.get(level);
    map.put(level,prevSum+root.data);
    verticalSumUtil(root.right,level+1);
  }
}
