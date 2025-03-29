29-03-2025
[Question](https://leetcode.com/problems/swap-nodes-in-pairs/)

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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode(0);
        ListNode resultTraversor = dummyHead;

        while (head!= null && head.next != null) {
            resultTraversor.next = head.next;
            head.next = head.next.next;
            resultTraversor.next.next = head;
            
            head = head.next;
            resultTraversor = resultTraversor.next.next;
        }

        return dummyHead.next;
    }
}
```
