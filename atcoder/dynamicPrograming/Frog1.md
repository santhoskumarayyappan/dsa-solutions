21-03-2025 [Question](https://atcoder.jp/contests/dp/tasks/dp_a)
```java
import java.util.*;

class Main {

    private static int minimumCostRecursion(int[] height, int n) {
        if (n == 0)
            return 0;

        int cost = minimumCostRecursion(height, n - 1) + Math.abs(height[n] - height[n - 1]);
        if (n >= 2)
            cost = Math.min(cost, minimumCostRecursion(height, n - 2) + Math.abs(height[n] - height[n - 2] ));
        return cost;
    }

    private static int minimumCostMemoization(int[] height, int[] cost, int n) {
        if (n == 0)
            return 0;

        if (cost[n] != -1)
            return cost[n];

        cost[n] = minimumCostMemoization(height, cost, n - 1) + Math.abs(height[n] - height[n - 1]);
        if (n >= 2)
            cost[n] = Math.min(cost[n], minimumCostMemoization(height, cost, n - 2) + Math.abs(height[n] - height[n - 2] ));
        return cost[n];
    }

    private static int minimumCostTabulation(int[] height) {
        int n = height.length;
        int[] cost = new int[n];
        cost[0] = 0;
        cost[1] = Math.abs(height[1] - height[0]);

        for (int i = 2; i < n; i++)
            cost[i] = Math.min(cost[i - 1] + Math.abs(height[i - 1] - height[i]), cost[i - 2] + Math.abs(height[i - 2] - height[i]));

        return cost[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        int[] cost = new int[n];
        Arrays.fill(cost, -1);

        for (int i = 0; i < n; i++)
            height[i] = sc.nextInt();
        System.out.println(minimumCostTabulation(height));
    }
}
```
