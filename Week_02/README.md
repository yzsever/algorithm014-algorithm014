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
List<Integer> traversePath = new LinkedList<>();

// 前序遍历
private void preOrder(TreeNode root, List<Integer> traversePath) {
    if (root != null) {
        traversePath.add(root.val);
        preOrder(root.left, traversePath);
        preOrder(root.right, traversePath);
    }
}

// 中序遍历
private void inOrder(TreeNode root, List<Integer> traversePath) {
    if (root != null) {
        inOrder(root.left, traversePath);
        traversePath.add(root.val);
        inOrder(root.right, traversePath);
    }
}

// 后序遍历
private void postOrder(TreeNode root, List<Integer> traversePath) {
    if (root != null) {
        inOrder(root.left, traversePath);
        inOrder(root.right, traversePath);
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
#### 属性
- Graph(V, E)
- V-vertex：点
   - 度-入度和出度
   - 点与点之间：连通与否
- E-edge：边
    - 有向和无向（单行线）
    - 权重（边长）

#### 图的表示和分类
1. 无向无权图
2. 有向无权图
3. 无向有权图
4. 有向有权图

#### 常见算法
1. DFS
2. BFS
3. 拓扑排序[Topological Sorting](https://zhuanlan.zhihu.com/p/34871092)
4. 最短路径 Shortest Path[Dijkstra](https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158)
5. 最小生成树[Minimum Spanning Tree](https://www.bilibili.com/video/av84820276?from=search&seid=17476598104352152051)

#### 思考题:自己画一下有向有权图
![有向有权图](https://github.com/yzsever/algorithm014-algorithm014/blob/master/Week_02/00-Image/01-有向有权图.png?raw=true)

---

### 实战题目

#### 0817 Mon
|题目编号| 题目名称   | 难度  | 类型  |#1[实现/高票] | #2[优化] | #3[一天后]   | #4[一周后] | #5[面试前一周] |
|------ | ----      | ----  | ----  | ----                |----  |----  |----| ---- |
|[242](https://leetcode.com/problems/valid-anagram/)               |valid-anagram                |Easy  |HashTable|0817/0817|0817/0817|0818/0818|0825/ | |
|[49](https://leetcode.com/problems/group-anagrams/)               |vgroup-anagrams              |Medium|HashTable|0817/0817|0817/0817|0818/0818|0825/ | |
|[94](https://leetcode.com/problems/binary-tree-inorder-traversal/)|binary-tree-inorder-traversal|Medium|Tree     |0817/0817|0817/0817|0818/0818|0825/ | |


> 时间标注为：计划时间/实际执行时间

#### 0818 Tue
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|/    | 关于HashMap的小总结   | /  | HashMap |0818/ | | | | |
|[144](https://leetcode.com/problems/binary-tree-preorder-traversal/)  |binary-tree-preorder-traversal  |Medium|Tree |0818/0818|0818/0818|0819/0819|0826/ | |
|[590](https://leetcode.com/problems/n-ary-tree-postorder-traversal/)  |n-ary-tree-postorder-traversal  |Easy  |Tree |0818/0818|0818/0818|0819/0819|0826/ | |
|[589](https://leetcode.com/problems/n-ary-tree-preorder-traversal/)   |n-ary-tree-preorder-traversal   |Easy  |Tree |0818/0818|0818/0818|0819/0819|0826/ | |
|[1021](https://leetcode.com/problems/remove-outermost-parentheses/)   |remove-outermost-parentheses    |Easy  |Other|0818/0818|0818/0818|0819/0819|0826/ | |


#### 0819 Wed
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|/    |[自学HeapSort](https://www.geeksforgeeks.org/heap-sort/)   | /  | Heap |0819/ | | | | |
|[429](https://leetcode.com/problems/n-ary-tree-level-order-traversal/)|n-ary-tree-level-order-traversal|Medium|Tree |0819/0819|0819/0819|0820/ |0827/ | |
|[剑指Offer40](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)|最小的k个数                    |Easy  |Heap |0819/0819|0819/0819|0820/ |0827/ | | 
|[239](https://leetcode.com/problems/sliding-window-maximum/)|sliding-window-maximum                    |Hard  |Heap |0819/0819|X |X |X |X |
|[347](https://leetcode.com/problems/top-k-frequent-elements/)|top-k-frequent-elements                  |Medium|Heap |0819/0819|0819/0819|0820/ |0827/ | |
|[剑指Offer49](https://leetcode-cn.com/problems/chou-shu-lcof/)      |丑数                               |Medium|Heap |0819/0819|0819/0819|0820/ |0827/ | |

#### 0820 Thu
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[70](https://leetcode.com/problems/climbing-stairs/)               |climbing-stairs              |Easy  |Recursion|0820/ | | | | |
|[200](https://leetcode.com/problems/number-of-islands/)  |number-of-islands   |Medium|Graph    |0820/ | | | | |
|[22](https://leetcode.com/problems/generate-parentheses/) |generate-parentheses|Medium|Recursion     |0821/ | | | | |

#### 0821 Fri
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[110](https://leetcode.com/problems/balanced-binary-tree/)|balanced-binary-tree|Easy  |Recursion     |0821/ | | | | |
|[50](https://leetcode.com/problems/powx-n/)               |powx-n              |Medium|Divide&Conquer|0821/ | | | | |
|[78](https://leetcode.com/problems/subsets/)                |subsets  |Medium|Backtracking  |0822/ | | | | |

#### 0822 Sta
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[51](https://leetcode.com/problems/n-queens/)               |n-queens |Hard  |Backtracking  |0822/ | | | | |
|[647](https://leetcode.com/problems/palindromic-substrings/)|palindromic-substrings|Medium|DP |0822/ | | | | |
|[350](https://leetcode.com/problems/intersection-of-two-arrays-ii/)|intersection-of-two-arrays-ii|Easy  |Array|0820/ | | | | |


---

#### 课后作业：写一个关于HashMap的小总结(主要分析put和get方法的源代码)

**put方法**
```java
    /**
     * 该表在首次使用时初始化，并根据需要调整大小。分配时，长度始终是2的幂。
     * 数组，又叫作桶（bucket）
     */
    transient Node<K,V>[] table;

    /**
      * 将指定值与该映射中的指定键相关联。如果该映射先前包含该键的映射，则将替换旧值。
      *
      * @param key：与指定值关联的键
      * @param value：与指定键关联的值
      * @返回与{@code key}或{@code null}关联的先前值
     */
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    /**
      * 实现Map.put和相关方法。
      *
      * @param hash：键的哈希
      * @param key：键
      * @param value：放置值
      * @param onlyIfAbsent：如果为true，则不要更改现有值
      * @param evict：如果为false，则表处于创建模式。
      * @return：先前的值，如果没有则返回null
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }

    /**
     * 初始化或增加表大小。 如果为空，则根据字段阈值中保持的初始容量目标进行分配。
     * 否则，因为我们使用的是2的幂，所以每个bin中的元素必须保持相同的索引，或者在新表中以2的幂偏移。
     * @return the table
     */
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

    /**
     * 除非表太小，否则将替换给定哈希值的索引处bin中所有链接的节点，在这种情况下，将调整大小。
     */
    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();
        else if ((e = tab[index = (n - 1) & hash]) != null) {
            TreeNode<K,V> hd = null, tl = null;
            do {
                TreeNode<K,V> p = replacementTreeNode(e, null);
                if (tl == null)
                    hd = p;
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
            if ((tab[index] = hd) != null)
                hd.treeify(tab);
        }
    }



```

**get方法**
```java
    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
     * key.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     *
     * <p>A return value of {@code null} does not <i>necessarily</i>
     * indicate that the map contains no mapping for the key; it's also
     * possible that the map explicitly maps the key to {@code null}.
     * The {@link #containsKey containsKey} operation may be used to
     * distinguish these two cases.
     *
     * @see #put(Object, Object)
     */
    public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    /**
      * 实现Map.get和相关方法。
      *
      * @param hash：键的哈希
      * @param key：键
      * @return：节点，如果没有则为null
     */
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
```




参考文档：
1. Java10 Source Code
2. [死磕java集合之HashMap源码分析](https://juejin.im/post/6844903817855631373)

---