30-05-2022
[Question](https://leetcode.com/problems/combination-sum-ii/)
```
class Solution {
    
    public void helper(int i, int target, int[] a, List<Integer> cur, List<List<Integer>> ans, Integer prevNotPicked) {  
       if (target == 0) {
           ans.add(new ArrayList<>(cur));
       } else if (i == a.length) {
           return;
       } else {
           if ((prevNotPicked == null || prevNotPicked != a[i]) && target - a[i] >= 0) {
               cur.add(a[i]);
               helper(i + 1, target - a[i], a, cur, ans, prevNotPicked);
               cur.remove(cur.size() - 1);
           }
           helper(i + 1, target, a, cur, ans, a[i]);   
       }  
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, target, candidates, new ArrayList<>(), ans, null);
        return ans;
    }
}
```
