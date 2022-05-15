//https://leetcode.com/problems/minimum-window-substring/
//14-05-2022


class Solution {
    
    public boolean isMinWindowSubStr(Map<Character, Integer> a, Map<Character, Integer> b) {
        for (Map.Entry<Character, Integer> entry : b.entrySet()) {
            if (a.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
    
    public String minWindow(String s, String t) {
        Map<Character, Integer> sCharToCountMap = new HashMap<>();
        Map<Character, Integer> tCharToCountMap = new HashMap<>();
        
        for (Character ch : t.toCharArray()) {
            tCharToCountMap.merge(ch, 1, (a, b) -> a + b);
        }
        
        int i = 0, j = 0;
        char[] charArray = s.toCharArray();
        
        int minLength = Integer.MAX_VALUE;
        int start = -1, end = -2;
        
        while(j < charArray.length) {
            
            sCharToCountMap.merge(charArray[j], 1, (a, b) -> a + b);
            
            while (isMinWindowSubStr(sCharToCountMap, tCharToCountMap)) {
                if (minLength > j - i + 1) {
                    start = i;
                    end = j;
                    minLength = j - i + 1;
                }
                
                sCharToCountMap.merge(charArray[i], -1, (a, b) -> a + b);
                i++;   
                j++;
            }
        }
        StringBuilder builder = new StringBuilder();
        
        while (start <= end) {
            builder.append(charArray[start]);
            start++;
        }
        return builder.toString();
    }
}
