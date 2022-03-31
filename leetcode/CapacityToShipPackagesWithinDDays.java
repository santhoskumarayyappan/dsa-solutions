//01-04-2022
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/



class Solution {
    public int getNoOfDaysToLoadforCapacity(int[] weights, int capacity) {
        int days = 1, sum = 0;
        for (int ele : weights) {
            sum += ele;
            if (sum > capacity) {
                sum = ele;
                days++;
            } 
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = -1, right = 0;
        for (int ele : weights) {
            right += ele;
            left = Math.max(left, ele);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int daysTaken = getNoOfDaysToLoadforCapacity(weights, mid);
            if (daysTaken <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
