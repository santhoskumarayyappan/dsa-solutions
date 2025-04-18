18-04-2025
[Question](https://leetcode.com/problems/next-permutation)

* If array is in descending order, next permutation is basically reversed array
* If array is in ascending order, next permutation is last two unequal elements (a[i] < a[j], i < j) swapped array
* Consider the array [1, 2, 4, 3, 3, 2, 1], imagine array like mountains
* Find first index from right i, such that a[i] < a[i + 1]
* Swapping the element in this index a[i] with any element from right side of j will give Greater permutation. i.e a[j] > a[i] where j > i
* But we need next greater permutation not any greater
* So if we replace with rightmost element greater than a[i], here it is rightmost - 3  [1, 3, 4, 3, 3, 2, 2, 1]
* then just reverse i + 1 to n - 1 (same as sorting ascendingly since i is the first decreasing number) [1, 3, 1, 2, 2, 3, 3, 4]
  

```java
class Solution {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) 
            return;

        int firstDecreasingNumberPositionFromRight = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstDecreasingNumberPositionFromRight = i;
                break;
            }
        }

        if (firstDecreasingNumberPositionFromRight != -1) {
            int rightMostNumberGreaterThanFirstDecreasingNumberPosition = nums.length - 1;
            while (nums[rightMostNumberGreaterThanFirstDecreasingNumberPosition] <= nums[firstDecreasingNumberPositionFromRight])
                rightMostNumberGreaterThanFirstDecreasingNumberPosition--;
            swap(nums, firstDecreasingNumberPositionFromRight, rightMostNumberGreaterThanFirstDecreasingNumberPosition);
        }
        reverse(nums, firstDecreasingNumberPositionFromRight + 1, nums.length - 1);
    }
}
```
