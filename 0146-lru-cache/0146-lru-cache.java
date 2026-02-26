import java.util.*;

class LRUCache {

    class Node {
        int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    HashMap<Integer, Node> m = new HashMap<>();
    int limit;

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node node) {
        Node nextNode = head.next;

        head.next = node;
        node.prev = head;

        node.next = nextNode;
        nextNode.prev = node;
    }

    void delNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public int get(int key) {
        if (!m.containsKey(key)) {
            return -1;
        }

        Node node = m.get(key);
        delNode(node);
        addNode(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (m.containsKey(key)) {
            Node existing = m.get(key);
            delNode(existing);
            m.remove(key);
        }

        if (m.size() == limit) {
            Node lru = tail.prev;
            delNode(lru);
            m.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        m.put(key, newNode);
    }
}