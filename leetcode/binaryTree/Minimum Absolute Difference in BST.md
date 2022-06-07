07-06-2022
[Question](https://leetcode.com/problems/minimum-absolute-difference-in-bst/)
```
class Solution {
    Integer prev, min;
    
    public void helper(TreeNode root) {
        
        if (root.left != null) {
            helper(root.left);
        }
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        if (root.right != null) {
            helper(root.right);
        }
        
    }
    public int getMinimumDifference(TreeNode root) {
        prev = null;
        min = Integer.MAX_VALUE;
        helper(root);
        return min;
    }
}
```
