09-06-2022
[Question](https://leetcode.com/problems/group-anagrams/)

```Java
class Solution {
    public String getKey(String s1) {
        int[] charToCountMap = new int[26];
        for (char ch : s1.toCharArray()) {
            charToCountMap[ch - 'a']++;
        }
        return Arrays.toString(charToCountMap);
        
    } 
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        boolean[] picked = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String key = getKey(strs[i]);
            anagramMap.putIfAbsent(key, new ArrayList<>());
            anagramMap.get(key).add(strs[i]);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
```
