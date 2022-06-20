20-06-2022
[Question](https://leetcode.com/problems/short-encoding-of-words/)

Insert into Trie in reverse of each string

* case 1 : ["abc", "aabc"]
when inserting "aabc", "abc" should be removed from length

* case 2 : ["aabc", "abc"]
when inserting "abc", it should nt be added to length

* case 3 " ["abc", "abc"]
when inserting second "abc", it should nt be added to length

```java
class Solution {
    TrieNode root;
    int lenOfRefString;
    int distinct;
    
    public int minimumLengthEncoding(String[] words) {
        root = new TrieNode();
        lenOfRefString = 0;
        distinct = 0;
        for (String word : words) {
            insert(root, word);
        }
        return lenOfRefString + distinct;
    }
    
    void insert(TrieNode root, String word) {
        char[] chArray = word.toCharArray();
        int curLen = 1;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = chArray[i];
            if (root.node[ch - 'a'] == null) {
                root.node[ch - 'a'] = new TrieNode();
                if (i == 0) {
                    lenOfRefString += word.length();
                    distinct++;
                    root.node[ch - 'a'].isEnd = true;
                }
            } else if (root.node[ch - 'a'].isEnd && i != 0) {
                    lenOfRefString -= curLen;
                    distinct--;
                    root.node[ch - 'a'].isEnd = false;
            }
            root = root.node[ch - 'a'];
            curLen++;
        }
    }
}

class TrieNode {
    TrieNode[] node;
    boolean isEnd;
    
    TrieNode() {
        this.node = new TrieNode[26];
    }
}
```
