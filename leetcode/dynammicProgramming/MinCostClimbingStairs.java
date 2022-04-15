//15-04-2022
//https://leetcode.com/problems/min-cost-climbing-stairs




class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[n]; // minCost[i] = minimum Cost to step on i
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        
        for (int i = 2; i < n; i++) {
            minCost[i] = Math.min(minCost[i - 1], minCost[i - 2]) + cost[i];
        }
        return Math.min(minCost[n - 1], minCost[n - 2]);
    }
}





