//18-05-2022
//https://leetcode.com/problems/rotate-list/


// attach last node to head and Find n - k th (x) node and set head = x.next and x.next = null 
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        ListNode cur = head;
        int n = 1;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
         
        if (k % n == 0) {
            return head;
        }
        
        cur.next = head;
        k = k % n;
        
        cur = head;
        for(int i = 1; i < n - k; i++) {
            cur = cur.next;
        }
        
        head  = cur.next;
        cur.next = null;
        return head;    
    }
}
