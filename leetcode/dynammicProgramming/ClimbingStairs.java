//15-04-2022
//https://leetcode.com/problems/climbing-stairs/



class Solution {
    public int climbStairs(int n) {
        int[] steps = new int[n + 2]; // steps[i] = distinct ways to reach i
        steps[1] = 1;
        steps[2] = 2;
        
        
        for (int i = 3; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }
}
