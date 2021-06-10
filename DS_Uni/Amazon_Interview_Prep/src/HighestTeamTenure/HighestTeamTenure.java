package HighestTeamTenure;

import java.util.ArrayList;
import java.util.HashMap;

public class HighestTeamTenure {

  public static Pair maxSum;

  public static Pair findHighestTenure(HashMap<Integer, ArrayList<Integer>> hmap, int V, int maxTenureNode) {
    if (hmap.get(V).size() == 0)
      return new Pair(1, V);
    else {
      int totalNodesCount = 1;
      int totalSum = V;
      for (int i = 0; i < hmap.get(V).size(); i++) {
        Pair temp = findHighestTenure(hmap, hmap.get(V).get(i), maxTenureNode);
        totalNodesCount += temp.totalNodes;
        totalSum += temp.totalSum;
      }

      if (totalSum * maxSum.totalNodes >= maxSum.totalSum * totalNodesCount) { // logic to avoid precision error
        maxSum.totalNodes = totalNodesCount;
        maxSum.totalSum = totalSum;
        maxTenureNode = V;
      }
      return new Pair(totalNodesCount, totalSum);
    }
  }

}
