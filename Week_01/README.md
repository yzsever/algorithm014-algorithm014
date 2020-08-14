学习笔记

## 如何高效学习算法训练营课程

### 三分看视频理解、七分练习
1. 视频：1.5～2.0倍数播放、难点（暂停+反复）
2. 实践尝试：2倍速看完，难点或者觉得重要的点结合PPT做笔记，如果思考后又不理解的地方再回看视频对应位置直到弄懂。

---

## 第一课 数据结构与算法总览

### 参考书： 《Outliers：The Story of Success》

### 精通一个领域
- Chunk it up 切碎知识点
- Delibrerate Practicing 刻意练习
- Feedback 反馈

### 切题四件套
- Clarification 理解题目
- Possible solution 列出所有的解法
   - compare(time/space) 根据时间和空间复杂度对比算法
   - optimal(加强)
- Coding(多写)
- Test Cases 设计测试用例检验

### 五步刷题法/五毒神掌
- 第一遍
   - 5分钟～10分钟读题+思考
   - 无思路后，直接看解法：注意！多解法，比较解法优劣
   - 背诵、默写好的解法
- 第二遍
   - 马上自己写，LeetCode提交
   - 多种解法比较、体会，再优化！
- 第三遍
   - 过了一天后，再重复做题
   - 不同解法的熟练程度->专项练习
- 第四遍
   - 过了一周：反复回来练习相同题目
- 第五周
   - 面试前一周恢复性训练

> 至少刷五遍，可以根据自己的感觉增加次数

---

## 第二课 训练准备和复杂度分析

### 电脑环境配置
- Google
- Java: IntelliJ （学习Top tips）
- Leetode plugin

### 时间复杂度、空间复杂度
#### Big O notation
- O(1)：Constant Complexity 常数复杂度
- O(log n): Logarithmic Complexity 对数复杂度
- O(n): Linear  Complexity 线性时间复杂度
- O(n^2): N square Complexity 平方
- O(n^3): N cubic Complexity 立方
- O(2^n):Exponential Growth 指数
- O(n!): Factorial 阶乘

注意：只看最高复杂度的运算

---

## 第三课 数组、链表、跳表
### 基本实现和特性
#### 数组
**时间复杂度**
- prepend  O(1)
- append   O(1)
- lookup   O(1)
- **insert O(n)**
- **delete O(n)**

#### 链表
**时间复杂度**
- prepend  O(1)
- append   O(1)
- **lookup   O(n)**
- insert O(1)
- delete O(1)

#### 跳表
1. 限制：只能用于元素有序的情况
2. 特点：原理简单、容易实现、方便扩展、效率更高
3. 用途：替代平衡树，如：Redis、LevelDB等
4. 实现方法：添加多级索引

**时间复杂度**
- prepend  O(logn)
- append   O(logn)
- lookup   O(logn)
- insert O(logn)
- delete O(logn)

### 实战题目

