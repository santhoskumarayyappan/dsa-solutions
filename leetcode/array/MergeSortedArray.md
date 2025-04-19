09-04-2022
[Question](https://leetcode.com/problems/merge-sorted-array/)

Idea is to do without extra space, and do from end of array so that we  dont overwrite
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1, temp;

        while (i >= 0 && j >= 0) {
             
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
             k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}
```
