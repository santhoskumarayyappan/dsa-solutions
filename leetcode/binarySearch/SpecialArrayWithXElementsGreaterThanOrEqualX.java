//27-03-2022
//Special Array With X Elements Greater Than or Equal X




class Solution {
    
    public int getNumberOfElementsGreaterThanOrEqualX(int[] nums, int x) {
        int count = 0;
        for (int ele : nums) {
            if (ele >= x) count++;
        }
        return count;
    }
    public int specialArray(int[] nums) {
        int left = 0, right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = getNumberOfElementsGreaterThanOrEqualX(nums, mid);
            if (mid == count) {
                return mid;
            } else if (mid < count) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
