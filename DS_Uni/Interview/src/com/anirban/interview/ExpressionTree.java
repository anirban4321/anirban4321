package com.anirban.interview;

import java.util.LinkedList;
import java.util.Queue;

public class ExpressionTree {
  class Node{
    String data;
    Node left;
    Node right;
    Node(String data){
      this.data = data;
      left=null;
      right=null;
    }
  }
  static Node root=null;
  public static void main(String[] args) {
    ExpressionTree et = new ExpressionTree();
    //String[] postfix = {"+","*","-", "5", "4" ,"100" ,"20"};
    String[] postfix = {"-", "5", "4" };
    //char[] charArray = postfix.toCharArray();
    et.constructTree(postfix);
    //inorder(root);
    System.out.println(et.evalTree(root));
  }
  static void inorder(Node t) {
    if (t != null) {
      inorder(t.left);
      System.out.print(t.data + " ");
      inorder(t.right);
    }
  }
  private boolean isOperator(String ch){
    if(ch=="+"||ch=="-"||ch=="*"||ch=="/")
      return true;
    return false;
  }
  private void constructTree(String[] s) {
    int p=0;
    Queue<Node> queue = new LinkedList<>();
    root= new Node(s[p]);
    p++;
    queue.add(root);
    while(!queue.isEmpty()){
      Node temp=queue.remove();
      Node l=null;
      Node r=null;
      if(p>=s.length)
        break;
      if(isOperator(s[p])){
        l = new Node(s[p++]);
        r = new Node(s[p++]);
        temp.left = l;
        temp.right = r;
        queue.add(l);
        queue.add(r);
      }
      else{
        l = new Node(s[p++]);
        r = new Node(s[p++]);
        temp.left = l;
        temp.right = r;
        queue.add(l);
        queue.add(r);
      }
    }
  }
  public int evalTree(Node root) {

    if(root==null)
      return 0;
    if(root.left==null&&root.right==null)
      return Integer.parseInt(root.data);
    int left= evalTree(root.left);
    int right= evalTree(root.right);

    if(root.data=="+")
      return left+right;
    if(root.data=="-")
      return left-right;
    if(root.data=="*")
      return left*right;
    else return left/right;


  }

}
