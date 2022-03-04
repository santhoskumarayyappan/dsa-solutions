//04-03-2022
//https://leetcode.com/problems/reverse-words-in-a-string-iii/



class Solution {
    
    public void swap(char[] ch, int i, int j) {
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
    }
    
    public void reverse(char[] ch, int i, int j) {
        while (i < j) {
            swap(ch, i, j);
            i++;
            j--;
        }
    }
    
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        int j = 0;
        while (i < ch.length) {
            // move till ch[j] = ' '
            while (j < ch.length && ch[j] != ' ') {
                j++;
            }
            // j - 1 to skip ' '
            reverse(ch, i, j - 1);
            // increment j to pass  ' '
            j++;
            i = j;
        }
        return new String(ch);
    }
}
