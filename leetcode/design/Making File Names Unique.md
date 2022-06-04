04-06-2022
[Question](https://leetcode.com/problems/making-file-names-unique/)
```
class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> nameToCount = new HashMap<>();
        
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (nameToCount.containsKey(name)) {
                int count = nameToCount.get(name);
                while (nameToCount.containsKey(name + "(" + count + ")")) {
                    count++;  
                }   
                name = name + "(" + count + ")";
                nameToCount.put(names[i], count + 1); // so no need to search from start next time
                nameToCount.put(name, 1);
            } else {
                nameToCount.put(names[i], 1);
            }
            names[i] = name;
        }
        return names;
    }
}
```
