//30-03-2022
//https://leetcode.com/problems/find-the-duplicate-number/solution/


// Pigeon hole
// Find the first number x s.t
// (Count of NumberOfElements <= x) > x
class Solution {
    public int getNumberOfElementsLE(int[] nums, int target) {
        int count = 0;
        for (int ele : nums) {
            if (ele <= target) {
                count++;
            }
        }
        return count;
    }
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getNumberOfElementsLE(nums, mid) > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
