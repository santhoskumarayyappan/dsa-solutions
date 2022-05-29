29-05-2022
[Question](https://leetcode.com/problems/delete-node-in-a-bst/)
```
class Solution {
   
    public TreeNode findMinNode(TreeNode root) {
        TreeNode prev = root;
        TreeNode cur = root.left;
        while (cur.left != null) {
            prev = cur;
            cur = cur.left;
        }
        prev.left = cur.right;
        return cur;
            
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null) {
                return root.right;
            } 
            if (root.right == null) {
                return root.left;
            }
            if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            }
            TreeNode minNode = findMinNode(root.right);
            minNode.left = root.left;
            minNode.right = root.right;
            return minNode;
        }
    }
}
```
