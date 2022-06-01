01-06-2022
[Question](https://leetcode.com/problems/subarray-sums-divisible-by-k/)

* sum[i] - sum[j] = k * n => subArray(i, j + 1) is divisible by k
* sum[i] % k - sum[j] % k = (k * n) % k
* sum[i] % k - sum[j] % k = 0
* sum[i] % k = sum[j] % k

`so If running sum upto i is equal to any previous running sum upto j then subArray(j + 1, i) will be accounted in answer`
```
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        Map<Integer, Integer> sumRemainderCount = new HashMap<>();
        sum[0] = 0;
        sumRemainderCount.put(0, 1);
        
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
            int key = ((sum[i + 1] % k) + k) % k;
            ans += sumRemainderCount.getOrDefault(key, 0);
            sumRemainderCount.merge(key, 1, Integer::sum);
            
        }
        return ans;
    }
}
```
