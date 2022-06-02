02-06-2022
[Question](https://leetcode.com/problems/single-element-in-a-sorted-array/)
```
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // find first even index i s.t.  nums[i] != nums[i + 1]
        int n = (nums.length) / 2;
        int low = 0, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            System.out.println(mid);
            if (nums[mid * 2] != nums[mid * 2 + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low * 2];
    }
}
```
