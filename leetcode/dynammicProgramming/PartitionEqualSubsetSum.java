//15-04-2022
//https://leetcode.com/problems/partition-equal-subset-sum/




class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
        }
        if (sum % 2 != 0) {
            return false;
        }
        
        Arrays.sort(nums);
        int target = sum / 2;
        
        boolean[] dp = new boolean[target + 1];
        
        dp[0] = true;
        
        
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                    dp[j] |= dp[j - nums[i - 1]] ;
                }
            }
 
        return dp[target];
     }
}

// canPartition(n, target) = canPartition(n - 1, target - nums[n]) || canPartition(n - 1, target);
