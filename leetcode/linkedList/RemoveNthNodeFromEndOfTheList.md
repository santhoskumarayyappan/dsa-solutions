29-03-2025 [Question](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 // To remove nth node from end of list
 // To remove a node which is n jumps away from Tail Null End of the list
 // To complete this in one traversal

 // what if i can have two traversors fast and slow
 // where slow is n jumps away from fast
 // and i make them both iterate
 // so when fast reached Tail Null End of the list
 // slow will be the node to be removed

 // how can i make fast n jumps away from slow?
 // just by making fast do n jumps first

 // but we need actually the node before the node to be removed for Linked List Node removal
 // also in case node to be removed is head of LinkedList, we need a dummy head
 // so instead of initializing slow to be head ill initialize to dummy head
 // which is one node behind head

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode traversor = head;
        ListNode previousOfNodeToBeRemoved = dummyHead;

        for (int i = 1; i <= n; i++)
            traversor = traversor.next;

        while (traversor != null) {
            traversor = traversor.next;
            previousOfNodeToBeRemoved = previousOfNodeToBeRemoved.next; 
        }

        previousOfNodeToBeRemoved.next = previousOfNodeToBeRemoved.next.next;
        return dummyHead.next;
    }
}
```
