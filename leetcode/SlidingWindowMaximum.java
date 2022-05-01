//01-05-2022
//https://leetcode.com/problems/sliding-window-maximum/


class Solution {
    class Node {
        int index;
        int val;
        Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Node> q = new LinkedList<Node>();
        List<Integer> ans = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (q.isEmpty()) {
                q.addLast(new Node(i, nums[i]));
            } else {
                if (i - q.peekFirst().index + 1 > k) {
                    q.pollFirst();
                }
                while (!q.isEmpty() && q.peekLast().val <= nums[i]) {
                    q.pollLast();
                }
                q.addLast(new Node(i, nums[i]));
            }
            
            if (i + 1 >= k) {
                ans.add(q.peekFirst().val);
            }
        }
        
        return ans.stream().mapToInt(e -> e).toArray();
    }
}
