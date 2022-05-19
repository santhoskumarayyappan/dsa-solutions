//19-05-2022
//https://leetcode.com/problems/copy-list-with-random-pointer/


class Solution {
    public Node copyRandomList2(Node head) {
        Node dummyHead = new Node(-1);
        Map<Node, Node> oldToNewNodeMap = new HashMap<>();
        
        Node cur = head;
        Node newCur = dummyHead;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            
            newCur.next = newNode;
            oldToNewNodeMap.put(cur, newNode);
            
            newCur = newCur.next;
            cur = cur.next;
        }
        
        cur = head;
        newCur = dummyHead.next;
        while (cur != null) {
            newCur.random = oldToNewNodeMap.get(cur.random);
            
            cur = cur.next;
            newCur = newCur.next;
        }
        return dummyHead.next;
    }
    
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        
        Node oldCur = head;
        while (oldCur != null) {
            Node next = oldCur.next;
            Node newNode = new Node(oldCur.val);
            
            oldCur.next = newNode;
            newNode.next = next;
            
            oldCur = next;
        }
        
        oldCur = head;
        while (oldCur != null) {
            if (oldCur.random != null) {
                oldCur.next.random = oldCur.random.next; 
            } 
            oldCur = oldCur.next.next;
        }
        
        oldCur = head;
        Node newCur = head.next;
        while (oldCur != null) {
            Node next = oldCur.next;
            oldCur.next = next.next;
            oldCur = oldCur.next;
            
            if (oldCur != null) {
                next.next = oldCur.next;
            }  
        }
        return newCur;       
    }
}
