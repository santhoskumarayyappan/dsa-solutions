30-05-2022
[Question](https://leetcode.com/problems/combination-sum/)
```
class Solution {
    
    public void helper(int i, int target, int[] a, List<Integer> cur, List<List<Integer>> ans) {  
       if (target == 0) {
           ans.add(new ArrayList<>(cur));
       } else if (i == a.length) {
           return;
       } else {
           if (target - a[i] >= 0) {
               cur.add(a[i]);
               helper(i, target - a[i], a, cur, ans);
               cur.remove(cur.size() - 1);
           }
           helper(i + 1, target, a, cur, ans);   
       }  
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }
}
```
