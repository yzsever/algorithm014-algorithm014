学习笔记

## 第十二课 动态规划

### 分治+回溯+递归+动态规划

#### 分治
1. 人肉递归低效、很累
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳法思想（抵制人肉递归的诱惑）

本质：寻找重复性->计算机指令集

#### 动态规划 Dynamic Programming定义
1. “Simlifying a complicated problem by breaking it down into simpler sub-problems” (in a recursive manner)
   - In both contexts it refers to simplifying a complicated problem by breaking it down into simpler sub-problems in a recursive manner. While some decision problems cannot be taken apart this way, decisions that span several points in time do often break apart recursively. Likewise, in computer science, if a problem can be solved optimally by breaking it into sub-problems and then recursively finding the optimal solutions to the sub-problems, then it is said to have optimal substructure.
   - 在这两种情况下，它都是指通过以递归的方式将其分解为更简单的子问题来简化复杂的问题。虽然无法以这种方式解决某些决策问题，但跨越多个时间点的决策通常会递归拆分。同样，在计算机科学中，如果可以通过将问题分解为子问题然后递归地找到子问题的最优解来最佳地解决问题，则可以说它具有最优子结构。
2. Divide & Conquer + Optimal substructure (分治+最优子结构)

#### 对比关键点
1. 动态规划和递归或者分治没有根本上的区别（**关键看有无最优的子结构**）
2. **共性：找到重复子问题**
3. 差异性：最优子结构、中途可以**淘汰**次优解

### 动态规划关键点
1. 最优子结构 opt[n] = best_of(opt[n-1], opt[n-2], ...)
2. 存储中间状态: opt[i]
3. 递推公式（美其名曰：状态转移方程或DP方程）
 Fib：opt[i] = opt[n-1] + opt[n-2]
 二维路径：opt[i, j] = opt[i+1][j] + opt[i][j+1](且判断a[i, j]是否空地)
 
### 动态规划小结
1. 打破自己的思维惯性，形成机器思维
2. 理解复杂逻辑的关键
3. 也是职业进阶的要点要领

---

### 实战题目&作业

#### 0914 Mon
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[152](https://leetcode.com/problems/maximum-product-subarray/)|maximum-product-subarray |Medium|DP|0914/0909|0914/0909|0915/0915|0922/ | |
|[64](https://leetcode.com/problems/minimum-path-sum/)         |minimum-path-sum         |Medium|DP|0914/0909|0914/0910|0915/0915|0922/ | |
|[32](https://leetcode.com/problems/longest-valid-parentheses/)|longest-valid-parentheses|Hard  |DP|0914/0909|0914/0909|0915/0915|0922/ | |

#### 0915 Tue
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)    |best-time-to-buy-and-sell-stock |Easy |DP |0915/0911|0915/0911|0916/0916|0923/ | |
|[122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) |best-time-to-buy-and-sell-stock-ii |Easy |DP |0915/0911|0915/0911|0916/0916|0923/ | |
|[123](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)|best-time-to-buy-and-sell-stock-iii |Hard |DP |0915/0911|0915/0911|0916/0916|0923/ | |
|[309](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)|best-time-to-buy-and-sell-stock-with-cooldown |Medium |DP |0915/0911|0915/0911|0916/0916|0923/ | |

#### 0916 Wed
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[188](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)|best-time-to-buy-and-sell-stock-iv |Hard |DP |0916/0914|0916/0914|0917/0919|0924/ | |
|[714](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)|best-time-to-buy-and-sell-stock-with-transaction-fee |Medium |DP |0916/0914|0916/0914|0917/0917|0924/ | |
|[91](https://leetcode.com/problems/decode-ways/)    |decode-ways  |Medium|DP|0916/0914|0916/0914|0917/0919|0924/ | |
|[72](https://leetcode.com/problems/edit-distance/)  |edit-distance|Hard  |DP|0916/0914|0916/0914|0917/0919|0924/ | |

#### 0917 Thu
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[213](https://leetcode.com/problems/house-robber-ii/)|house-robber-ii|Medium|DP|0917/0915|0917/0915|0918/0920|0925/ | |
|[221](https://leetcode.com/problems/maximal-square/) |maximal-square |Medium|DP|0917/0915|0917/0915|0918/0921|0925/ | |
|[363](https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/)|max-sum-of-rectangle-no-larger-than-k|Hard |DP |0917/0915|0917/0915|0918/0921|0925/ | |
|[403](https://leetcode.com/problems/frog-jump/)      |frog-jump  |Hard |DP |0917/0915|0917/0915|0918/0921|0925/ | |

#### 0918 Fri
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[612](https://leetcode.com/problems/task-scheduler/)         |task-scheduler        |Medium|DP|Need VIP X|X |X |X |X |
|[647](https://leetcode.com/problems/palindromic-substrings/) |palindromic-substrings|Medium|DP|0918/0915|0918/0915|0919/ |0926/ | |
|[410](https://leetcode.com/problems/split-array-largest-sum/)|split-array-largest-sum|Hard |DP|0918/0915|0918/0915|0919/ |0926/ | |
|[552](https://leetcode.com/problems/student-attendance-record-ii/)|student-attendance-record-ii|Hard|DP|0918/0915|0918/0915|0919/ |0926/ | |


#### 0919 Sta
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[76](https://leetcode.com/problems/minimum-window-substring/)|minimum-window-substring|Hard|DP|0919/0919|0919/0919|0920/ |0927/ | |
|[312](https://leetcode.com/problems/burst-balloons/)         |burst-balloons          |Hard|DP|0919/0919|0919/0919|0920/ |0927/ | |

---

学习心得：
本周题量和题目的难度确实增加了，所以做题所花的时间比之前要多，而且复刷的时候依然有的题会感觉有难度，需要刷更多的次数去熟练掌握。