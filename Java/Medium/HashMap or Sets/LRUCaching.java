import java.util.HashMap;
class LRUCache {
    
    class Node {
        int key, val;
        Node prev, next;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    int capacity;
    HashMap<Integer,Node> cache;
    Node head, tail;
    
    LRUCache(int cap) {
        // code here
        
        this.capacity = cap;
        this.cache = new HashMap<>();
        
        head = new Node(0,0);
        tail = new Node(0,0);
        
        head.next = tail;
        tail.prev = head;
    }
    
    void remove(Node n){
        Node np = n.prev;
        Node nn = n.next;
        np.next = nn;
        nn.prev = np;
    }
    
    void insertAtTail(Node n){
        Node tp = tail.prev;
        tp.next = n;
        n.prev = tp;
        n.next = tail;
        tail.prev = n;
    }

    public int get(int key) {
        //  code here
        if (!cache.containsKey(key)) return -1;
        
        Node n = cache.get(key);
        remove(n);
        insertAtTail(n);
        
        return n.val;
    }
        
    public void put(int key, int value) {
        //  code here
        
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            cache.remove(key);
        }
        
        Node n = new Node(key,value);
        insertAtTail(n);
        cache.put(key,n);
        
        if (cache.size() > capacity){
            Node lru = head.next;
            remove(lru);
            cache.remove(lru.key);
        }
        
    }
}
