18-04-2025
[Question](https://leetcode.com/problems/maximum-subarray/)

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int localSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (localSum < 0) {
                localSum = nums[i];
            } else {
                localSum += nums[i];
            }
            maxSum = Math.max(maxSum, localSum);
        }
        return maxSum;
    }
}
```
