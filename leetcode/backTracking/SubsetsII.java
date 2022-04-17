//17-04-2022
//https://leetcode.com/problems/subsets-ii/



class Solution {
    
    public void helper(int[] a, int index, List<List<Integer>> ans, List<Integer> currentList) {
        
     ans.add(new ArrayList<>(currentList));
           
        for (int i = index; i < a.length; i++) {
            if (i > index && a[i] == a[i - 1]) {
                continue;
            }
            currentList.add(a[i]);
            helper(a, i + 1, ans, currentList);
            currentList.remove(currentList.size() - 1); 
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] a) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(a);
        helper(a, 0, ans, new ArrayList<>());
        return ans;
    }
}
