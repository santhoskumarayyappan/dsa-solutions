//30-05-2022
[Question](https://leetcode.com/problems/combination-sum-iii/)
```
class Solution {
    
    public void helper(int i, int target, int k, int[] a, List<Integer> cur, List<List<Integer>> ans) { 
       if (target == 0 && k == 0) {
           ans.add(new ArrayList<>(cur));
       } else if (i == a.length || k < 0) {
           return;
       } else {
           if (target - a[i] >= 0) {
               cur.add(a[i]);
               helper(i + 1, target - a[i], k - 1, a, cur, ans);
               cur.remove(cur.size() - 1);
           }
           helper(i + 1, target, k, a, cur, ans);   
       }  
    }
    
    public List<List<Integer>> combinationSum3(int k, int target) {
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, target, k, candidates, new ArrayList<>(), ans);
        return ans;
    }
}
```
