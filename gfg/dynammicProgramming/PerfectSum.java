//16-04-2022
//https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1


class Solution{

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
