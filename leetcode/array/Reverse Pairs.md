10-05-2025 [Question](https://leetcode.com/problems/reverse-pairs)

```java
class Solution {

    public void merge(int[] nums, int l, int r, int mid) {
        int leftSize = mid - l + 1;
        int[] left = Arrays.copyOfRange(nums, l, mid + 1);

        int rightSize = r - (mid + 1) + 1;
        int[] right = Arrays.copyOfRange(nums, mid + 1, r + 1);

        int i = 0, j = 0, k = l;

        while (i < leftSize && j < rightSize) {
            if (left[i] > right[j]) {
                nums[k] = right[j];
                k++;
                j++;                
            } else {
                nums[k] = left[i];
                k++;
                i++;
            }
        }

        while (i < leftSize) {
            nums[k] = left[i];
            k++;
            i++;
        }
        while (j < rightSize) {
            nums[k] = right[j];
            k++;
            j++;
        }
    }

    public int computeReversePairs(int[] nums, int l, int r, int mid) {
        int i = l, j = mid + 1;
        int reversePairs = 0;

        while (j <= r) {
            while (i <= mid && nums[i] <= 2l * nums[j]) i++;
            reversePairs += mid - i + 1;
            j++;
        }

        return reversePairs;
    }

    public int mergeSort(int[] nums, int l, int r) {
        int reversePairs = 0;
        if (l < r) {
            int mid = l + (r - l) / 2;
            reversePairs += mergeSort(nums, l, mid);
            reversePairs += mergeSort(nums, mid + 1, r);
            reversePairs += computeReversePairs(nums, l, r, mid);
            merge(nums, l, r, mid);
        }

        return reversePairs;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}

```
