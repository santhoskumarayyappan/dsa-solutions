14-04-2025
[Question](https://leetcode.com/problems/group-anagrams/](https://leetcode.com/problems/roman-to-integer/))

```Java
class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanSymbolToValueMap = new HashMap<>();
        romanSymbolToValueMap.put('I', 1);
        romanSymbolToValueMap.put('V', 5);
        romanSymbolToValueMap.put('X', 10);
        romanSymbolToValueMap.put('L', 50);
        romanSymbolToValueMap.put('C', 100);
        romanSymbolToValueMap.put('D', 500);
        romanSymbolToValueMap.put('M', 1000);

        int value = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (romanSymbolToValueMap.get(s.charAt(i)) < romanSymbolToValueMap.get(s.charAt(i + 1))) {
                value -= romanSymbolToValueMap.get(s.charAt(i)); 
            } else {
                value += romanSymbolToValueMap.get(s.charAt(i));
            }
        }

        return value + romanSymbolToValueMap.get(s.charAt(s.length() - 1)); 
    }
}
```
