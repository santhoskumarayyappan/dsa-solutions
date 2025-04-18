18-04-2025
[Question](https://leetcode.com/problems/sort-colors/)


Dutch National Flag Algorithm 
```java
class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] a) {
        int zero = 0, one = 0, two = a.length - 1;

        while (one <= two) {
            if (a[one] == 0) {
                swap(a, one, zero);
                zero++;
                one++;
            } else if (a[one] == 2) {
                swap(a, one, two);
                two--;
            } else {
                one++;
            }
        }
    }
}
```
