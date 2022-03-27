//28-03-2022
//https://leetcode.com/problems/intersection-of-two-arrays-ii/



class Solution {
    
    public int findFirst(int[] a, int target) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (a[left] == target ? left : -1);
    }
    
    public int[] helper(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int k = 0, i = 0;
        while (i < nums1.length) {
            if (i == 0 || nums1[i] != nums1[i - 1]) {
                int target = nums1[i];
                int index = findFirst(nums2, target);
                if (index != -1) {
                    while(i < nums1.length && index < nums2.length && nums1[i] == target && nums2[index] == target) {
                        // this will run atleast once if index found, so i will be incremented 
                        res[k++] = target;
                        i++;
                        index++;
                    }
                } else {
                    // if index not found, skip the element
                    i++;
                }
            } else {
                // skipping dupicates
                i++;
            }
        }
        return Arrays.copyOf(res, k);
    }
    
    public int[] intersect(int[] nums1, int[] nums2) {   
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1.length < nums2.length) {
            return helper(nums1, nums2);
        } else {
            return helper(nums2, nums1);
        }
    }
}


