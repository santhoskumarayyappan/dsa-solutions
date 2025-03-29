29-03-2025
[Question](https://leetcode.com/problems/merge-k-sorted-lists)

TimeComplexity: O(N*log k) where N - total number of elements in all lists combined, k - number of linked lists 

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

    public ListNode mergeHelper(ListNode[] lists, int l, int r) {
        if (l == r)
            return lists[l];

        int mid = l + (r - l) / 2;
        ListNode list1 = mergeHelper(lists, l, mid);
        ListNode list2 = mergeHelper(lists, mid + 1, r);
        return mergeTwoLists(list1, list2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return lists.length != 0 ? mergeHelper(lists, 0, lists.length - 1) : null;
    }
}
```
