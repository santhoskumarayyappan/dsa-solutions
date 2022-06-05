05-06-2022
[Question](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)
```
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder ans = new StringBuilder(root.val + "," + serialize(root.left) + "," + serialize(root.right));
        return ans.toString();
    }

    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(q);
    }
    public TreeNode helper(Queue<String> q) {
        String rootVal = q.poll();
        if (rootVal.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(rootVal));
        root.left = helper(q);
        root.right = helper(q);
        return root;
    }
    
     public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n,");
                continue;
            }
            res.append(node.val + ",");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.valueOf(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.valueOf(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
```
