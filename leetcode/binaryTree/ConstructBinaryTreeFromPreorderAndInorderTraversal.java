//20-05-2022
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/


class Solution {
    private int preOrderIndex;
    private Map<Integer, Integer> valToInOrderIndexMap;
    
    public TreeNode helper(int[] preOrder, int[] inOrder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preOrder, inOrder, inStart, valToInOrderIndexMap.get(rootVal) - 1);
        root.right = helper(preOrder, inOrder, valToInOrderIndexMap.get(rootVal) + 1, inEnd);
        return root;     
    }
    
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        preOrderIndex = 0;
        valToInOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            valToInOrderIndexMap.put(inOrder[i], i);
        }
        return helper(preOrder, inOrder, 0, inOrder.length - 1);
    }
}
