//30-04-2022
//https://leetcode.com/problems/is-graph-bipartite


class Solution {
    
    public boolean isBipartite(int[][] graph) {
        // 0 -> unvisited, 1 -> A, -1 -> B
        int[] color = new int[graph.length];
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                q.add(i);
                color[i] = 1;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int next : graph[cur]) {
                        if (color[next] == 0 ) {
                            color[next] = -color[cur];
                            q.add(next);
                        } else if (color[next] != -color[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
