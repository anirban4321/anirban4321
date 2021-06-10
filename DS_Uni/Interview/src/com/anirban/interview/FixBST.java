package com.anirban.interview;

public class FixBST
{
  static class Node{
    int data;
    Node left, right;

    Node(int d) {
      data = d;
      left = right = null;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(6);
    root.left = new Node(10);
    root.right = new Node(2);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.right = new Node(12);
    root.right.left = new Node(7);
    inorder(root);
    System.out.println("\nAfterFixing");
    Node r1=new FixBST().correctBST(root);
    inorder(r1);
    //System.out.println();
  }

  static void inorder(Node root){
    if(root==null)
      return;
    inorder(root.left);
    System.out.print(root.data+" ");
    inorder(root.right);
  }
  //Function to fix a given BST where two nodes are swapped.

  Node first;
  Node middle;
  Node last;
  Node prev;
  public Node correctBST(Node root)
  {
    first = middle = last = prev = null;
    correctBSTUtil(root);
    if(first!=null&&last!=null){
      int temp = first.data;
      first.data = last.data;
      last.data = temp;
    }
    else if(first!=null&&middle!=null){
      int temp = first.data;
      first.data = middle.data;
      middle.data = temp;
    }
    return root;
  }
  void correctBSTUtil(Node root){

    if(root!=null){
      //return;
      correctBSTUtil(root.left);
      if(prev!=null && root.data<prev.data){
        if(first==null){
          first=prev;
          middle=root;
        }
        else last=root;
      }
      prev=root;
      correctBSTUtil(root.right);
    }
  }


  /*void correctBSTUtil( Node root)
  {
    if( root != null )
    {
      // Recur for the left subtree
      correctBSTUtil( root.left);

      // If this node is smaller than
      // the previous node, it's
      // violating the BST rule.
      if (prev != null && root.data <
          prev.data)
      {
        // If this is first violation,
        // mark these two nodes as
        // 'first' and 'middle'
        if (first == null)
        {
          first = prev;
          middle = root;
        }

        // If this is second violation,
        // mark this node as last
        else
          last = root;
      }

      // Mark this node as previous
      prev = root;

      // Recur for the right subtree
      correctBSTUtil( root.right);
    }
  }


  void correctBST( Node root )
  {
    // Initialize pointers needed
    // for correctBSTUtil()
    first = middle = last = prev = null;

    // Set the pointers to find out
    // two nodes
    correctBSTUtil( root );

    // Fix (or correct) the tree
    if( first != null && last != null )
    {
      int temp = first.data;
      first.data = last.data;
      last.data = temp;
    }
    // Adjacent nodes swapped
    else if( first != null && middle !=
        null )
    {
      int temp = first.data;
      first.data = middle.data;
      middle.data = temp;
    }

    // else nodes have not been swapped,
    // passed tree is really BST.
  }*/
}