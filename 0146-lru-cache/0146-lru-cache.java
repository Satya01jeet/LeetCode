class Node{
    int key;
    int val;
    Node next;
    Node prev;
    Node(){}
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    private static Node head;
    private static Node tail;
    HashMap<Integer,Node> map;
    private static int capacity;

    private static void add(Node node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private static void deleteNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        deleteNode(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int val) {
        Node node = new Node(key,val);
        if(map.containsKey(key)){
            deleteNode(map.get(key));
            map.remove(key);
            add(node);
        }
        else{
            if(capacity > 0){
                add(node);
                capacity--;
            }
            else{
                Node toBeDeleted = tail.prev;
                deleteNode(toBeDeleted);
                map.remove(toBeDeleted.key);
                add(node);
            }
        }
        map.put(key,node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */