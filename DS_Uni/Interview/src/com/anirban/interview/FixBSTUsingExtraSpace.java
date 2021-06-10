package com.anirban.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class FixBSTUsingExtraSpace {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(10);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.right = new TreeNode(12);
    root.right.left = new TreeNode(7);
    inorder1(root);
    System.out.println("\nAfterFixing");
    new FixBSTUsingExtraSpace().recoverTree(root);
    inorder1(root);

    //inorder(r1);
    //System.out.println();
  }

  static void inorder1(TreeNode root){
    if(root==null)
      return;
    inorder1(root.left);
    System.out.print(root.val+" ");
    inorder1(root.right);
  }
  public void recoverTree(TreeNode root) {
    ArrayList<Integer>list=inorder(root);
    Collections.sort(list);

    createBst(list,root);
  }
  int index=0;
  private void createBst(ArrayList<Integer> list,TreeNode root){
    if(root==null)
      return;
    createBst(list,root.left);
    root.val=list.get(index);
    index++;
    createBst(list,root.right);
  }
  ArrayList<Integer> result = new  ArrayList<Integer>();

  private ArrayList<Integer> inorder(TreeNode root){
    Stack<TreeNode> s=new Stack<>();
    TreeNode current=root;
    while(current!=null || s.size()>0){
      while(current!=null){
        s.push(current);
        current=current.left;
      }
      current=s.pop();
      result.add(current.val);
      current=current.right;
    }
    return result;
  }
}