#### Array
|题目编号| 题目名称   | 难度| #1[实现/高票] | #2[优化] | #3[一天后]   | #4[一周后] | #5[面试前一周] |
|------ | ----      | ----|----                |----  |----  |----| ---- | 
|[11](https://leetcode.com/problems/container-with-most-water/)|container-with-most-water | Medium |0810/0810|0810/0810|0811/0811|0818/|  |
|[283](https://leetcode.com/problems/move-zeroes/)             |move-zeroes               | Easy   |0810/0810|0810/0810|0811/0811|0818/|  |
|[70](https://leetcode.com/problems/climbing-stairs/)          |climbing-stairs           | Easy   |0810/0810|0810/0810|0811/0811|0818/|  |
|[15](https://leetcode.com/problems/3sum/)                     |3sum                      | Medium |0810/0810|0810/0810|0811/0811|0818/|  |

> 时间标注为：计划时间/实际执行时间

#### Linked List
|题目编号| 题目名称   | 难度| #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ----|----                |----  |----  |----| ---- | 
|[206](https://leetcode.com/problems/reverse-linked-list/)    |reverse-linked-list      | Easy  |0811/0811|0811/0811|0812/0812|0819/ | |
|[24](https://leetcode.com/problems/swap-nodes-in-pairs/)     |swap-nodes-in-pairs      | Medium|0811/0811|0811/0811|0812/0812|0819/ | |
|[141](https://leetcode.com/problems/linked-list-cycle/)      |linked-list-cycle        | Easy  |0811/0811|0811/0811|0812/0812|0819/ | | 
|[142](https://leetcode.com/problems/linked-list-cycle-ii/)   |linked-list-cycle-ii     | Medium|0811/0811|0811/0811|0812/0812|0819/ | | 
|[25](https://leetcode.com/problems/reverse-nodes-in-k-group/)|reverse-nodes-in-k-group | Hard  |0812/0812|0812/0812|0813/0813|0820/ | |  

---

## 第四课 栈、队列、双端队列、优先队列
### 栈和队列的基本实现和特性
- Stack：先入后出；添加、删除皆为O(1)，查找O(n)
- Queue: 先入先出；添加、删除皆为O(1)，查找O(n)
- Deque（Double-End Queue）：添加、删除皆为O(1)
- Priority Queue: 
   - 插入O(1), 取出O(logN):按元素的优先级取出
   - 底层具体实现的数据结构较为多样和复杂：heap、bst、treap
   
### 复杂度分析

![Image of complexity](https://github.com/yzsever/algorithm014-algorithm014/blob/master/Week_01/00-Image/01-complexity.png?raw=true)

### 课后作业1 [0812/0811]
**用add first或add last这套新的API改写Deque的代码**

**原代码**
```java

        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop()); }
        System.out.println(deque);
```

Comparison of Stack and Deque methods

| Stack Method    | Equivalent Deque Method   |
| --------   | -------  |
| push(e)      | addFirst(e)  |
| pop()        |   removeFirst()   |
| peek()       |    peekFirst()    |


**用add first或add last这套新的API改写Deque的代码**
```java
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.removeFirst()); }
        System.out.println(deque);
```

### 课后作业2 [0812/0812]
**分析Queue和Priority Queue的源码**

**Queue**是接口，提供了插入，提取和检查操作。这些方法中的每一种都以两种形式存在：一种在操作失败时引发异常，另一种返回一个特殊值（根据操作而为null或false）

|Method|Throws exception|	Returns special value|
|------|------|------|
|Insert|add(e)|	offer(e)|
|Remove|remove()|poll()|
|Examine|element()|peek()|


**Priority Queue**是Queue接口的一种实现，是基于优先级堆的无界优先级队列。
> ** 以下分析基于jdk8源码 **

#### 定义
```java
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    transient Object[] queue;
    private static final int MAX_ARRAY_SIZE = 2147483639;
```
- 队列保存在无序列化的数组中，设置了默认容量和最大容量

#### 添加
```java
    public boolean add(E e) {
        //  调用offer(e)
        return this.offer(e);
    }

    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException();
        } else {
            ++this.modCount;
            int i = this.size;
            if (i >= this.queue.length) {
                this.grow(i + 1);
            }
            this.size = i + 1;
            if (i == 0) {
                this.queue[0] = e;
            } else {
                this.siftUp(i, e);
            }
            return true;
        }
    }
```
- add和offer方法实现一致，都不允许null元素并抛出空指针异常
- 队列容量不足时，将调用grow方法进行扩容
- 添加元素时调用siftUp方法加入元素并调整堆

#### 扩容
```java
    private void grow(int minCapacity) {
        int oldCapacity = this.queue.length;
        int newCapacity = oldCapacity + (oldCapacity < 64 ? oldCapacity + 2 : oldCapacity >> 1);
        if (newCapacity - 2147483639 > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        this.queue = Arrays.copyOf(this.queue, newCapacity);
    }
	
```
- 根据当前容量大小进行2倍或者1.5倍扩容
- 扩容操作执行为建立新容量的数组


#### 删除

```java
    public boolean remove(Object o) {
        int i = this.indexOf(o);
        if (i == -1) {
            return false;
        } else {
            this.removeAt(i);
            return true;
        }
    }

    private E removeAt(int i) {
        ++this.modCount;
        int s = --this.size;
        if (s == i) {
            this.queue[i] = null;
        } else {
            E moved = this.queue[s];
            this.queue[s] = null;
            this.siftDown(i, moved);
            if (this.queue[i] == moved) {
                this.siftUp(i, moved);
                if (this.queue[i] != moved) {
                    return moved;
                }
            }
        }
        return null;
    }

    public E poll() {
        if (this.size == 0) {
            return null;
        } else {
            int s = --this.size;
            ++this.modCount;
            E result = this.queue[0];
            E x = this.queue[s];
            this.queue[s] = null;
            if (s != 0) {
                this.siftDown(0, x);
            }
            return result;
        }
    }
```
-  remove删除指定的元素
-  poll删除队首元素并返回
-  remove和poll方法的思想类似，都是取出要删除的queue[i]元素，然后调用siftDown方法将最后一个元素插入到queue[i]下沉调整堆结构。removeAt方法中下沉失败时，执行上浮操作

#### 获取队首元素

```java
 public E peek() {
        return this.size == 0 ? null : this.queue[0];
 }
```
- 直接返回队首元素，不改变队列本身 
- 无element方法实现，被废弃

### Stack & Queue

|题目编号| 题目名称   | 难度| #1 | #2 | #3 | #4 | #5 
|------ | ----      | ----|----                |----  |----  |----| ---- | 
|[20](https://leetcode.com/problems/valid-parentheses/)             |valid-parentheses             | Easy  |0812/0812|0812/0812|0813/0813|0820/ | |   
|[155](https://leetcode.com/problems/min-stack/)                    |min-stack                     | Easy  |0812/0812|0812/0812|0813/0813|0820/ | |   
|[84](https://leetcode.com/problems/largest-rectangle-in-histogram/)|largest-rectangle-in-histogram| Hard  |0813/0813|0813/0813|0814/0814|0821/ | | 
|[239](https://leetcode.com/problems/sliding-window-maximum/)       |sliding-window-maximum        | Hard  |0813/0813|0813/0813|0814/0814|0821/ | |

---

#### Weekly Homework
|题目编号| 题目名称   | 难度| #1 | #2 | #3 | #4 | #5 
|------ | ----      | ----|----                |----  |----  |----| ---- | 
|[26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)|remove-duplicates-from-sorted-array| Easy  |0813/0813|0813/0813|0814/0814|0821/ | |  
|[189](https://leetcode.com/problems/rotate-array/ )                     |rotate-array                       | Easy  |0813/0813|0813/0813|0814/0814|0821/ | |  
|[21](https://leetcode.com/problems/merge-two-sorted-lists/)             |merge-two-sorted-lists             | Easy  |0814/0814|0814/0814|0815/ |0822/ | |   
|[88](https://leetcode.com/problems/merge-sorted-array/)                 |merge-sorted-array                 | Easy  |0814/0814|0814/0814|0815/ |0822/ | |   
|[1](https://leetcode.com/problems/two-sum/)                             |two-sum                            | Easy  |0814/0814|0814/0814|0815/ |0822/ | |
|[283](https://leetcode.com/problems/move-zeroes/ )同实战                 |move-zeroes                        | Easy  |/      | /| /| /| /| /| 
|[66](https://leetcode.com/problems/plus-one/)                           |plus-one                           | Easy  |0814/0814|0814/0814|0815/ |0822/ | |   
|[641](https://leetcode.com/problems/design-circular-deque/ )            |design-circular-deque              | Medium|0815/  | | | | |  
|[42](https://leetcode.com/problems/trapping-rain-water/)                |trapping-rain-water                | Hard  |0815/  | | | | |  



#### Daily每日一题推荐
|日期 |题目编号| 题目名称   | 重复来源|难度| #1 | #2 | #3 | #4 | #5 
|----|------ | ----      | ----|----|----                |----  |----  |----| ---- | 
|0810|[70](https://leetcode.com/problems/climbing-stairs/)    |climbing-stairs    |Array实战     | Easy  | /  | / | / | / | / |  
|0811|[66](https://leetcode.com/problems/plus-one/)           |plus-one           |LinkedList实战| Easy  | /  | / | / | / | / |   
|0812|[1](https://leetcode.com/problems/two-sum/)             |two-sum            |Homework      |Easy  | /  | / | / | / | / |  
|0813|[24](https://leetcode.com/problems/swap-nodes-in-pairs/)|swap-nodes-in-pairs|LinkedList实战| Medium| /  | / | / | / | / |    
|0814|[21](https://leetcode.com/problems/merge-two-sorted-lists/)|merge-two-sorted-lists |Homework|Easy | /  | / | / | / | / |    
|0815|    | | | | | | | | | 
|0816|    | | | | | | | | |   
