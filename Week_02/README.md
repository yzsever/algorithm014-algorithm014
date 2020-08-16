学习笔记

## 第五课 哈希表、映射、集合

### 哈希表

哈希表(Hash table),也叫散列表，是根据关键码值(key-value)而直接进行访问的数据结构。它通过把关键码值映射到表中一个位置来访问记录，以加速查找的速度。

这个映射函数叫作**散列函数(Hash Function)**，存放记录的数组叫作**哈希表(或散列表)**;

**工程实践**
- 电话号码簿
- 用户信息表
- 缓存(LRU cache)
- 键值对存储(Redis)

#### Java code
1. [Map](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html):key-value对，key不重复
   - new HashMap()/new TreeMap()
   - map.put(key, value)
   - map.get(key)
   - map.containsKey(key)
   - map.size()
   - map.clear()
   
2. [Set](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html):不重复元素的集合
   - new HashSet()/new TreeSet()
   - set.add(value)
   - ser.remove(value)'
   - set.contains(value)

Tips:养成收藏精选代码的习惯


#### 课后作业：写一个关于HashMap的小总结(主要分析put和get方法的源代码)


---

## 第六课 树、二叉树、二叉搜索树

### 概念
1. Linked List是特殊化的Tree
2. Tree是特殊化的Graph

```java
// 树节点代码，必会
public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```

### 二叉树遍历
1. 前序(Pre-order):根-左-右
2. 中序(In-order):左-根-右
3. 后序(Post-order):左-右-根

> 前、中、后指的是根节点的在遍历顺序中的位置。

```java
// 三种遍历代码递归实现，必会
// 前序遍历
private void preOrder(TreeNode root) {
    LinkedList<Integer> traversePath = new LinkedList<>();
    if (root != null) {
        traversePath.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
// 中序遍历
private void inOrder(TreeNode root) {
    LinkedList<Integer> traversePath = new LinkedList<>();
    if (root != null) {
        inOrder(root.left);
        traversePath.add(root.val);
        inOrder(root.right);
    }
}
// 后序遍历
private void postOrder(TreeNode root) {
    LinkedList<Integer> traversePath = new LinkedList<>();
    if (root != null) {
        inOrder(root.left);
        inOrder(root.right);
        traversePath.add(root.val);
    }
}
```

### 二叉搜索树 Binary Search Tree
#### 定义
二叉搜索树，也称二叉排序树、有序二叉树(Ordered Binary Tree)、排序二叉树(Sorted Binary Tree)，
是指一棵空树或者具有下列属性的二叉树：
1. 左子树上**所有结点**的值均小于它的根结点的值；
2. 右子树上**所有结点**的值均大于它的根结点的值；
3. 以此类推：左、右子树也分别为二叉查找树。(**这就是重复性！**)
 
中序遍历: 升序排列

#### 常见操作
1. 查询
2. 插入新结点(创建)
3. 删除

#### 思考题:树的面试题解法一般都是递归，为什么？
1. 代码本身树的定义没有后继的结构/便于循环的结构，是左结点、右结点的结构。

---

## 第六课 堆(Heap)和二叉堆(Binary Heap)、图

### 堆(Heap)
#### 定义
Heap: 可以迅速找到一堆数中的最大或者最小值的数据结构

- 大顶/根堆：根节点最大的堆
   - find-max: O(1)
   - delete-max: O(logN)
   - insert(create): O(logN) or O(1)
- 小顶/根堆：根节点最小的堆

不同实现的比较(https://en.wikipedia.org/wiki/Heap_(data_structure))
- 二叉堆是堆(优先队列priority_queue)的一种常见且简单的实现，但是不是最优的实现


### 二叉堆(Binary Heap)
#### 性质
通过完全二叉数来实现(注意：不是二叉搜索数)
二叉堆(大顶)满足下列性质：
- 是一棵完全树
- 树中任意节点的值总是 >= 其子节点的值

#### 实现细节
1. 一般通过"数组"实现
2. 假设"第一个元素"在数组中的索引为0，则父节点和子节点的位置如下：
   - 索引为i的左孩子的索引是(2*i+1);
   - 索引为i的右孩子的索引是(2*i+2)；
   - 索引为i的父节点的索引是floor((i-1/2));
   
#### Insert插入操作
1. 新元素先插入到堆的**尾部**
2. HeapifyUp：依次向上调整整个堆的结构(一直到根即可)

#### Delete删除堆顶操作
1. 将堆尾元素替换到顶部
2. HeapifyDown：依次从根部向下调整整个堆的结构(一直到堆尾即可)   


### 图



---

### 实战题目

#### 0817 Mon
|题目编号| 题目名称   | 难度  | 类型  |#1[实现/高票] | #2[优化] | #3[一天后]   | #4[一周后] | #5[面试前一周] |
|------ | ----      | ----  | ----  | ----                |----  |----  |----| ---- |
|[242](https://leetcode.com/problems/valid-anagram/)               |valid-anagram                |Easy  |HashTable|0817/ | | | | |
|[49](https://leetcode.com/problems/group-anagrams/)               |vgroup-anagrams              |Medium|HashTable|0817/ | | | | |
|[94](https://leetcode.com/problems/binary-tree-inorder-traversal/)|binary-tree-inorder-traversal|Medium|Tree     |0817/ | | | | |


> 时间标注为：计划时间/实际执行时间

#### 0818 Tue
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|/    | 关于HashMap的小总结   | /  | HashMap |0817/ | | | | |
|[144](https://leetcode.com/problems/binary-tree-preorder-traversal/)  |binary-tree-preorder-traversal  |Medium|Tree |0818/ | | | | |
|[590](https://leetcode.com/problems/n-ary-tree-postorder-traversal/)  |n-ary-tree-postorder-traversal  |Easy  |Tree |0818/ | | | | |
|[589](https://leetcode.com/problems/n-ary-tree-preorder-traversal/)   |n-ary-tree-preorder-traversal   |Easy  |Tree |0818/ | | | | |


#### 0819 Wed
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|/    |[自学HeapSort](https://www.geeksforgeeks.org/heap-sort/)   | /  | Heap |0818/ | | | | |
|[429](https://leetcode.com/problems/n-ary-tree-level-order-traversal/)|n-ary-tree-level-order-traversal|Medium|Tree |0819/ | | | | |
|[剑指Offer40](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)|最小的k个数     |Easy  |Heap |0819/ | | | | 
|[239](https://leetcode-cn.com/problems/sliding-window-maximum/)|sliding-window-maximum  |Hard  |Heap |0819/ | | | | |


#### 0820 Thu
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[347](https://leetcode.com/problems/top-k-frequent-elements/)  |top-k-frequent-elements |Medium|Heap |0820/ | | | | |
|[剑指Offer49](https://leetcode-cn.com/problems/chou-shu-lcof/)|丑数             |Medium|Heap |0820/ | | | | |
|[]()    |      | Easy  | |0819/ | | | | |
|[]()    |      | Easy  | |0819/ | | | | |

#### 0821 Fri
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[200](https://leetcode.com/problems/number-of-islands/)      |number-of-islands|Medium|Graph|0821/ | | | | |
|[]()    |      | Easy  | |0821/ | | | | |
|[]()    |      | Easy  | |0821/ | | | | |
|[]()    |      | Easy  | |0821/ | | | | |

#### 0822 Sta
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[]()    |      | Easy  | |0822/ | | | | |
|[]()    |      | Easy  | |0822/ | | | | |
|[]()    |      | Easy  | |0822/ | | | | |
|[]()    |      | Easy  | |0822/ | | | | |

