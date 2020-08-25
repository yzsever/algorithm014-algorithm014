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
|[242](https://leetcode.com/problems/valid-anagram/)               |valid-anagram                |Easy  |HashTable|0817/0817|0817/0817|0818/0818|0825/0825| |
|[49](https://leetcode.com/problems/group-anagrams/)               |vgroup-anagrams              |Medium|HashTable|0817/0817|0817/0817|0818/0818|0825/0825| |
|[94](https://leetcode.com/problems/binary-tree-inorder-traversal/)|binary-tree-inorder-traversal|Medium|Tree     |0817/0817|0817/0817|0818/0818|0825/0825| |


> 时间标注为：计划时间/实际执行时间

#### 0818 Tue
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|/    | 关于HashMap的小总结   | /  | HashMap |0818/0819 | | | | |
|[144](https://leetcode.com/problems/binary-tree-preorder-traversal/)  |binary-tree-preorder-traversal  |Medium|Tree |0818/0818|0818/0818|0819/0819|0826/ | |
|[590](https://leetcode.com/problems/n-ary-tree-postorder-traversal/)  |n-ary-tree-postorder-traversal  |Easy  |Tree |0818/0818|0818/0818|0819/0819|0826/ | |
|[589](https://leetcode.com/problems/n-ary-tree-preorder-traversal/)   |n-ary-tree-preorder-traversal   |Easy  |Tree |0818/0818|0818/0818|0819/0819|0826/ | |
|[1021](https://leetcode.com/problems/remove-outermost-parentheses/)   |remove-outermost-parentheses    |Easy  |Other|0818/0818|0818/0818|0819/0819|0826/ | |


#### 0819 Wed
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|/    |[自学HeapSort](https://www.geeksforgeeks.org/heap-sort/)   | /  | Heap |0819/ | | | | |
|[429](https://leetcode.com/problems/n-ary-tree-level-order-traversal/)|n-ary-tree-level-order-traversal|Medium|Tree |0819/0819|0819/0819|0820/0820|0827/ | |
|[剑指Offer40](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)|最小的k个数  |Easy  |Heap |0819/0819|0819/0819|0820/0820|0827/ | | 
|[239](https://leetcode.com/problems/sliding-window-maximum/)|sliding-window-maximum  |Hard  |Heap |0819/0819|X |X |X |X |
|[347](https://leetcode.com/problems/top-k-frequent-elements/)|top-k-frequent-elements|Medium|Heap |0819/0819|0819/0819|0820/0820|0827/ | |
|[264](https://leetcode.com/problems/ugly-number-ii//)        |ugly-number-ii         |Medium|Heap |0819/0819|0819/0819|0820/0820|0827/ | |

#### 0820 Thu
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[70](https://leetcode.com/problems/climbing-stairs/)     |climbing-stairs     |Easy  |Recursion|0820/0820|0820/0820|0821/0821|0828/ |
|[200](https://leetcode.com/problems/number-of-islands/)  |number-of-islands   |Medium|Graph    |0820/0820|0820/0820|0821/0821|0828/ |
|[22](https://leetcode.com/problems/generate-parentheses/)|generate-parentheses|Medium|Recursion|0820/0820|0820/0820|0821/0821|0828/ |
|[412](https://leetcode.com/problems/fizz-buzz/)          |fizz-buzz           |Easy  |HashTable|0820/0820|0820/0820|0821/0821|0828/ |


#### 0822 Sta
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[110](https://leetcode.com/problems/balanced-binary-tree/)         |balanced-binary-tree         |Easy  |Recursion      |0822/0822|0822/0822|0823/0823|0830/ | |
|[258](https://leetcode.com/problems/add-digits/)                   |add-digits                   |Easy  |Recursion      |0822/0822|0822/0822|0823/0823|0830/ | |
|[647](https://leetcode.com/problems/palindromic-substrings/)       |palindromic-substrings       |Medium|DP             |0822/0822|0822/0822|0823/0823|0830/ | |
|[350](https://leetcode.com/problems/intersection-of-two-arrays-ii/)|intersection-of-two-arrays-ii|Easy  |Array,HashTable|0822/0822|0822/0822|0823/0823|0830/ | |

---

本周总结：
首先，很开心又坚持下来了！给自己鼓掌！
本周的课程相关的总题量有所减少，后面几天的题目以预习+群里老师推荐+每周推荐进行补充。从本周开始，要增加复刷上周的题目，按每天的题量为3-4题计算，之后的每天题量都会维持在10-12的样子。目前每天的刷题时间差不多快有6个小时，同时如果工作繁忙的情况下会有不小的压力。目前采取动态调整计划的方式，每周留一定的可调整时间用于完成计划。课程的学习在周日完成，做好学习总结并安排下周计划。接下来据说最难坚持的第3周和第4周加油！

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
        // 如果桶的数量为0，则初始化
        if ((tab = table) == null || (n = tab.length) == 0)
            // 调用resize()初始化
            n = (tab = resize()).length;
        // (n - 1) & hash 确定元素放在哪个桶中，如果桶为空，则放在桶中第一个位置
        if ((p = tab[i = (n - 1) & hash]) == null)
            // 新建一个节点放在桶中
            tab[i] = newNode(hash, key, value, null);
        else { // 桶不为空
            Node<K,V> e; K k;
            // 判断桶中第一个元素key和待插入的key相同
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                // 用于后续统一修改val
                e = p;
            // 不是桶的第一元素后，需要判断当前的存储结构是链表还是红黑树，以便于遍历查找待插入元素的位置
            // 第一元素是树节点，调用putTreeVal方法插入元素  
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                // 不是树节点，则是链表存储
                // binCount统计链表的长度，用于判断链表是否需要树化
                for (int binCount = 0; ; ++binCount) {
                    // 遍历结束，未找到相同k的元素，在链表最后插入一个新节点
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        // 如果链表长度达到树化门槛，则需要树化
                        // 因为第一个元素没有加到binCount中，所以减1
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    // 找到了和待插入元素相同key的元素，结束循环
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                // 判断是否需要替换旧值
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                // 返回旧值
                return oldValue;
            }
        }
        // 未找到元素
        ++modCount;
        // 元素数量加1，判断是否需要扩容
        if (++size > threshold)
            // 扩容
            resize();
        afterNodeInsertion(evict);
        return null;
    }

```

put方法的主要流程如下：
1. 判断桶即table数组为空，初始化桶。
   - 直接插入元素
2. 查找key所在的桶中key与待插入的key相同的元素
   - 判断key所在的桶中的第一个元素的key是否与待插入的key相同
   - 树存储结构，调用putTreeVal()寻找元素或插入元素
   - 遍历链表查找
      - 如果未找到元素，则在链表最后插入一个新节点，再判断链表是否需要树化
3. 如果找到了对应的key元素
   - 判断是否需要替换旧值，并返回旧值
4. 如果插入了元素，则数量加1，判断table是否需要扩容



```java
    /**
     * 初始化或增加表大小。 如果为空，则根据字段阈值中保持的初始容量目标进行分配。
     * 否则，因为我们使用的是2的幂，所以每个bin中的元素必须保持相同的索引，或者在新表中以2的幂偏移。
     * @return the table
     */
    final Node<K,V>[] resize() {
        // 旧数组
        Node<K,V>[] oldTab = table;
        // 旧容量
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        // 旧扩容门槛
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            // 已达到最大容量，不需要扩容
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            // 旧容量的两倍小于最大容量，同时旧容量大于等于默认初始容量
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                // 扩容门槛变成两倍
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            // 使用非默认构造方法创建的map，第一次插入元素会走到这里
            // 如果旧容量为0且旧扩容门槛大于0，则把新容量赋值为旧门槛
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            // 调用默认构造方法创建的map，第一次插入元素会走到这里
            // 如果旧容量旧扩容门槛都是0，说明还未初始化过，则初始化容量为默认容量，扩容门槛为默认容量*默认装载因子
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        // 如果新扩容门槛为0，则计算为容量*装载因子，但不能超过最大容量
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        // 更新扩容门槛
        threshold = newThr;
        // 新建一个新容量的数组
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        // 旧数组不为空，搬移元素
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        // 如果第一个元素是树节点，则把这颗树打散成两颗树插入到新桶中去
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        // 如果这个链表不止一个元素且不是一颗树
                        // 则分化成两个链表插入到新的桶中去
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            // (e.hash & oldCap) == 0的元素放在低位链表中
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                // (e.hash & oldCap) != 0的元素放在高位链表中
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        // 遍历完成分化成两个链表了
                        // 低位链表在新桶中的位置与旧桶一样
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        // 高位链表在新桶中的位置正好是原来的位置加上旧容量
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
            // 如果桶数量小于MIN_TREEIFY_CAPACITY时，直接扩容。扩容之后，链表会分化成两个链表，达到减少元素的作用
            resize();
        else if ((e = tab[index = (n - 1) & hash]) != null) {
            // 将节点转换成树节点
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
            // 执行树化
            if ((tab[index] = hd) != null)
                hd.treeify(tab);
        }
    }



```

**get方法**
```java
    /**
     * 返回指定键所映射到的值；如果此映射不包含键的映射关系，则返回{@code null}。
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
        // 桶数组不为空，并且查找元素key所在桶的第一个元素不为null
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            // 判断桶内第一个元素的key是否与查找元素相同，如果是，直接返回
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            // 桶内超过1个元素时，遍历查找
            if ((e = first.next) != null) {
                // 第一个元素是树节点，调用getTreeNode进行查找
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                // 链表结构时，遍历链表查找元素
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

get方法的主要流程如下：
1. 判断桶即table数组不为空，并且key所在桶内的第一个元素不为空
2. 判断第一个元素是否是查找元素，是则返回
3. 如果第一个元素是树节点，则调用getTreeNode查找
4. 否则遍历链表进行查重


参考文档：
1. Java10 Source Code
2. [死磕java集合之HashMap源码分析](https://juejin.im/post/6844903817855631373)

---

####  课后作业：[HeapSort自学](https://www.geeksforgeeks.org/heap-sort/)

```java

// Java program for implementation of Heap Sort
public class HeapSort
{
    public void sort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}

```


---