11-05-2025 [Question](https://leetcode.com/problems/two-sum/)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = numToIndex.get(target - nums[i]);
            if (index != null) {
                return new int[]{ index, i };
            }
            numToIndex.put(nums[i], i);
        }

        return new int[]{};
    }
}
```
