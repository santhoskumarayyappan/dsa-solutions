03-06-2022
[Question](https://leetcode.com/problems/insert-delete-getrandom-o1/)

 * The idea is to keep hashmap for O(1) insert, remove
 and list of elements to getRandom in O(1)
 * when adding into map, put value as its index in List
 so when deleting a val, just get index from Map
 swap it with last element and delete last element
 * One corner case : when deleting last element of List dont insert into map again
```
class RandomizedSet {

    Map<Integer, Integer> elementToIndexMap;
    List<Integer> elements;
    
    public RandomizedSet() {
        elementToIndexMap = new HashMap<>();
        elements = new ArrayList<>();
    }
    
    public boolean insert(int val) {  
        if(elementToIndexMap.containsKey(val)) {
            return false;
        }
        elementToIndexMap.put(val, elements.size());
        elements.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(elementToIndexMap.containsKey(val)) {
            int index = elementToIndexMap.remove(val);
            if (elements.size() != index + 1) { // if removed last element dont insert again
                elementToIndexMap.put(elements.get(elements.size() - 1), index);
            }
            Collections.swap(elements, index, elements.size() - 1);
            elements.remove(elements.size() - 1);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(elements.size());
        return elements.get(index);
    }
}
```
