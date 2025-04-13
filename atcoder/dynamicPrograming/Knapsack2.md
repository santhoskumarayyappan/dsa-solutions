13-04-2025 [Question](https://atcoder.jp/contests/dp/tasks/dp_b)
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
        int totalValue = 0;
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
            totalValue += value[i];
        }

//  commented approach is standard one, but it will not work due to space constraint
//  Instead of trying to find maximum value possible with i elements and j weight
//  Try to find minimum weight needed with i elements to achieve value "total value" (sum of all elements)
//  Then find the weight such that it is less than or equal to 'w' and it gives maximum value

//        int[][] dp = new int[n + 1][w + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= w; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (j - weight[i - 1] >= 0)
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
//            }
//        }

//        int[] dp = new int[w + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = w; j >= 1; j--) {
//                if (j - weight[i - 1] >= 0)
//                    dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
//            }
//        }

        long INF = Long.MAX_VALUE;
        long[][] minimumWeightPossible = new long[n + 1][totalValue + 1];
        for (int j = 1; j <= totalValue; j++)
            minimumWeightPossible[0][j] = INF;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalValue; j++) {
                if (j - value[i - 1] >= 0 && minimumWeightPossible[i - 1][j - value[i - 1]] != INF) {
                    minimumWeightPossible[i][j] = minimumWeightPossible[i - 1][j - value[i - 1]] + weight[i - 1];

                    if (minimumWeightPossible[i - 1][j] != INF)
                        minimumWeightPossible[i][j] = Math.min(minimumWeightPossible[i][j], minimumWeightPossible[i - 1][j]);
                } else {
                    minimumWeightPossible[i][j] = minimumWeightPossible[i - 1][j];
                }
            }
        }

        int maximumValue = 0;
        for (int j = totalValue; j >= 0; j--) {
            if (minimumWeightPossible[n][j] != INF && minimumWeightPossible[n][j] <= w) {
                maximumValue = j;
                break;
            }
        }
        System.out.println(maximumValue);
    }
}
```
