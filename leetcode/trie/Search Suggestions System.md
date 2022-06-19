19-06-2022
[Question](https://leetcode.com/problems/search-suggestions-system/)
```java

class Solution {
    TrieNode root;
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
       TrieNode root = new TrieNode();
        for (String product : products) {
            root.insert(root, product);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            ans.add(root.find(root, searchWord.substring(0, i)));
        } 
        return ans;
    }
}

class TrieNode {
    TrieNode[] node;
    boolean isEnd;
    TrieNode() {
        node = new TrieNode[26];
    }
    
    public void insert(TrieNode root, String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.node[ch - 'a'] == null) {
                cur.node[ch - 'a'] = new TrieNode();
            } 
            cur = cur.node[ch - 'a'];
        }
        cur.isEnd = true;
    }
    
    public void add(TrieNode root, StringBuilder sb, List<String> suggestions) {
        if (suggestions.size() == 3) {
            return;
        }
        if (root.isEnd) {
            suggestions.add(sb.toString());
        } 
        for (int i = 0; i < 26; i++) {
            if (root.node[i] != null) {
                sb.append((char)(i + 'a'));
                add(root.node[i], sb, suggestions);
                sb.setLength(sb.length() - 1);
            }
        }
    }
    
    public List<String> find(TrieNode root, String searchWord) {
        TrieNode cur = root;
        List<String> suggestions = new ArrayList<>();
        for (char ch : searchWord.toCharArray()) {
            cur = cur.node[ch - 'a'];
            if (cur == null) {
                return suggestions;
            }
        }
        add(cur, new StringBuilder(searchWord), suggestions);
        return suggestions;
    }
}
```
