//20-05-2022
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/


class Solution {
    private Map<Integer, Integer> valToInOrderIndexMap;
    private int postOrderIndex;
    
    public TreeNode helper(int[] inOrder, int[] postOrder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = postOrder[postOrderIndex--];
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(inOrder, postOrder, valToInOrderIndexMap.get(rootVal) + 1, inEnd);
        root.left = helper(inOrder, postOrder, inStart, valToInOrderIndexMap.get(rootVal) - 1);
        return root;
    }
    
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        postOrderIndex = postOrder.length - 1;
        valToInOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            valToInOrderIndexMap.put(inOrder[i], i);
        }
        return helper(inOrder, postOrder, 0, postOrder.length - 1);
    }
}
