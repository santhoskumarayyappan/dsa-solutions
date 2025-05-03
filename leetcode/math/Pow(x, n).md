03-05-2025 [Question](https://leetcode.com/problems/powx-n/)

```java
class Solution {
    public double myPow(double x, int power) {
        if (power < 0)
            x = 1 / x;

        long n = Math.abs((long)power);
        double ans = 1;
        double xPowered = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= xPowered;
                n--;
            } else {
                xPowered = xPowered * xPowered;
                n /= 2;
            }
        }

        return ans;
    }
}
```
