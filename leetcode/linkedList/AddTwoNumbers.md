28-03-2025
[Question](https://leetcode.com/problems/add-two-numbers/)

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumOfL1AndL2DummyHead = new ListNode(0); 
        ListNode sumOfL1AndL2Traversor = sumOfL1AndL2DummyHead; 
        int carryForward = 0;

        while (l1 != null || l2 != null || carryForward != 0) { 
            int total = carryForward;
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            sumOfL1AndL2Traversor.next = new ListNode(total % 10);
            sumOfL1AndL2Traversor = sumOfL1AndL2Traversor.next;
            carryForward = total / 10;
        }

    return sumOfL1AndL2DummyHead.next;
    }
}
```
