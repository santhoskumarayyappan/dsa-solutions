//17-04-2022
//https://leetcode.com/problems/permutations-ii/



class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void helper(int[] nums, int index, List<List<Integer>> res) {
    
        if (index == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
        
        for (int i = index; i < nums.length; i++) {
               if (i != index && nums[i] != nums[i - 1] || i == index) {
                   swap(nums, i, index);
                   helper(nums, index + 1, res);
                   swap(nums, i, index);
               }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, ans);
        return ans;
    }
}
