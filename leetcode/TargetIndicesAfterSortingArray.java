//22-03-2022
//https://leetcode.com/problems/find-target-indices-after-sorting-array/


class Solution {
    // given target find first i s.t a[i] >= target
    public int search(int[] a, int target) {
        int left = 0, right = a.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public List<Integer> targetIndices(int[] a, int target) {
        Arrays.sort(a);
        int left = search(a, target);
        int right = search(a, target + 1);
        return IntStream.range(left, right).boxed().collect(Collectors.toList());
    }
}
