23-06-2022
[Question](https://leetcode.com/problems/course-schedule-iii/)

During iteration, say I want to add the current course, `timeTaken` being total time of all courses taken till now, but adding the current course might exceed my deadline or it doesn’t.

1. If it doesn’t, then I have added one new course. Increment the `timeTaken` with duration of current course.
2. If it exceeds deadline, I can swap current course with current courses that has biggest duration.
* No change in number of courses sceduled and `timeTaken` might have just reduced.
* Just sort courses on their deadline so that this swap is always legal.
```java
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> (Collections.reverseOrder());
        
        int timeTaken = 0;
        for (int[] course : courses) {
            if (course[0] + timeTaken <= course[1]) {
                timeTaken += course[0];
                pq.offer(course[0]);
            } else if (!pq.isEmpty() && course[0] < pq.peek()) {
                timeTaken += course[0] - pq.poll();
                pq.offer(course[0]);
            }
        }
        return pq.size();
    }
}
```
