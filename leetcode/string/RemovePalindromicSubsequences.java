//05-03-2022
//https://leetcode.com/problems/remove-palindromic-subsequences/



// the idea is that if s is palindrome we can just remove it 
// or remove all 'a's at first then all 'b's
class Solution {
    public int removePalindromeSub(String s) {
        int l = 0, r = s.length() - 1;
        boolean isPalindrome = true;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            return 1;
        } else {
            return 2;
        }
    }
}
