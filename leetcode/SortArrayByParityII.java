//05-03-2022
//https://leetcode.com/problems/sort-array-by-parity-ii/



class Solution {
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int[] sortArrayByParityII(int[] nums) {
        int evenIndex = 0, oddIndex = 1;
        while (evenIndex < nums.length && oddIndex < nums.length) {
            if (nums[evenIndex] % 2 == 1 && nums[oddIndex] % 2 == 0) {
                swap(nums, evenIndex, oddIndex);
            } 
            if (nums[oddIndex] % 2 == 1) {
                oddIndex += 2;
            }
            if (nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }
        }
        return nums;
    }
}
