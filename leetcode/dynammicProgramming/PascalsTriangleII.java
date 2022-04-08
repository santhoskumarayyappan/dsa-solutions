//08-04-2022
//https://leetcode.com/problems/pascals-triangle-ii/


class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> nthRow = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            nthRow.add(0);
            for (int j = i; j >= 0; j--) {
                if (j == 0 || j == i) {
                    nthRow.set(j, 1);
                } else {
                    nthRow.set(j, nthRow.get(j) + nthRow.get(j - 1));
                }
            }
        }
        return nthRow;
    }
}
