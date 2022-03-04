//04-03-2022
//https://leetcode.com/problems/di-string-match/




// lets say the String is of length 4  
// let first char be 'D', we need to put an integer in a[0] such that 
// it holds even if 3 'D' or 3 'I' comes after it.

// similary let first char be 'I', we need to put an integer in a[0] such that 
// it holds even if 3 'D' or 3 'I' comes after it.

// it ll be evident that we should put lowest possible number on seeing 'I' and greatest possible on 'D'


class Solution {
    public int[] diStringMatch(String s) {
        int[] a = new int[s.length() + 1];
        int l = 0, r = s.length();
        for (int i = 0; i < a.length; i++) {
            a[i] = (i == a.length - 1 || s.charAt(i) == 'I')? l++ : r--;
        }
        return a;
    }
}
