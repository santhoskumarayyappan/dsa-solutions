29-03-2025 [Question](https://leetcode.com/problems/merge-two-sorted-lists/description)

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedListHead = new ListNode(0);
        ListNode traversor = mergedListHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                traversor.next = list1;
                list1 = list1.next;
            } else {
                traversor.next = list2;
                list2 = list2.next;
            }
            traversor = traversor.next;
        }

        traversor.next = list1 != null ? list1 : list2;

        return mergedListHead.next;
    }
}
```
