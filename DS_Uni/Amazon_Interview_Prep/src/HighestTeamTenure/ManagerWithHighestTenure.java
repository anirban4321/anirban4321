package HighestTeamTenure;/*

----------------Amazon Online Assessment 2 - SDE 1( New Graduate ) 2021 ( Coding - 2 Questions ) ----------------------
                                                    - With Solutions



Imagine that an employment tree represents the formal employee hierarchy at Amazon. Manager nodes have
chid nodes for each employee that reports to them; each of these employees can, in turn, have child nodes
representing their respective reportees. Each node in the tree contains an integer representing the number of
months the employee has spent at the company. Team tenure is computed as the average tenure of the manager
and all the company employees working below the manager. The oldest team has the highest team tenure.

Write an algorithm to find the manager of the team with the highest tenure. An employee must have child nodes
to be a manager.

Input
The input to the function/method consists of an argument -
president, a node representing the root node of the employee hierarchy.

Output
Return the node which has the oldest team.

Note
There will be at least one child node in the tree and there will be no ties.

Example

Input
   President =
	             20
          12            18

      11   2   3      15   8

Output = 18
Explanation :
There are three managers in this tree with the following team tenures :
12 => (11+2+3+12)/4 = 7
18 => (18+15+8)/3 = 13.67
20 => (12+11+2+3+18+15+8+20)/8 = 11.125
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ManagerWithHighestTenure {

  public static HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter number");
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int parentNode = sc.nextInt();
      int childNode = sc.nextInt();
      if (hmap.containsKey(parentNode))
        hmap.get(parentNode).add(childNode);
      else {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(parentNode);
        hmap.put(parentNode, temp);
      }
      if (!hmap.containsKey(childNode))
        hmap.put(childNode, new ArrayList<>());
      int root = sc.nextInt();
      Pair maxSum = new Pair(0, 0);
      int maxTenureNode = -1;
      Pair pair = HighestTeamTenure.findHighestTenure(hmap, parentNode, maxTenureNode);
      System.out.println(pair.totalNodes + " " + pair.totalSum);
      System.out.println(maxTenureNode);
    }
  }
}
