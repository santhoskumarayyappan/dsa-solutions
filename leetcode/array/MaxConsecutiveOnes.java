class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // without flip
        int ans = 0;
        int sum = 0;
        for (int ele : nums) {
            if (ele == 0) {
                sum = 0;
            } else {
                sum++;
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
  
  public int findMaxConsecutiveOnesII(int[] nums) {
        // atmost one flip
        // input is stream
        int res = 0, cur = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt ++;
            if (nums[i] == 0) {
                cur = cnt;
                cnt = 0;
            } 
            res = Math.max(res, cnt + cur);
        }
        return res;
    }
  
  public int findMaxConsecutiveOnesII(int[] nums) {
        // atmost one flip
        int[] count = new int[2];
        int index = 0;
        int max = 0;
        boolean zero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count[index] ++;
                max = Math.max(max, count[0] + count[1]);
            }
            else {
                zero = true;
                index = index ^ 1;
                count[index] = 0;
            }
        }
        if (zero == true) {
            max ++;
        }
        return max;
    }
}
