//16-04-2022
//https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638


class Solution{


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
