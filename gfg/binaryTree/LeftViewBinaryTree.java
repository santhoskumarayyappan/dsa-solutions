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
