17-05-2025 [Question](https://leetcode.com/problems/3sum/description/)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) i++;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                long sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    triplets.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j - 1]) j++; 
                    while(j < k && nums[k] == nums[k + 1]) k--; 
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return triplets;
    }
}
```

* Skipping duplicates for i index is straightforward
* But why are we skipping duplicates on j and k only after finding a triplet
* The idea is that we need to consider duplicates only in the range of [i + 1, nums.length - 1] for j and k duplicates
* We should nt skip a jth element because it is equal to ith element
* One more thing is we should skip only till j and k becomes equal
* In case we check in beginning of while loop then we need to write additional continue to skip the loop and recheck for j == k 
* Below snippet is alternative where we check for duplicates at entry
```java
while (j < k) {
  while (j > i + 1 && j < k && nums[j] == nums[j - 1])
       j++; 
  while (k + 1 < nums.length && k > j && nums[k] == nums[k + 1])
       k--; 
  if (j == k) 
      continue;
.
.
.
}


```
