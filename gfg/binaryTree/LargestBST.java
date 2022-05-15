//15-05-2022
//https://practice.geeksforgeeks.org/problems/largest-bst


class Solution{
    
    static class NodeInfo {
		Integer size;
		Integer min;
		Integer max;
		Boolean isBst;
    
		public NodeInfo(Integer size, Integer min, Integer max, Boolean isBst) {
			this.size = size;
			this.min = min;
			this.max = max;
			this.isBst = isBst;
		}
	}

	public static NodeInfo postOrderTraversal(Node root) {
		if (root == null) {
			return null;
		}
		
		NodeInfo rootInfo = new NodeInfo(1, root.data, root.data, true);
		
		if (root.left == null && root.right == null) {
		    return rootInfo;
		}
		
		NodeInfo leftInfo = new NodeInfo(0, root.data, root.data, true),
		rightInfo = new NodeInfo(0, root.data, root.data, true);
		
		if (root.left != null) {
			leftInfo = postOrderTraversal(root.left);
			if (!leftInfo.isBst || leftInfo.max >= root.data) {
				rootInfo.isBst = false;
        	} else {
        	    rootInfo.min = leftInfo.min;
        	}
		} 
		
		if (root.right != null) {
			rightInfo = postOrderTraversal(root.right);
			if (!rightInfo.isBst || rightInfo.min <= root.data) {
				rootInfo.isBst = false;
	    	} else {
	    	    rootInfo.max = rightInfo.max;
	    	}
		}
		
		if (!rootInfo.isBst) {
		    rootInfo.size = Math.max(leftInfo.size, rightInfo.size);
		} else {
		    rootInfo.size = leftInfo.size + rightInfo.size + 1;
		}
		return rootInfo;	
	}
	
    static int largestBst(Node root)
    {  
		  return postOrderTraversal(root).size;
    }
}
