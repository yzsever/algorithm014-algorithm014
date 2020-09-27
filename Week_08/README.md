学习笔记

## 第十六课 位运算

### 位运算符

#### 为什么需要位运算
- 机器里的数字表示方法和存储格式就是 二进制
- 十进制和二进制如何转换？
 - [参考连接](https://zh.wikihow.com/%E4%BB%8E%E5%8D%81%E8%BF%9B%E5%88%B6%E8%BD%AC%E6%8D%A2%E4%B8%BA%E4%BA%8C%E8%BF%9B%E5%88%B6)

#### 位运算符
|含义   |   运算符   | 示例                |
|------   | ----           | ----                  |
| 左移       | <<           | 0011 => 0110 |
| 右移       | >>           | 0110 => 0011 |
| 按位或   |  I    | 0011 => 0110 |
| 按位与  |  &           | 0011 => 0110 |
| 按位取反|  ~           | 0011 => 0110 |
| 按位异或|  ^           | 0011 => 0110 |

#### XOR 异或
异或：相同为0，不同为1。也可用“不进位加法”来理解。
异或操作的一些特点:
- x ^ 0 = x
- x ^ 1s = ~x    // 注意1s = ～0
- x ^ (~x) = 1s
- x ^ x = 0
- c = a ^ b => a ^c = b, b^c = a   // 交换两数
- a ^ b ^ c = a^(b^c) = (a^b)^c    // associative

### 算数移位与逻辑移位
1. 将x最右边的n位清零: x & (~0 << n)
2. 获取x的第n位值（0或者1）：(x >> n) & 1
3. 获取x的第n位幂值：x & (1 << n)
4. 仅将第n位置为1：x | (1 << n)
5. 仅将第n位置为0：x & (~ (1 << n))
6. 将x最高位至第n位（含）清零：x & ((1 << n) - 1)


### 位运算的应用
1. 判断奇偶
   - x%2 == 1 --> (x & 1) == 1
   - x%2 == 0 --> (x & 1) == 0
2. x >> 1 --> x / 2
   - x = x/2; --> x = x >> 1;
   - mid = (left + right)/2; --> mid = (left + right) >> 1;
3. x = x & (x-1) 清零最低位的1
4. x & -x 得到最低位的1
5. x & ~x --> 0


## 第十七课 布隆过滤器、LRU Cache

### 布隆过滤器 Bloom Filter
- HashTable + 拉链存储重复元素
- Bloom Filter vs Hash Table
   - 一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否再一个集合中。

优点：空间效率和查询时间都远远超过一般的算法
缺点：有一定的误识别率和删除困难
> 布隆过滤器使用在第一层过滤，可以识别肯定不存在的数据。

#### 案例
1. 比特币网络
2. 分布式系统（Map-Reduce）—— Hadoop、search engine
3. Redis缓存
4. 垃圾邮件、评价等的过滤


科普：
- [布隆过滤器的原理和实现](https://www.cnblogs.com/cpselvis/p/6265825.html)
- [使用布隆过滤器解决缓存击穿、垃圾邮件识别、集合判重](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)

#### 实现
- [布隆过滤器 Python 代码示例](https://shimo.im/docs/UITYMj1eK88JCJTH/read)
- [布隆过滤器 Python 实现示例](https://www.geeksforgeeks.org/bloom-filters-introduction-and-python-implementation/)
- [高性能布隆过滤器 Python 实现示例](https://github.com/jhgg/pybloof)
- [布隆过滤器 Java 实现示例 1](https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java)
- [布隆过滤器 Java 实现示例 2](https://github.com/Baqend/Orestes-Bloomfilter)

### LRU Cache

#### Cache 缓存
1. 记忆
2. 钱包 - 储物柜
3. 代码模块

#### LRU cache
1. 两个要素：大小、替换策略
2. Hash Table + Double LinkedList
3. O(1) 查询 O(1) 修改、更新

#### 替换策略
1. LFU - least frequently used
2. LRU - least recently used

[替换算法总览](https://en.wikipedia.org/wiki/Cache_replacement_policies)
[LRU Cache Python 代码示例](https://shimo.im/docs/CoyPAyXooGcDuLQo/read)

### 实战和课后做题
#### 0928 Mon
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[191](https://leetcode.com/problems/number-of-1-bits/) |number-of-1-bits|Easy|Bit Operation|0928/ | | | | |
|[231](https://leetcode.com/problems/power-of-two/)     |power-of-two    |Easy|Bit Operation|0928/ | | | | |
|[190](https://leetcode.com/problems/reverse-bits/)     |reverse-bits    |Easy|Bit Operation|0928/ | | | | |

#### 0929 Tue
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[51](https://leetcode.com/problems/n-queens/)      |n-queens       |Hard  |Bit Operation|0929/ | | | | |
|[52](https://leetcode.com/problems/n-queens-ii/)   |n-queens-ii    |Hard  |Bit Operation|0929/ | | | | |
|[338](https://leetcode.com/problems/counting-bits/)|counting-bits  |Medium|Bit Operation|0929/ | | | | |

#### 0930 Wed
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[1122](https://leetcode.com/problems/relative-sort-array/)|relative-sort-array|Easy  |Sort |0930/ | | | | |
|[56](https://leetcode.com/problems/merge-intervals/)      |merge-intervals    |Medium|Sort |0930/ | | | | |
|[493](https://leetcode.com/problems/reverse-pairs/)       |reverse-pairs      |Hard  |Sort |0930/ | | | | |


#### 1001 Thu
Have a day off!

#### 1002 Fri 预习第九周
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[62](https://leetcode.com/problems/unique-paths/)     |unique-paths    |Medium|High-Level DP|1002/ | | | | |
|[64](https://leetcode.com/problems/minimum-path-sum/) |minimum-path-sum|Medium|High-Level DP|1002/ | | | | |
|[]()     |    |Medium| | | | | | |
|[]()     |    |Medium| | | | | | |

#### 1003 Sta 每日一题补充
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[240](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)|search-a-2d-matrix-ii|Medium|1003/ | | | | | |
|[16](https://leetcode.com/problems/3sum-closest/)             |3sum-closest         |Medium|1003/ | | | | | |
|[]()     |    |Medium| | | | | | |
|[]()     |    |Medium| | | | | | |

#### 课后作业
用自己熟悉的编程语言，手写各种初级排序代码，提交到学习总结中。