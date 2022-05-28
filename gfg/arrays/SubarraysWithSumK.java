
//28-05-2022
//https://practice.geeksforgeeks.org/problems/subarrays-with-sum-k/1/
class Solution
{
    static int findSubArraySum(int a[], int n, int k)
    {
        int ans = 0;
        Map<Integer, Integer> prefixSumToCount = new HashMap<>();
        prefixSumToCount.put(0, 1);
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            ans += prefixSumToCount.getOrDefault(sum - k, 0);
            prefixSumToCount.merge(sum, 1, Integer::sum);
        }
        return ans;
    }
}
