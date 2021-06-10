package com.anirban.interview;

import org.w3c.dom.Node;

public class AreCousins {
   Node root;
  public static void main(String[] args) {
    AreCousins tree = new AreCousins();
    tree.root = new Node(30);
    tree.root.left = new Node(6);
    tree.root.right = new Node(8);
    tree.root.left.left = new Node(14);
    tree.root.left.right = new Node(16);
    tree.root.right.left = new Node(17);
    tree.root.right.right = new Node(18);
    tree.root.left.left.left = new Node(12);
    tree.root.left.right.left = new Node(13);
    tree.root.left.right.right = new Node(23);
    tree.root.right.left.left = new Node(26);
    tree.root.right.left.right = new Node(27);


    int Node1=12;
    int Node2=26;
    if (tree.isCousins(tree.root, Node1, Node2))
      System.out.println("Yes");
    else
      System.out.println("No");
  }
  class NodeInfo{
    int height;
    int root;
    int parent;

    public NodeInfo(int height, int root, int parent) {
      this.height = height;
      this.root = root;
      this.parent = parent;
    }
  }
  int aparent;
  int bparent;
  public boolean isCousins(Node root, int a, int b) {
    if(root==null)
      return false;

    if(root.data==a||root.data==b)
      return false;
    aparent=-1;
    NodeInfo x =new NodeInfo(0,a,aparent);
    NodeInfo y =new NodeInfo(0,b,bparent);
    //int aHeight=findHeight(root,x.parent,a,0);
    findHeight(root,x.parent,x,y,0);
    bparent=-1;
    //int bHeight=findHeight(root,y.parent,b,0);
   /* findHeight(root,y.parent,b,0);*/
    if(x.parent!=y.parent && x.height== y.height)
      return true;
    else return false;
  }

  private void findHeight(Node root, int parent, NodeInfo x, NodeInfo y, int height) {
    if(root==null)
      return ;
    findHeight(root.left,parent,x,y,height+1);
    if(root.data==x.root) {
      x.height = height;
      x.parent=parent;
    }
    if(root.data==y.root) {
      y.height = height;
      y.parent=parent;
    }
    /*x.parent=root.data;
    y.parent=root.data;*/
    findHeight(root.right,parent,x,y,height+1);
  }

  private int findHeight(Node root,int parent,int value, int height){
    if(root==null)
      return 0;
    if(root.data==value)
      return height;
    parent=root.data;
    int left = findHeight(root.left,parent,value,height+1);
    if(left!=0)
      return left;
    parent=root.data;
    int right=findHeight(root.right,parent,value,height+1);
    return right;
  }

  static class Node
  {
    int data;
    Node left, right;

    // Constructor to create a new tree node
    Node(int item)
    {
      data = item;
      left = right = null;
    }
  }
}

