08-06-2022
[Question](https://leetcode.com/problems/random-pick-with-weight/)
* The idea is to calculate prefixSum of weight array 
* Find random element 'w' in range [1, prefixWeightSum.last()]
* Now find first index 'i' in prefixWeightSum s.t. 'w' <= prefixWeightSum[i]

```java
class Solution {
    Random random;
    int[] prefixWeightSum;
    int[] w;
    
    public Solution(int[] w) {
        random = new Random();
        this.w = w;
        prefixWeightSum = new int[w.length];
        
        prefixWeightSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixWeightSum[i] = prefixWeightSum[i - 1] + w[i];
        }
    }
    
    public int findFirstElementLE(int weight) {
        int low = 0, high = w.length - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (weight <= prefixWeightSum[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public int pickIndex() {
        int weight = random.nextInt(prefixWeightSum[prefixWeightSum.length - 1]) + 1;
        return findFirstElementLE(weight);
    }
}
```
