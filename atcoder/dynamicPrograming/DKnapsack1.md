13-04-2025 [Question]https://atcoder.jp/contests/dp/tasks/dp_d)
```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        int n, w;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

//        int[][] dp = new int[n + 1][w + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= w; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (j - weight[i - 1] >= 0)
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
//            }
//        }

        long[] dp = new long[w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = w; j >= 1; j--) {
                if (j - weight[i - 1] >= 0)
                    dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
            }
        }
        System.out.println(dp[w]);
    }
}
```
