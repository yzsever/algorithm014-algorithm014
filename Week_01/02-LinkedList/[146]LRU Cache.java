//Design and implement a data structure for Least Recently Used (LRU) cache. It 
//should support the following operations: get and put. 
//
// get(key) - Get the value (will always be positive) of the key if the key exis
//ts in the cache, otherwise return -1. 
//put(key, value) - Set or insert the value if the key is not already present. W
//hen the cache reached its capacity, it should invalidate the least recently used
// item before inserting a new item. 
//
// The cache is initialized with a positive capacity. 
//
// Follow up: 
//Could you do both operations in O(1) time complexity? 
//
// Example: 
//
// 
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
// 
//
// 
// Related Topics Design 
// 👍 6252 👎 265

package leetcode.editor.en;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)

// 1、使用java的LinkedHashMap
/*class LRUCache extends LinkedHashMap<Integer, Integer> {

    int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > capacity;
    }

}*/

// 2、使用哈希+双向链表
class Node{
    int key, value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class ListNode{

    Node head, end;

    public ListNode(){
        head = null;
        end = null;
    }

    public void insert(Node node){
        if(node == null){
            return;
        }
        if(head == null){
            head = end = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public Node deleteLast(){
        if(end == null){
            System.out.println("Null");
            return null;
        }
        Node tmp = end;
        end = end.prev;
        if(end != null) {
            end.next = null;
        }
        return tmp;
    }

    public void moveToHead(Node node){
        if(node == null || node.prev == null){
            return;
        }
        if(node == end){
            end = end.prev;
        }
        node.prev.next = node.next;
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;

    }
}


class LRUCache {

    Map<Integer, Node> map = new HashMap<>();
    ListNode listNode = new ListNode();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            listNode.moveToHead(node);
        } else {
            return -1;
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        // 元素不存在，添加新元素
        if (node == null) {
            node = new Node(key, value);
            // 容量不够用
            if (map.size() == capacity) {
                // 删除最久未被使用元素，再在队头插入新元素
                Node lastNode = listNode.deleteLast();
                map.remove(lastNode.key);
                lastNode = null;
            }
            listNode.insert(node);
            map.put(key, node);
        } else {
            // 元素存在，将元素找到修改value并移动到队头
            node.value = value;
            listNode.moveToHead(node);
        }
    }

}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
