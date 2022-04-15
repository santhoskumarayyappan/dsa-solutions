//15-04-2022
//https://leetcode.com/problems/house-robber


class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        
        int[] maxRob = new int[n];
        maxRob[0] = nums[0];
        maxRob[1] = Math.max(nums[1], nums[0]);
        
        for (int i = 2; i < n; i++) {
            maxRob[i] = Math.max(maxRob[i - 1], maxRob[i - 2] + nums[i]);
        }
        return maxRob[n - 1];   
    }
}
