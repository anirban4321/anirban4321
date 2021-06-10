package com.anirban.interview;

import java.util.HashMap;
import java.util.Map;

public class ConstructTree {
  class Node {

    int data;

    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }
    public static void main(String[] args) {
    int[] inord={3, 1, 4, 0, 5, 2, 6};
    int[] level={0, 1, 2, 3, 4, 5, 6};
    Node node =new ConstructTree().buildTree(inord,level);
    printPreOrder(node);
  }

  private static void printPreOrder(Node node) {
    if(node==null)
      return;
    System.out.println(node.data);
    printPreOrder(node.left);
    printPreOrder(node.right);

  }

  static Map<Integer,Integer> map=new HashMap<>();
  Node buildTree(int inord[], int level[])
  {
    for(int i=0;i<inord.length;i++){
      map.put(inord[i],i);
    }
    return new ConstructTree().buildTreeUtil(inord,level,0,inord.length-1);
  }

  int levelIndex=0;

  private Node buildTreeUtil(int[] inordr,int[] level,int inStart, int inEnd){
    if(inStart>inEnd)
      return null;
    int p=level[levelIndex];
    levelIndex++;
    Node node = new Node(p);
    int index = map.get(p);
    node.left=buildTreeUtil(inordr,level,inStart,index-1);
    node.right=buildTreeUtil(inordr,level,index+1,inEnd);
    return node;

  }
}
