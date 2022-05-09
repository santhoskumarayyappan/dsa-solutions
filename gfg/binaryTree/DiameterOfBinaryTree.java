//https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1/# 

    static int maxDistance = 0;

    public static int postOrderTraversal(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSubTreeHeight = postOrderTraversal(root.left);
        int rightSubTreeHeight = postOrderTraversal(root.right);
        maxDistance = Math.max(maxDistance, leftSubTreeHeight + rightSubTreeHeight + 1);
        int maximumHeight = Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
        return maximumHeight;
    }
