//24-04-2022
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/



class Solution {
    public boolean existsInFirst(int[] a, int left, int ele) {
        return a[left] <= ele;
    }
    
    public boolean binarySearchNotUseful(int[] a, int left, int mid) {
        return a[left] == a[mid];
    }
    
    public boolean search(int[] a, int target) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                return true;
            }
            
            if (binarySearchNotUseful(a, left, mid)) {
                left++;
                continue;
            }
            
            boolean targetExistsInFirst = existsInFirst(a, left, target);
            boolean midExistsInFirst = existsInFirst(a, left, a[mid]);
            
            if (targetExistsInFirst ^ midExistsInFirst) {
                if (targetExistsInFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (a[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
