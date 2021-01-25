class LRUCache {
    /*
    * 1. test
    * 2. data structure, algo
            HashMap, Double LinkedList
    * 3. logic
    * 4. result
    * 5. test, analysis
    * ===========================
    * {1: 1,
       2: 2,
       3: 3,
      } capacity 3
    * get(2)
        {1:1,
         3:3,
        2:2}
    put(4, 4)
      {3: 3,
      2: 2,
      4: 4}
    * =============================
       get()
       if (key in map) {
           //remove node from double linkedlist
           //add node to head of double lined list
           //get the value from the map
       } else {
       return -1;
       }
       =======================
       put(key, value) {
           if key in map {
               remove node from DL
               add node to head of DL
               update value in map
           } else {
             //new key
             if (map.size == capacity)
                remove the last node in DL,the node before tail
             //add a new node to head 
             //put into map
           }
       }
       ====================
       implement 
       remove(), add()
       Node class
      
    */
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    HashMap<Integer, Node> map;
    Node head = new Node();//dummy node
    Node tail = new Node();//dummy node
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        
    }
    
    public int get(int key) {
        int result = -1;
        Node cur = map.get(key);
        if (cur != null) {
            remove(cur);
            add(cur);
            result = cur.value;
        }
        
        return result;
        
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        
        if (node != null) {
            
            node.value = value;
            remove(node);
            add(node);
        } else {
            if (map.size() == capacity) {
                //remove the last node
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node tmp = new Node();
            tmp.key = key;
            tmp.value = value;
            add(tmp);
            map.put(key, tmp);
        }
    }
    
    public void add(Node node) {
        Node head_next = head.next;
        head.next = node;
        node.next = head_next;
        head_next.prev = node;
        node.prev = head;
        
    }
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */