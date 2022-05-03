//03-05-2022
//https://leetcode.com/problems/palindrome-linked-list/


class Solution {
    public ListNode reverse(ListNode head) {
        ListNode current = head, prev = null, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    public boolean compare(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }
    
    public boolean isPalindrome(ListNode head) {
        // prevOfSlow = to Split LinkedList
        // oddNode = to store midNode in Odd Length LinkedList
        ListNode fast = head, slow = head, prevOfSlow = head, oddNode = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevOfSlow = slow;
            slow = slow.next;
        }
        
        if (fast != null) {
            oddNode = slow;
            slow = slow.next;
        }
        
        prevOfSlow.next = null;
        
        ListNode lastNode = reverse(slow);
        
        boolean palindrome = compare(head, lastNode);
        
        slow = reverse(lastNode);
        
        if (oddNode != null) {
                prevOfSlow.next = oddNode;
                oddNode.next = slow; 
        } else {
            prevOfSlow.next = slow;
        }
        
        return palindrome;
        
    }
}
