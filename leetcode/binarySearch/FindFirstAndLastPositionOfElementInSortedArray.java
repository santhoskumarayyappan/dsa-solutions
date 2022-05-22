// 22-05-2022
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/


class Solution {
    
    public int findFirst(int[] nums, int target) {
        int low = 0; 
        int high = nums.length;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;        
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        int firstOccurence = findFirst(nums, target);
        if (firstOccurence != nums.length && nums[firstOccurence] == target) {
            return new int[] {firstOccurence, findFirst(nums, target + 1) - 1};
        } else {
            return new int[] {-1, -1};
        }
    }
}
