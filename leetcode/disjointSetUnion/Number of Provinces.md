12-06-2022
[Question](https://leetcode.com/problems/number-of-provinces/)

```Java
class Solution {
    class DSU {
        int[] parent;
        int[] rank;
        int count;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
        
        public void union(int i, int j) {
            int parentI = find(i);
            int parentJ = find(j);
            if (parentI != parentJ) {
                if (rank[parentI] > rank[parentJ]) {
                    parent[parentJ] = parentI;
                } else if (rank[parentI] < rank[parentJ]) {
                    parent[parentI] = parentJ;
                } else {
                    parent[parentJ] = parentI;
                    rank[parentI]++;
                }
                count--;
            }
        }
        
        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }
        
        public int getComponentsCount() {
            return count;
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        DSU dsu = new DSU(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        return dsu.getComponentsCount();
    }
}
```
