//04-03-2022
//https://leetcode.com/problems/reverse-prefix-of-word/



class Solution {
    
    public void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    
    public String reversePrefix(String word, char ch) {
        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            if (ch == word.charAt(i)) {
                index = i;
                break;
            }
        }
        char[] chArray = word.toCharArray();
        if (index != -1) {
            int i = 0;
            while (i < index) {
                swap(chArray, i, index);
                i++;
                index--;
            }
        }
        return new String(chArray);
    }
}
