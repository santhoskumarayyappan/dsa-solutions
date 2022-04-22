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


// Without LinkedHashMapclass LRUCache {
    
    private Map<Integer, Node> keyToNodeMap;
    private LinkedList<Node> list;
    private int capacity;
    private Node head, tail;
    

    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        
        Node() {}
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    

    public LRUCache(int capacity) {
        keyToNodeMap = new HashMap<>();
        list = new LinkedList<>();
        this.capacity = capacity;
        
        head = new Node(0, 0);
        tail = new Node(0, 0);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public void addLast(Node node) {
        
        node.next = tail;
        node.prev = tail.prev;
        
        tail.prev.next = node;
        tail.prev = node;
        
    }
    
    public Node remove(Node node) {
        
        Node next = node.next;
        Node prev = node.prev;
        
        next.prev = prev;
        prev.next = next;
        
        return node;        
    }
    
    public Node pollFirst() {
        return remove(head.next);
    }
    
    public void moveToLast(Node node) {
        remove(node);
        addLast(node);        
    }
    
    public int get(int key) {
        if (keyToNodeMap.containsKey(key)) {
            Node node = keyToNodeMap.get(key);  
            moveToLast(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (keyToNodeMap.containsKey(key)) {
            Node node = keyToNodeMap.get(key);
            node.value = value;
            moveToLast(node);
        } else {
            if (capacity == keyToNodeMap.size()) {
                Node node = pollFirst();
                keyToNodeMap.remove(node.key);
            }
            Node node = new Node(key, value);
            addLast(node);
            keyToNodeMap.put(key, node);
        }
    }
}
