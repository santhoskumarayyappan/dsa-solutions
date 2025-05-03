03-05-2025 [Question](https://leetcode.com/problems/majority-element/)

```java
class Solution {
    public int majorityElement(int[] nums) {
       int count = 0;
       int majorityElement = 0;

       for (int i = 0; i < nums.length; i++) {     
            if (count == 0)
                majorityElement = nums[i];

            if (majorityElement != nums[i])
                count--;
            else 
                count++;
       } 

       return majorityElement;
    }
}
```
