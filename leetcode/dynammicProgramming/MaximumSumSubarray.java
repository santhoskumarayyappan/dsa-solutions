//08-04-2022
//https://leetcode.com/problems/maximum-subarray/



class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0, maxSum = Integer.MIN_VALUE;
        for (int ele : nums) {
            curSum += ele;
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }
}
