//16-04-2022
//https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1


class Solution{


	public int perfectSum(int[] nums, int target) {
	        int n = nums.length;
	        int[][] subSetCountWithSum = new int[n + 1][target + 1];
	        
	        // subSetCountWithSum[i][j] represents number of subsets possible with elements till i and sum  j
	        subSetCountWithSum[0][0] = 1;
	        
	        for (int i = 1; i <= n; i++) {
	            for (int j = 0; j <= target; j++) {
	                if (nums[i - 1] <= j)
	                    subSetCountWithSum[i][j] = subSetCountWithSum[i - 1][j - nums[i - 1]];
	                subSetCountWithSum[i][j] += subSetCountWithSum[i - 1][j];
	            }
	        }
        
        	return subSetCountWithSum[n][target];
      }
	
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int[] subsetSum = new int[sum + 1];
            subsetSum[0] = 1;
	    for (int ele : arr) {
	        for (int j = sum; j >= ele; j--) {
	            subsetSum[j] = (subsetSum[j] + subsetSum[j - ele]) % 1000000007;
	        }
	    }
	    return subsetSum[sum];
	} 
}
