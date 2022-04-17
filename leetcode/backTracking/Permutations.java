//17-04-2022
//https://leetcode.com/problems/permutations/


class Solution {
    public List<List<Integer>> permute(int[] a) {
        List<List<Integer>> result = new ArrayList<>();
        helper(a, 0, result);
        return result;
    }
    
    public void helper(int[] a, int start, List<List<Integer>> result) {
        
        if (start == a.length - 1) {
            result.add(Arrays.stream(a).boxed().collect(Collectors.toList()));  
        } else {
            for(int i = start; i < a.length; i++) {
                swap(a, start, i);
                helper(a, start + 1, result);
                swap(a, start, i);
            }
        } 
    }
    
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
