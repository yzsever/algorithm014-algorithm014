学习笔记

## 如何高效学习算法训练营课程

### 三分看视频理解、七分练习
1、视频：1.5～2.0倍数播放、难点（暂停+反复）
实践尝试：2倍速看完，难点或者觉得重要的点结合PPT做笔记，如果思考后又不理解的地方再回看视频对应位置直到弄懂。

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
|题目编号| 题目名称   | 难度| #1[自己实现/看高票答案]预计时间/实际时间  | #2[优化算法Leetcode提交] | #3[一天后]   | #4[一周后] | #5[面试前一周] |
|------ | ----      | ----|----                |----  |----  |----| ---- | 
|11     | https://leetcode.com/problems/container-with-most-water/ | Medium |0810 / 0810| 0810 / 0810 | 0811 / | 0818 /|  |
|283    | https://leetcode.com/problems/move-zeroes/               | Easy   |0810 / 0810| 0810 / 0810 | 0811 / | 0818 /|  |
|70     | https://leetcode.com/problems/climbing-stairs/           | Easy   |0810 / 0810| 0810 / 0810 | 0811 / | 0818 /|  |
|15     | https://leetcode.com/problems/3sum/                      | Medium |0810 / 0810| 0810 / 0810 | 0811 / | 0818 /|  |

#### Linked List
|题目编号| 题目名称   | 难度| #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ----|----                |----  |----  |----| ---- | 
|206    |https://leetcode.com/problems/reverse-linked-list/      | Easy  |0811 /   |0811 / | | | | 
|24     |https://leetcode.com/problems/swap-nodes-in-pairs/      | Medium|0811 /   |0811 / | | | |  
|141    |https://leetcode.com/problems/linked-list-cycle/        | Easy  |0811 /   |0811 / | | | |  
|142    |https://leetcode.com/problems/linked-list-cycle-ii/     | Medium|0811 /   |0811 / | | | | 
|25     |https://leetcode.com/problems/reverse-nodes-in-k-group/ | Hard  |0812 /   |0812 / | | | |  

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

![Image of complexity](https://github.com/yzsever/algorithm014-algorithm014/blob/master/Week_01/05-Image/01-complexity.png?raw=true)

### 课后作业1 [0812/]
**用add first或add last这套新的API改写Deque的代码**

### 课后作业2 [0812/]
**分析Queue和Priority Queue的源码**

### Stack & Queue

|题目编号| 题目名称   | 难度| #1 | #2 | #3 | #4 | #5 
|------ | ----      | ----|----                |----  |----  |----| ---- | 
|20     |https://leetcode.com/problems/valid-parentheses/              | Easy  |0812 /   | | | | |  
|155    |https://leetcode.com/problems/min-stack/                      | Easy  |0812 /   | | | | |  
|84     |https://leetcode.com/problems/largest-rectangle-in-histogram/ | Hard  |0813 /   | | | | | 
|239    |https://leetcode.com/problems/sliding-window-maximum/         | Hard  |0813 /   | | | | | 
---

#### Weekly Homework
|题目编号| 题目名称   | 难度| #1 | #2 | #3 | #4 | #5 
|------ | ----      | ----|----                |----  |----  |----| ---- | 
|26     |https://leetcode.com/problems/remove-duplicates-from-sorted-array/ | Easy  |0813 /  | | | | |  
|189    |https://leetcode.com/problems/rotate-array/                        | Easy  |0813 /  | | | | |   
|21     |https://leetcode.com/problems/merge-two-sorted-lists/              | Easy  |0814 /  | | | | |   
|88     |https://leetcode.com/problems/merge-sorted-array/                  | Easy  |0814 /  | | | | |   
|1      |https://leetcode.com/problems/two-sum/                             | Easy  |0814 /  | | | | |    
|283(同实战) | https://leetcode.com/problems/move-zeroes/                    | Easy  |/       | /| /| /| /| /| 
|66     |https://leetcode.com/problems/plus-one/                            | Easy  |0814 /  | | | | |   
|641    |https://leetcode.com/problems/design-circular-deque/               | Medium|0815 /  | | | | |  
|42     |https://leetcode.com/problems/trapping-rain-water/                 | Hard  |0815 /  | | | | |  



#### Daily每日一题推荐
|日期 |题目编号| 题目名称   | 重复来源|难度| #1 | #2 | #3 | #4 | #5 
|----|------ | ----      | ----|----|----                |----  |----  |----| ---- | 
|0810|70  |https://leetcode.com/problems/climbing-stairs/ |Array实战     | Easy  | /  | / | / | / | / |  
|0811|66  |https://leetcode.com/problems/plus-one/        |LinkedList实战| Easy  | /  | / | / | / | / |   
|0812|    | | | | | | | | |   
|0813|    | | | | | | | | |   
|0814|    | | | | | | | | |    
|0815|    | | | | | | | | | 
|0816|    | | | | | | | | |   
