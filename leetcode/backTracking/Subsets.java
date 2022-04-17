//17-04-2022
//https://leetcode.com/problems/subsets/



class Solution {
    
    public void helper(int[] nums, int start, List<Integer> subSet, List<List<Integer>> powerSet) {
        powerSet.add(new ArrayList<>(subSet));
        for (int i = start; i < nums.length; i++) {
            subSet.add(nums[i]);
            helper(nums, start + 1, subSet, powerSet);
            subSet.remove(subSet.size() - 1);
        }
    }
  
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        helper(nums, 0, subSet, powerSet);
        return powerSet;
    }
}
