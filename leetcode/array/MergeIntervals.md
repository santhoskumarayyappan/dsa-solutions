09-04-2022
[Question](https://leetcode.com/problems/merge-intervals/)

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int lastPosition = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[lastPosition][1]) {
                intervals[lastPosition][1] = Math.max(intervals[lastPosition][1], intervals[i][1]);
            } else {
                lastPosition++;
                intervals[lastPosition] = intervals[i];
            }
        }

        return Arrays.copyOfRange(intervals, 0, lastPosition + 1);
    }
}
```
