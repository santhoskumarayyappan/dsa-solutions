08-05-2025 [Question](https://leetcode.com/problems/unique-paths)
```
consider 'R', 'D' as going right and going down in the grid
To reach (m, n) from (0, 0) we need to take n - 1 'R' and m - 1 'D'
which is same as
Number of ways of choosing m - 1 from (m - 1 + n - 1)
(or) 
Number of ways of choosing n - 1 from (m - 1 + n - 1)

whichever is minimum among (m - 1) and (n - 1) will leads to smaller calculations
lets assume (n - 1) = min(m - 1, n - 1)
(m + n - 2) C (n - 1)
= (m + n - 2)! / (m - 1)! (n - 1)!
= (m + n - 2)*(m + n - 3)...(m - 1)...(n - 1)...1 / (m - 1)! (n - 1)!
= (m + n - 2)*(m + n - 3)...(m) / (n - 1)!
= (m + n - 2)*(m + n - 3)...(m) / (n - 1)*(n - 2)*(n - 3)..1
= (m + n - 2 - 1 + 1)*(m + n - 2 - 2 + 1)...(m + n - 2 - 1 + n - 1) / 1 * 2 * ...(n - 2)*(n - 1)
 Pi (m + n - 2 - i + 1 / i), i E [1, n - 1]

Basically nCr =  Pi (n - i + 1 / i), i E [1, min(r, n - r)]
```

```java
class Solution {
    public int uniquePaths(int m, int n) {
        m--;
        n--;
        
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        long uniquePaths = 1;
        for (int i = 1; i <= n; i++) {
            uniquePaths = uniquePaths * (m + n - i + 1) / i;
        }

        return (int)uniquePaths;
    }
}
```
