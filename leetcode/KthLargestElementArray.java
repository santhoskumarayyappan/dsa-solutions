//25-02-2022
//https://leetcode.com/problems/kth-largest-element-in-an-array/



class KthLargestElementArray {
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
    
    public int partition(int[] nums, int l, int r) {
        int cur = l;
        for (int i = l; i < r; i++) {
            if (nums[i] < nums[r]) {
                swap(nums, i, cur);
                cur++;
            }
        }
        swap(nums, cur, r);
        return cur;
    }
    
    int randomPartition(int[] nums, int l, int r) {
        int n = r - l + 1;
        int pivot = (int)(Math.random() * (n));
        swap(nums, l + pivot, r);
        return partition(nums, l, r);
    }
    
    public int helper(int[] nums, int l, int r, int k) {   
        while (l <= r) {
            int index = randomPartition(nums, l, r);
             if (index == k) {
                return nums[index];
            } else if (index < k) {
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
        return Integer.MAX_VALUE;
    }
    
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, nums.length - k);
    }
}
