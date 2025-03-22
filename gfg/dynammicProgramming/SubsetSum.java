//16-04-2022
//https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638


class Solution{

    static Boolean isSubsetSum(int a[], int sum) {
        int n = a.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        //dp[i][j] represents whether with subset of elements till 'i'  we can make sum 'j'  
        dp[0][0] = true;
        
        for (int i = 1; i <= n; i++) {
            dp[i][0] = true;
            for (int j = 1; j <= sum; j++) {
                if (j >= a[i - 1]) 
                    dp[i][j] = dp[i - 1][j - a[i - 1]];
                dp[i][j] |= dp[i - 1][j];
            }
        }
        
        return dp[n][sum];
    }
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean[] subsetSum = new boolean[sum + 1];
        subsetSum[0] = true;
        for (int ele : arr) {
            for (int j = sum; j >= ele; j--) {
                subsetSum[j] |= subsetSum[j - ele];
            }
        }
        return subsetSum[sum];
    }
}
