```Java
package main.java;

import java.util.Scanner;

public class Main {
    static class Details {
        int min, max, size;
        Details(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    
    static class DSU {
        int[] parent;
        int[] size;
        int[] min;
        int[] max;
        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            min = new int[n];
            max = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
                min[i] = i + 1;
                max[i] = i + 1;
            }
        }
        
        public int getParent(int i) {
            while (i != parent[i]) {
                parent[i] =  parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public Details getDetails(int i) {
            int parentI = getParent(i); // details will be in parent
            return new Details(min[parentI], max[parentI], size[parentI]);
        }

        public void union(int i, int j) {
            int parentI = getParent(i);
            int parentJ = getParent(j);
            if (parentI != parentJ) { // corner case union only if not connected already
                if (size[parentI] > size[parentJ]) {
                    size[parentI] += size[parentJ];
                    parent[parentJ] = parentI;
                    min[parentI] = Math.min(min[parentI], min[parentJ]);
                    max[parentI] = Math.max(max[parentI], max[parentJ]);
                } else {
                    size[parentJ] += size[parentI];
                    parent[parentI] = parentJ;
                    min[parentJ] = Math.min(min[parentI], min[parentJ]);
                    max[parentJ] = Math.max(max[parentI], max[parentJ]);
                }
            }
        }

        public boolean find(int i, int j) {
            return getParent(i) == getParent(j);
        }
    }

    public static void main(String[] args) {
        int n, q;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        String s;
        int i, j;
        DSU dsu = new DSU(n);
        while (q-- > 0) {
            s = sc.next();
            if (s.equals("union")) {
                i = sc.nextInt();
                j = sc.nextInt();
                i--;
                j--;
                dsu.union(i, j);
            } else {
                i = sc.nextInt();
                i--;
                Details details = dsu.getDetails(i);
                System.out.println(details.min + " " + details.max + " " + details.size);
            }
        }
    }
}

```
