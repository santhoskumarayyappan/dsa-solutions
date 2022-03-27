//27-03-2022
//https://leetcode.com/problems/intersection-of-two-arrays/



// sort smaller array and then search in this for each element of Longer Array and add in Set
class Solution {
    
    public boolean search(int[] a, int target) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                return true;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intersection = new HashSet<>();
        
        if (nums1.length < nums2.length) {
            Arrays.sort(nums1);
            for (int a : nums2) {
                if (search(nums1, a)) {
                    intersection.add(a);
                }
            }
        } else {
            Arrays.sort(nums2);
            for (int a : nums1) {
                if (search(nums2, a)) {
                    intersection.add(a);
                }
            }
        }
        return new ArrayList<>(intersection).stream().mapToInt(Integer::intValue).toArray();
    }
}
