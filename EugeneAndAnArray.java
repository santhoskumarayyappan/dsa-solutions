//28-02-2022
//https://codeforces.com/contest/1333/problem/C



import java.util.*;

public class EugeneAndAnArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Long, Integer> sumMap = new HashMap<>(); // gives position to the right (+ 1) of which Good SubArray can begin
        sumMap.put(0L, 0);
        long ans = 0, sum = 0;
        int leftPos = -1;
        for (int i = 0; i < n; i++) {
            sum += sc.nextInt();
            if (sumMap.containsKey(sum)) {
                leftPos = Math.max(leftPos, sumMap.get(sum));
            }
            ans += i - leftPos;
            sumMap.put(sum, i + 1);
        }
       System.out.println(ans);
    }
}
