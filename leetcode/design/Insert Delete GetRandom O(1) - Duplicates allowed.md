04-06-2022
[Question](https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/)

* CornerCase : Removing previous occurence of an element which is also present in last 
* can be handled by removing index from current element to be removed at front itself
```
class RandomizedCollection {

    Random random;
    List<Integer> elements;
    Map<Integer, Set<Integer>> elementToIndicesMap;
    
    public RandomizedCollection() {
        random = new Random();
        elements = new ArrayList<>();
        elementToIndicesMap = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean present = elementToIndicesMap.containsKey(val);
        elementToIndicesMap.putIfAbsent(val, new HashSet<>());
        Set<Integer> indices = elementToIndicesMap.get(val);
        indices.add(elements.size());
        elements.add(val);
        return !present;
    }
    
    public boolean remove(int val) {
        boolean present = elementToIndicesMap.containsKey(val);
        if (present) {
            Set<Integer> indices = elementToIndicesMap.get(val);
            int index = indices.iterator().next();
            indices.remove(index);
            if (index + 1 != elements.size()) {
                Set<Integer> lastElementIndices = elementToIndicesMap.get(elements.get(elements.size() - 1));
                lastElementIndices.remove(elements.size() - 1);
                lastElementIndices.add(index);
                Collections.swap(elements, index, elements.size() - 1);
            }
            
            elements.remove(elements.size() - 1);
            if (indices.size() == 0) {
                elementToIndicesMap.remove(val);
            }
        }
        return present;
    }
    
    public int getRandom() {
        return elements.get(random.nextInt(elements.size()));
    }
}
```
