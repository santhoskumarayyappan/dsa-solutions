//06-03-2022
//https://leetcode.com/problems/find-the-distance-value-between-two-arrays/




// we need to find number of points of arr1 which does nt lie near any point of arr2 in distance >= d

// let distance(i, j) denotes |arr1[i]-arr2[j]|
// consider the two arrays are sorted 

// case 1
// distance(i, j) <= d
// then arr1[i] can be removed from answer and skipped


// case 2
// if arr1[i] > arr2[j] and distance(i, j) > d
// then obviously arr1[i+1, i+2, ...] > arr2[j] and distance(i + 1, j), distance(i + 2, j), ... > d as arrays sorted
// so arr2[j] can be skipped

// case 3
// if arr1[i] < arr2[j] and distance(i, j) > d
// then distance(i + 1, j), distance(i + 2, j) may or may not be > d
// examples cases of arr1, arr2 respectively
// [4,6,8], [1,2,6,7] arr1[i] = 4 arr2[j] = 6 d = 1 => here distance(i + 1, j) <= d i.e |6-6| <= d
// [4,6,8], [1,2,10,12] arr1[i] = 4 arr2[j] = 10 d = 1 => here distance(i + 1, j) > d i.e |6-10| > d
// but arr1[i] can be skipped (skipping arr1[i] leads to adding it to answer) as further values of arr2 will not change anything
// and arr1[i] would have been already removed if any previous arr2 values satisfied distance(i, j) <= d


class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = arr1.length;
        int i = 0, j = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        while (i < arr1.length && j < arr2.length) {
            if (Math.abs(arr1[i] - arr2[j]) <= d) {
                i++;
                ans--;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            }
        }
        return ans;
    }
}
