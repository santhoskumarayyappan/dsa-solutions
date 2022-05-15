//26-03-2022
//https://leetcode.com/problems/fair-candy-swap/



class Solution {
    public int search(int[] a, int target) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public int[] fairCandySwap(int[] a, int[] b) {
        int sumA = 0, sumB = 0;
        for (int x : a) {
            sumA += x;
        }
        for (int x : b) {
            sumB += x;
        }
        
        Arrays.sort(b);
        
        for (int x : a) {
            int target = (2 * x + sumB - sumA) / 2;
            int y = search(b, target);
            if (y != -1) {
                return new int[] {x, b[y]};
            }
        }
        return new int[] {-1, -1};
    }
}
