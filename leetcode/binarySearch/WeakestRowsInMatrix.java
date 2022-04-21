//26-03-2022
//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/




class Solution {
    
    // find first index s.t a[index] <= 0
    // which will be no. of 1's
    public int search(int a[]) {
        int left = 0, right = a.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] <= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {      
        
        int[][] indexToSoldierCount = new int[mat.length][2];
        int i = 0;
        for (int[] a : mat) {
            int soldierCount = search(a);
            indexToSoldierCount[i][0] = i;
            indexToSoldierCount[i][1] = soldierCount;
            i++;
        }
        int[] ans = new int[k];
        Arrays.sort(indexToSoldierCount, 
                    (o1, o2) ->  (o1[1] == o2[1]) ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        
        for (i = 0; i < k; i++) {
            ans[i] = indexToSoldierCount[i][0];
        }
        return ans;
    }
}
