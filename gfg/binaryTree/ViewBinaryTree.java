//29-04-2022
//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1/

ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (i == 0) {    
                    ans.add(cur.data);
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            
        }
        return new ArrayList<>(ans);
    }

//https://leetcode.com/problems/binary-tree-right-side-view/
public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
                if (size == 0) {    
                    ans.add(cur.val);
                }
            }
            
        }
        return ans;
    }


class Solution
{
    static class HDNode {
        Node node;
        int hd;
        HDNode() {}
        HDNode(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
    
    //https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
    static ArrayList<Integer> topView(Node root)
    {
       ArrayList<Integer> ans = new ArrayList<>();
       if (root == null) {
           return ans;
       }
       TreeMap<Integer, Integer> map = new TreeMap<>();
       Queue<HDNode> q = new LinkedList<>();
       q.add(new HDNode(root, 0));
       
       while (!q.isEmpty()) {
           HDNode cur = q.poll();
           int hd = cur.hd;
           if (!map.containsKey(hd)) {
               map.put(hd, cur.node.data);
           }
           if (cur.node.left != null) {
               q.add(new HDNode(cur.node.left, hd - 1));
           }
           if (cur.node.right != null) {
               q.add(new HDNode(cur.node.right, hd + 1));
           }
       }
       for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           ans.add(entry.getValue());
       }
       return ans;
        
    }
}



class HDNode {
    Node node;
    int hd;
    HDNode(){}
    HDNode(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution
{
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<HDNode> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new HDNode(root, 0));
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                HDNode cur = q.poll();
                Node node = cur.node;
                int hd = cur.hd;
                
                if (node.left != null) {
                    q.add(new HDNode(node.left, hd - 1));
                }
                
                if (node.right != null) {
                    q.add(new HDNode(node.right, hd + 1));
                }
                
                map.put(hd, node.data);
            }
            
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ans.add(entry.getValue());
            }
        return ans;
    }
}




