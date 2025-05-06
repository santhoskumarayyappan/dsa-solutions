06-05-2025 [Question](https://leetcode.com/problems/majority-element-ii/description/)
```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majorityElements = new ArrayList<>();

        int count1 = 0, count2 = 0;
        int majorityElement1 = -1, majorityElement2 = -1;

        for (int num: nums) {
            if (num == majorityElement1) {
                count1++;
            } else if (num == majorityElement2) {
                count2++;
            } else if (count1 == 0) {
                majorityElement1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                majorityElement2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for (int num: nums) {
            if (num == majorityElement1) 
                count1++;
            else if (num == majorityElement2)
                count2++;
        }    

        if (count1 > nums.length / 3)
            majorityElements.add(majorityElement1);

        if (count2 > nums.length / 3)
            majorityElements.add(majorityElement2);

        return majorityElements;
    }
}
```
