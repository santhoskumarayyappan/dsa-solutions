//28-05-2022
//https://leetcode.com/problems/path-sum/

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
           return false;
       }
       if (root.left == null && root.right == null && root.val == targetSum) {
           return true;
       } 
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        return left || right; 
    }
}
