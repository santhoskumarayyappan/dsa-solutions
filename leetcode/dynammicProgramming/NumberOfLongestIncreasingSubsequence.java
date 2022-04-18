//18-04-2022
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/



class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n]; // lis ending with nums[i]
        int[] count = new int[n]; //count[i] = number of lis ending with nums[i]
        int maxCount = 0; // number of lis 
        int maxLength = -1;
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lis[i] < lis[j] + 1) {
                        lis[i] = lis[j] + 1;
                        count[i] = count[j];   
                    } else if (lis[i] == lis[j] + 1) {
                        count[i] += count[j];
                    }
                } 
            }
            if (maxLength < lis[i]) {
                maxLength = lis[i];
                maxCount = count[i];
            } else if (maxLength == lis[i]){
                maxCount += count[i];
            }
        }
        return maxCount;
    }
}
