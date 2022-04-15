//15-04-2022
//https://leetcode.com/problems/house-robber-ii/



// idea is find maxRob considering 0 to n - 2 houses 
//                then considering 1 to n - 1 houses
// return maximum among these
class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        
        int[] maxRob = new int[n];
        
        maxRob[0] = nums[0];
        maxRob[1] = Math.max(nums[1], nums[0]);
        
        for (int i = 2; i < n - 1; i++) {
            maxRob[i] = Math.max(maxRob[i - 1], maxRob[i - 2] + nums[i]);
        }
        int ans = maxRob[n - 2];
        
        
        maxRob[0] = 0;
        maxRob[1] = nums[1];
        
        for (int i = 2; i < n; i++) {
            maxRob[i] = Math.max(maxRob[i - 1], maxRob[i - 2] + nums[i]);
        }
        ans = Math.max(ans, maxRob[n - 1]);
        return ans;   
    }
}
