07-06-2022
[Question](https://leetcode.com/problems/maximum-width-of-binary-tree/)
<br>
` * Idea is to insert position of nodes with node in Q and calculate Width`
```
class Solution {
    class DataNode {
        TreeNode node;
        int pos;
        DataNode(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<DataNode> q = new LinkedList<>();
        q.add(new DataNode(root, 0));
        int width = 0;
        while (!q.isEmpty()) {
            int nodes = q.size();
            int leftMostPos = q.peek().pos;
            for (int i = 0; i < nodes; i++) {
                DataNode cur = q.poll();
                if (i == nodes - 1) {
                    width = Math.max(width, cur.pos - leftMostPos + 1);
                }
                if (cur.node.left != null) {
                    q.add(new DataNode(cur.node.left, cur.pos * 2 + 1));
                } 
                if (cur.node.right != null) {
                    q.add(new DataNode(cur.node.right, cur.pos * 2 + 2));
                }
            }
        }
        return width;
    }
}
```
