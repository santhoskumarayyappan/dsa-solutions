29-05-2022
[Question](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/)
```
class Solution {
    class Node {
        char ch;
        int count;
        Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Deque<Node> q = new LinkedList<>();
        
        for (char ch : s.toCharArray()) {
            int count = 1;
            if (q.isEmpty() || q.peekLast().ch != ch) {
                q.addLast(new Node(ch, count));
            } else {
                Node last = q.peekLast();
                last.count++;
                if (last.count == k) {
                    q.pollLast();
                }                
            }
        }
        StringBuilder st = new StringBuilder();
        for (Node node : q) {
            st.append(String.valueOf(node.ch).repeat(node.count));
        }
        return st.toString();
    }
}
```
