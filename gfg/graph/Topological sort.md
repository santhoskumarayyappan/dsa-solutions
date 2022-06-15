15-06-2022
[Question](https://practice.geeksforgeeks.org/problems/topological-sort/1/#)
* Idea is same as DFS except you push into stack after recursive call instead of appending before recursion
```java
class Solution
{
    
    static void helper(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st) {
        for(int ele : adj.get(i)) {
            if (!visited[ele]) {
                visited[ele] = true;
                helper(ele, adj, visited, st);
            }
        }
        st.push(i);
    }
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> st = new Stack<Integer>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                helper(0, adj, visited, st);
            }
        }
        int[] ans = new int[st.size()];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }
        return ans;
    }
}
```
