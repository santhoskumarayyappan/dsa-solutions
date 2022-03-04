//02-03-2022
//https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/-




class KthLargestElementStringArray {
    
    public void swap(String[] nums, int i, int j) {
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int partition(String[] nums, int l, int r) {
        int pivotIndex = (int)(Math.random() * (r - l + 1));
        swap(nums, r, l + pivotIndex);
        for (int i = l; i < r; i++) {
            if (compare(nums[r], nums[i]) > 0) {
                swap(nums, i, l);
                l++;
            }
        }
        swap(nums, r, l);
        return l;
    }
    
    private int compare(String p1, String p2) {
        return p1.length() == p2.length() ? p2.compareTo(p1) : Integer.compare(p2.length(), p1.length());
    }
    
    public String kthLargestNumber(String[] nums, int k) {
        int l = 0, r = nums.length - 1;
        k--;
        while(l <= r) {
            int pivotIndex = partition(nums, l, r);
            if (pivotIndex == k) {
                return nums[k];
            } else if (pivotIndex < k) {
                l = pivotIndex + 1;
            } else {
                r = pivotIndex - 1;
            }
        }
        return "";
    }
}
