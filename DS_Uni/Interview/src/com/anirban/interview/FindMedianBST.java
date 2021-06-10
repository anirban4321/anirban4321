package com.anirban.interview;


class FindMedianBST
{

  public static void main(String[] args) {

  }
  public static void findMedian(Node root)
  {
        /*ArrayList<Integer> list1 = new Tree().inorder(root);
        int n=list1.size();
        //System.out.println(n);
        if(n%2==0){
            int first = list1.get(n/2-1);
            int second =list1.get((n/2));
            // System.out.println(first+" "+second);
            double sum=first+second;
            double result=sum/2;
            System.out.println(result);
        }else{
            int oddNode = (n+1)/2;
            System.out.println(list1.get(oddNode-1));
        }*/
    if(root == null)
      return;
    int count = countNode(root);
    int currCount = 0;
    Node current = root, pre = null, prev = null;
    while(current!=null){
      if(current.left==null){
        currCount++;
        if((count%2!=0 ) & (currCount==(count+1)/2))
          System.out.println(prev.data);
        else if((count%2==0) && (currCount==(count)/2+1))
          System.out.println((prev.data+current.data)/2);
        prev=current;
        current=current.right;
      }else{
        Node predecessor=current.left;
        while(predecessor.right!=null && predecessor.right!=current){
          predecessor=predecessor.right;
        }
        if(predecessor.right==null){
          predecessor.right=current;
          current=current.left;
        }else{
          predecessor.right=null;
          prev=predecessor;
          currCount++;
          if((count%2!=0) && (currCount==(count+1)/2))
            System.out.println(current.data);
          else if((count%2==0) && (currCount==(count)/2+1))
            System.out.println((prev.data+current.data)/2);
          prev=current;
          current=current.right;
        }
      }
    }

  }

  private static int countNode(Node root){
    int count=0;
    if(root==null)
      return count;
    Node current=root;
    while(current!=null){
      if(current.left==null){
        count++;
        current=current.right;
      }
      else{
        Node predecessor = current.left;
        while(predecessor.right!=null&&predecessor.right!=current){
          predecessor=predecessor.right;
        }
        if(predecessor.right==null){
          predecessor.right = current;
          current=current.left;
        }else{
          predecessor.right=null;
          count++;
          current=current.right;
        }
      }
    }
    return count;
  }

    /*ArrayList<Integer> list =new ArrayList<Integer>();
    private ArrayList<Integer> inorder(Node root){
        if(root==null)
           return list;
        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
        return list;
    }*/
}