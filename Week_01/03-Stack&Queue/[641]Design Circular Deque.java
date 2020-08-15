//Design your implementation of the circular double-ended queue (deque). 
//
// Your implementation should support following operations: 
//
// 
// MyCircularDeque(k): Constructor, set the size of the deque to be k. 
// insertFront(): Adds an item at the front of Deque. Return true if the operati
//on is successful. 
// insertLast(): Adds an item at the rear of Deque. Return true if the operation
// is successful. 
// deleteFront(): Deletes an item from the front of Deque. Return true if the op
//eration is successful. 
// deleteLast(): Deletes an item from the rear of Deque. Return true if the oper
//ation is successful. 
// getFront(): Gets the front item from the Deque. If the deque is empty, return
// -1. 
// getRear(): Gets the last item from Deque. If the deque is empty, return -1. 
// isEmpty(): Checks whether Deque is empty or not. 
// isFull(): Checks whether Deque is full or not. 
// 
//
// 
//
// Example: 
//
// 
//MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 
//3
//circularDeque.insertLast(1);			// return true
//circularDeque.insertLast(2);			// return true
//circularDeque.insertFront(3);			// return true
//circularDeque.insertFront(4);			// return false, the queue is full
//circularDeque.getRear();  			// return 2
//circularDeque.isFull();				// return true
//circularDeque.deleteLast();			// return true
//circularDeque.insertFront(4);			// return true
//circularDeque.getFront();			// return 4
// 
//
// 
//
// Note: 
//
// 
// All values will be in the range of [0, 1000]. 
// The number of operations will be in the range of [1, 1000]. 
// Please do not use the built-in Deque library. 
// 
// Related Topics Design Queue 
// 👍 261 👎 40

package leetcode.editor.en;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
// 1、使用java内置的LinkedList
/*class MyCircularDeque {

    int size;
    Deque<Integer> deque;

    *//**
     * Initialize your data structure here. Set the size of the deque to be k.
     *//*
    public MyCircularDeque(int k) {
        size = k;
        deque = new LinkedList<>();
    }

    *//**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     *//*
    public boolean insertFront(int value) {
        if (this.isFull()) {
            return false;
        }
        deque.addFirst(value);
        return true;
    }

    *//**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     *//*
    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        }
        deque.addLast(value);
        return true;
    }

    *//**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     *//*
    public boolean deleteFront() {
        if (this.isEmpty()) {
            return false;
        }
        deque.removeFirst();
        return true;
    }

    *//**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     *//*
    public boolean deleteLast() {
        if (this.isEmpty()) {
            return false;
        }
        deque.removeLast();
        return true;
    }

    *//**
     * Get the front item from the deque.
     *//*
    public int getFront() {
        if (this.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    *//**
     * Get the last item from the deque.
     *//*
    public int getRear() {
        if (this.isEmpty()) {
            return -1;
        }
        return deque.peekLast();
    }

    *//**
     * Checks whether the circular deque is empty or not.
     *//*
    public boolean isEmpty() {
        if (deque.size() == 0) {
            return true;
        }
        return false;
    }

    *//**
     * Checks whether the circular deque is full or not.
     *//*
    public boolean isFull() {
        if (deque.size() == size) {
            return true;
        }
        return false;
    }
}*/

//2、使用Array完成
// 1、使用java内置的LinkedList
class MyCircularDeque {

    int[] deque;
    int start, end;
    int capacity;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k+1;
        deque = new int[capacity];
        // 指向队首元素
        start = 0;
        // 指向队尾后一个位置，所以数组需要多一个位置
        end = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (this.isFull()) {
            return false;
        }
        start = (start - 1 + capacity) % capacity;
        deque[start] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        }
        deque[end] = value;
        end = (end + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (this.isEmpty()) {
            return false;
        }
        // start指针向后移动一位
        start = (start + 1) % capacity;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (this.isEmpty()) {
            return false;
        }
        // end指针向前移动一位
        end = (end - 1 + capacity) % capacity;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (this.isEmpty()) {
            return -1;
        }
        return deque[start];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (this.isEmpty()) {
            return -1;
        }
        // 返回end指针前一个元素
        return deque[(end - 1 + capacity) % capacity];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        // start和end指针指向同一个位置时，为空
        if (start == end) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        // end指针的下个位置为start指针时，队列满
        if ((end + 1) % capacity == start) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)
