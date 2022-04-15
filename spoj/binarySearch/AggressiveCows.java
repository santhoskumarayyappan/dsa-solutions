//02-04-2022
//https://www.spoj.com/problems/AGGRCOW/



import java.util.*;

public class Main {

    public static void main (String[] args) throws java.lang.Exception {
        try {
            int t;
            int n, c;
            Scanner sc = new Scanner(System.in);
            t = sc.nextInt();
            while (t-- > 0) {
                n = sc.nextInt();
                c = sc.nextInt();
                int[] stalls = new int[n];
                for (int i = 0; i < n; i++) {
                    stalls[i] = sc.nextInt();
                }
                System.out.println(Math.max(getLargestMinimumDistance(stalls, n, c), 0));
            }
        } catch (Exception e) {
            return;
        }

    }

    private static long getLargestMinimumDistance(int[] a, int n, int c) {
        Arrays.sort(a);
        long left = 0, right = a[n - 1];
        while (left < right) {
            long mid = left + (right - left) / 2l;
            //System.out.println("left " + left + " right " + right + " mid " + mid);
            if (isNotPossible(a, n, c, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private static boolean isNotPossible(int[] a, int n, int c, long mid) {
        c--;
        int prev = a[0];
        for (int i = 1; c > 0 && i < n; i++) {
            if (a[i] - prev >= mid) {
                prev = a[i];
                c--;
            }
        }
        return c > 0;
    }
}
