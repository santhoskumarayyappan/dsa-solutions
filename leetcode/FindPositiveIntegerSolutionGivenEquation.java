//01-04-2022
//https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/



class Solution {
    public int search(CustomFunction customfunction, int z, int x) {
        int left = 1, right = z;
        while (left <= right) {
            int y = left + (right - left) / 2;
            int val = customfunction.f(x, y);
            if (val == z) {
                return y;
            } else if (val < z) {
                left = y + 1;
            } else {
                right = y - 1;
            }
        }
        return -1;
    }
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int x = 1; x <= z; x++) {
            int y = search(customfunction, z, x);
            if (y != -1) {
                ans.add(Arrays.asList(x, y));
            }
        }
        return ans;
    }
}
