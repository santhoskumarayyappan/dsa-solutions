//26-05-2022
//https://leetcode.com/problems/binary-tree-maximum-path-sum/

class Solution {
    public static int maxSum;
    public int preOrderTraversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = preOrderTraversal(root.left);
        int rightSum = preOrderTraversal(root.right);
        int retVal =  root.val;
        retVal = Math.max(retVal, Math.max(retVal + leftSum, retVal + rightSum));
        maxSum = Math.max(maxSum, Math.max(retVal, leftSum + root.val + rightSum));
        return retVal;
    } 
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        preOrderTraversal(root);
        return maxSum;        
    }
}
