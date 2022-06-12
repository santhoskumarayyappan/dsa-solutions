12-06-2022
[Question](https://leetcode.com/problems/valid-triangle-number/)
* The idea is that For Three sides to form a Triangle, The sum of smaller two sides should be greater than largest side
* a + b > c , where a < c , b < c
```Java
class Solution {
    public int triangleNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // find first index s.t nums[i] + nums[j] <= nums[k]
                int target = nums[i] + nums[j];
                int low = j + 1, high = nums.length;
                while (low < high) {
                    int mid = low + (high - low) / 2;
                    if (target <= nums[mid]) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                ans += (low - 1) - (j + 1) + 1;
            }
        }
        return ans;
    }
}
```
