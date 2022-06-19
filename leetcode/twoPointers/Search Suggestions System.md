19-06-2022
[Question](https://leetcode.com/problems/search-suggestions-system/)


```java
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int l = 0, h = products.length - 1;
        List<List<String>> suggestedProducts = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
                while (l <= h && (i >= products[l].length() || searchWord.charAt(i) > products[l].charAt(i))) {
                    l++;
                }
                while (l <= h && (i >= products[h].length() || searchWord.charAt(i) < products[h].charAt(i))) {
                    h--;
                }
                List<String> curSuggestedProducts = new ArrayList<>();
                for (int k = l; k < Math.min(l + 3, h + 1); k++) {
                    curSuggestedProducts.add(products[k]);
                }
            suggestedProducts.add(curSuggestedProducts);
        }
        return suggestedProducts;
    }
}
```
