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
|题目编号| 题目名称   | 难度| #1[自己实现/看高票答案](预计时间/实际时间)  | #2[优化算法Leetcode提交] | #3[一天后]   | #4[一周后] | #5[面试前一周] |
|------ | ----      | ----|----                |----  |----  |----| ---- | 
|11     | https://leetcode.com/problems/container-with-most-water/  | Medium  |20200810 / 20200810 | 20200810 / 20200810 | 20200811 / | 20200818 / |  |
|283    | https://leetcode.com/problems/move-zeroes/   |   Easy   |20200810 / 20200810| 20200810 / 20200810 | 20200811 / | 20200818 /| |
|70     | https://leetcode.com/problems/climbing-stairs/    |   Easy  |20200810 / 20200810 | 20200810 / 20200810 |20200811 / | 20200818 /| |
|15     | https://leetcode.com/problems/3sum/ | Medium | 20200810 / 20200810| 20200810 / 20200810 | 20200811 / | 20200818 /| |

#### Linked List
|题目编号| 题目名称   | 难度| #1(预计时间/实际时间)  | #2 | #3 | #4 | #5  |
|------ | ----      | ----|----                |----  |----  |----| ---- | 
|206        |https://leetcode.com/problems/reverse-linked-list/   |  Easy   |20200811 /  | | | | | 
|24          |https://leetcode.com/problems/swap-nodes-in-pairs/ | Medium  |20200811 /   | | | | |  
|141        |https://leetcode.com/problems/linked-list-cycle/  | Easy  |20200811 /   | | | | |  
|142        |https://leetcode.com/problems/linked-list-cycle-ii/ | Medium  |20200811 /    | | | | | 
|25          |https://leetcode.com/problems/reverse-nodes-in-k-group/  | Hard |20200812 /   | | | | |  

#### Homework
|题目编号| 题目名称   | 难度| #1(预计时间/实际时间)  | #2 | #3 | #4 | #5 
|------ | ----      | ----|----                |----  |----  |----| ---- | 
|26          |https://leetcode.com/problems/remove-duplicates-from-sorted-array/ | Easy  |20200812 /   | | | | |  
|189        |https://leetcode.com/problems/rotate-array/  | Easy  |20200812 /  | | | | |   
|21          |https://leetcode.com/problems/merge-two-sorted-lists/  | Easy  |20200812 /  | | | | |   
|88          |https://leetcode.com/problems/merge-sorted-array/  | Easy  |20200813 /  | | | | |   
|1            |https://leetcode.com/problems/two-sum/  | Easy  |20200813 /  | | | | |    
|283(同实战) | https://leetcode.com/problems/move-zeroes/   |   Easy   | | | | | | | 
|66           |https://leetcode.com/problems/plus-one/ | Easy  |20200813 /  | | | | |   
