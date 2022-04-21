//22-04-2022
//https://leetcode.com/problems/lru-cache/
// idea is given in Notes 

class LRUCache extends LinkedHashMap<Integer, Integer> {
    
    private int capacity;
    
    public LRUCache(int _capacity) {
        super(capacity, 0.75f, true);
        capacity = _capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
