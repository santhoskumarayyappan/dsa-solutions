13-06-2022
[Question](https://leetcode.com/problems/smallest-string-with-swaps/)
* The idea is to sort characters within individual connected components
```java
class Solution {
    class DSU {
        int[] parent;
        int[] rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int i) {
            while (i != parent[i]) {
                i = parent[i] = parent[parent[i]];
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
                }
            }
        }
        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DSU dsu = new DSU(s.length());
        for (List<Integer> pair : pairs) {
            dsu.union(pair.get(0), pair.get(1));
        }
        
        Map<Integer, PriorityQueue<Character>> parentToChars = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            int parent = dsu.find(i);
            parentToChars.putIfAbsent(parent, new PriorityQueue<>());
            parentToChars.get(parent).add(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder(s);
          
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, parentToChars.get(dsu.find(i)).poll());
        }
        return sb.toString();        
    }
}
```
