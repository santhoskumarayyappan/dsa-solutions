
13-04-2025 [Question](https://atcoder.jp/contests/dp/tasks/dp_c)
```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] happiness = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                happiness[i][j] = sc.nextInt();

        int[][] dp = new int[n][3];
        dp[0][0] = happiness[0][0];
        dp[0][1] = happiness[0][1];
        dp[0][2] = happiness[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + happiness[i][j]);
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < 3; j++)
            ans = Math.max(ans, dp[n - 1][j]);

        System.out.println(ans);
    }
}
```
