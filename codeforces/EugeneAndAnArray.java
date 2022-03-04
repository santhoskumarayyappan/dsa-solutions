//28-02-2022
//https://codeforces.com/contest/1333/problem/C



import java.util.*;

// observation
// Say, prefixSum[i] = prefixSum[j] , i > j and j is the first index to satisfy this
// => a[0] + a[1] + ... + a[i] = a[0] + a[1] + ... a[i] + ... + a[j]
// => a[i + 1] + a[i + 2] + ... + a[j] = 0

// => a[i + 2] + a[i + 3] + ... + a[j] != 0
// since a[i + 1] != 0 otherwise prefix[j] would nt be the first index to satisfy our assumption, (if a[i + 1] = 0 , them prefixSum[i + 1] and prefixSum[i] would have been the same)
// so a[i + 2 ... j] is happy subArray

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
