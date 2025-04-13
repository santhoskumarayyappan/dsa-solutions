13-04-2025 [Question](https://atcoder.jp/contests/dp/tasks/dp_b)
```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.min(k, i - 1); j++) {
                    dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(height[i - 1] - height[i - 1 - j]));
            }
        }
        System.out.println(dp[n]);
    }
}
```
