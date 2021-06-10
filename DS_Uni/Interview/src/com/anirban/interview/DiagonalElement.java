package com.anirban.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class TreeNode
{
  int data; //node data
  TreeNode left, right; //left and right child's reference

  // Tree node constructor
  public TreeNode(int data)
  {
    this.data = data;
    left = right = null;
  }
}
public class DiagonalElement {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(3);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(6);
    root.right.right = new TreeNode(14);
    root.right.right.left = new TreeNode(13);
    root.left.right.left = new TreeNode(4);
    root.left.right.right = new TreeNode(7);
    diagonal(root);
  }

    static Map<Integer, ArrayList<Integer>> map= new HashMap<>();
    public static ArrayList<Integer> diagonal(TreeNode root)
    {
      ArrayList<Integer> result = new ArrayList<>();
      if(root==null)
        return result;
      addDiagonalElementToMap(root, 0, 0);
      for(Map.Entry<Integer,ArrayList<Integer>> entry:map.entrySet()) {
        result.addAll(entry.getValue());
      }
      map.clear();
      return result;
    }
    private static void addDiagonalElementToMap(TreeNode root, int level, int index){
      if(root==null)
        return;
      ArrayList<Integer> list = map.get(level-index);
      if(list==null||list.size()==0) {
        list=new ArrayList<>();
        list.add(root.data);
      }
      else list.add(root.data);
      if(map.containsKey(level-index))
        map.put((level-index),list);
      map.put((level-index),list);
      addDiagonalElementToMap(root.left,level+1,index-1);
      addDiagonalElementToMap(root.right,level+1,index+1);
    }
}
