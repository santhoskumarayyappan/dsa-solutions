//03-04-2022
//https://leetcode.com/problems/trapping-rain-water



// water stored in any position i is
// Minimum(Max Height Of bar to the left of i, Max Height Of bar to the right of i) - Height of Bar at i
class Solution {
    public int trap(int[] a) {
        int n = a.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], a[i + 1]); 
        }
        
        int ans = 0, leftMax = a[0];
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, a[i]);
            int curWater = Math.min(leftMax, rightMax[i]) - a[i];
            if (curWater > 0) {
                ans += curWater;
            }
        }
        return ans;
    }
}
