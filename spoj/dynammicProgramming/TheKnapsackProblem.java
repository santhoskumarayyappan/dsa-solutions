//15-04-2022
//https://www.spoj.com/problems/KNAPSACK/


import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int n = sc.nextInt();

        int[][] sizeAndValue = new int[n][2];

        for (int i = 0; i < n; i++) {
            sizeAndValue[i][0] = sc.nextInt();
            sizeAndValue[i][1] = sc.nextInt();
        }

        int[] maxRob = new int[capacity + 1];
        maxRob[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = capacity; j >= sizeAndValue[i - 1][0]; j--) {
                maxRob[j] = Math.max(maxRob[j], maxRob[j - sizeAndValue[i - 1][0]] + sizeAndValue[i - 1][1]);
            }
        }
        System.out.println(maxRob[capacity]);
    }
}

//maxRob[n][capacity] = max(maxRob[n - 1][capacity], maxRob[n - 1][capacity - size[i]] + value[i])
