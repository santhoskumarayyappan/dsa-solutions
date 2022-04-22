//22-04-2022
//https://leetcode.com/problems/lfu-cache

class LFUCache {

    class Node {
        int key;
        int value;
        int frequency;
        
        Node prev;
        Node next;
        
        Node(){}
        
        Node(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }
    
    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;
        
        DoublyLinkedList() {
            head = new Node(0, 0, 0);
            tail = new Node(0, 0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }   
        
        public Node addLast(Node node) {
            node.next = tail;
            node.prev = tail.prev;
            
            tail.prev.next = node;
            tail.prev = node;
    
            size++;            
            return node;            
        }
        
        public Node remove(Node node) {
            Node next = node.next;
            Node prev = node.prev;
            
            next.prev = prev;
            prev.next = next;
            
            size--;
            return node;
        }  
    }
    
    int minFrequency, capacity;
    Map<Integer, Node> keyToNodeMap;
    Map<Integer, DoublyLinkedList> frequencyToLRUListMap;

    public LFUCache(int capacity) {
        minFrequency = 0;
        this.capacity = capacity;
        keyToNodeMap = new HashMap<>();
        frequencyToLRUListMap = new HashMap<>();
    }
    
    public Node update(Node node) {
        DoublyLinkedList dll = frequencyToLRUListMap.get(node.frequency);
        dll.remove(node);

        if (dll.size == 0 && minFrequency == node.frequency) {
            minFrequency = minFrequency + 1;
        }

        node.frequency++;
        frequencyToLRUListMap.putIfAbsent(node.frequency, new DoublyLinkedList());
        DoublyLinkedList dllNext = frequencyToLRUListMap.get(node.frequency);
        dllNext.addLast(node);
        return node;
    }
    
    public int get(int key) {
        if (keyToNodeMap.containsKey(key)) {
            Node node = keyToNodeMap.get(key);
            update(node);            
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        if (keyToNodeMap.containsKey(key)) {
            Node node = keyToNodeMap.get(key);
            node.value = value;
            update(node);    
        } else {
            if (capacity == keyToNodeMap.size()) {
                DoublyLinkedList dll = frequencyToLRUListMap.get(minFrequency);
                keyToNodeMap.remove(dll.head.next.key);
                dll.remove(dll.head.next);
            }
            minFrequency = 1;
            Node node = new Node(key, value, 1);
            frequencyToLRUListMap.putIfAbsent(node.frequency, new DoublyLinkedList());
            DoublyLinkedList dll = frequencyToLRUListMap.get(minFrequency);
            dll.addLast(node);
            keyToNodeMap.put(key, node);
        }
    }
}
