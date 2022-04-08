//09-04-2022
//https://leetcode.com/problems/merge-intervals/



class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prev = 0;
        for (int cur = 1; cur < intervals.length; cur++) {
            if (intervals[cur][0] <= intervals[prev][1]) {
                intervals[prev][1] = Math.max(intervals[prev][1], intervals[cur][1]);
            } else {
                prev++;
                intervals[prev][0] = intervals[cur][0];
                intervals[prev][1] = intervals[cur][1];
            }
        }
        return Arrays.copyOfRange(intervals, 0, prev + 1);
    }
}
