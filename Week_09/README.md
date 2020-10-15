学习笔记

## 第十九课 高级动态规划

### 递归、分治、回溯、动态规划复习

#### 感触
1. 人肉递归低效、很累
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳法思维

本质：寻找重复性——>计算机指令集

### 动态规划 Dynamic Programming
1. "Simplifying a complicated problem by breaking it down into simpler sub-problems"(int a recursive manner)
2. Divide & Conpquer + Optimal substructure(分治 + 最优子结构)
3. 顺推形式：动态递推

#### DP顺推模板
```
function DP(){
	dp = [][] #二维情况

	for i = 0..M {
		for j = 0..N {
			dp[i][j] = _Function(dp[i'][j']...)
		}
	}

	return dp[M][N];
```

#### 关键点
- **动态规划**和**递归**或者**分治** 没有根本上的区别 (关键看有没有最优的字结构）
- 拥有共性：找到重复子问题
- 差异性：最优子结构、中途可以淘汰次优解

### 常见的DP题目和状态方程
1. 爬楼梯
递归公式：
f(n) = f(n-1) + f(n-2), f(1)=1, f(0)=0
2. 不同路径
递归公式：
f(x, y) = f(x-1, y) + f(x, y-1)
3. 打家劫舍
- 一维数组：
   - dp[i]的状态定义：max $ of robbing A[0->i]
   - dp[i] = max(dp[i-2] + nums[i], dp[i-1])
- 二维数组：
   - dp[i][0]状态定义：max $ of robbing A[0->i]且没偷 nums[i]
   - dp[i][i]状态定义：max $ of robbing A[0->i]且偷了 nums[i]
   - dp[i][0] = max(dp[i-1][0], dp[i-1][1]);
   - dp[i][1] = dp[i-1][0] + nums[i];
4. 最小路径和
   - dp[i][j]状态的定义：minPath(A[1->i][1->j])
   - dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + A[i][j]
5. 股票买卖
dp[i][k][0 or 1]  (0 <= i <= n-1, 1 <= k <= K)
   - i 为天数
   - k 为最多交易次数
   - [0, 1] 为是否持有股票
总状态数：n*K*2 种状态
```
for 0 <= i < n:
	for 1 <= k <= K:
		for s in {0, 1}:
			dp[i][k][s] = max{buy, sell, rest}
```			
- 思路：max( 选择rest， 选择sell)
   - dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
- 思路：max( 选择rest， 选择buy)
   - dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
- 初始状态：
   - dp[-1][k][0] = dp[i][0][0] = 0
   - dp[-1][k][1] = dp[i][0][1] = -infinity
- 状态转移方程：
   - dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
   - dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

### 高阶的DP问题

#### 复杂度来源
1. 状态拥有更多维度(二维、三维、或者更多、甚至需要压缩)
2. 状态方程更加复杂
本质：内功、逻辑思维、数学
---

## 第二十课 字符串

### 字符串基础知识
```java
	String x = "abbc";
```

### 遍历字符串
```java
	String x = "abbc";
	for(int i = 0; i < x.size(); ++i) {
		char ch = x.charAt(i);
	}
	for ch in x.toCharArray() {
		System.out.println(ch);
	}
```

### 字符串比较
```java
	String x = new String("abb");
	String y = new String("abb");
	x == y ——> false
	x.equals(y) ——> true
	x.equalsIgnoreCase(y) ——> true
```
### 字符串匹配算法
1. 暴力法(brute force) - O(mn)
2. Rabin-Karp 算法
3. KMP 算法

课后了解：
1. [Boyer-Moore算法](https://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html)
2. [Sunday算法](https://blog.csdn.net/u012505432/article/details/52210975)

---
### 实战和课后做题
#### 1005 Mon
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[85](https://leetcode.com/problems/maximal-rectangle/)|maximal-rectangle|Hard |High-Level DP|1005/1005|1005/1005|1006/1006|1013/1014| |
|[746](https://leetcode.com/problems/min-cost-climbing-stairs/) |min-cost-climbing-stairs     |Easy |High-Level DP|1005/1005|1005/1005|1006/1006|1013/1014| |
|[300](https://leetcode.com/problems/longest-increasing-subsequence/)|longest-increasing-subsequence|Medium |High-Level DP|1005/1005|1005/1005|1006/1006|1013/1014| |
|[709](https://leetcode.com/problems/to-lower-case/)   |to-lower-case    |Easy |String|1005/1005|1005/1005|1006/1006|1013/1014| |

#### 1006 Tue
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[818](https://leetcode.com/problems/race-car/)          |race-car           |Hard |High-Level DP|1006/1006|1006/1006|1007/1009|1014/1014| |
|[58](https://leetcode.com/problems/length-of-last-word/)|length-of-last-word|Easy |String|1006/1006|1006/1006|1007/1009|1014/1014| |
|[771](https://leetcode.com/problems/jewels-and-stones/) |jewels-and-stones  |Easy |String|1006/1006|1006/1006|1007/1009|1014/1014| |
|[387](https://leetcode.com/problems/first-unique-character-in-a-string/)|first-unique-character-in-a-string|Easy |String|1006/1006|1006/1006|1007/1009|1014/1014| |

#### 1007 Wed
Have a day off!

#### 1008 Thu
Have a day off!

#### 1009 Fri
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[115](https://leetcode.com/problems/distinct-subsequences/)|distinct-subsequences|Hard|High-Level DP|1007/1009|1009/1009|1010/1013|1017/  | |
|[8](https://leetcode.com/problems/string-to-integer-atoi/) |string-to-integer-atoi|Medium|String    |1007/1009|1009/1009|1010/1013|1017/  | |
|[14](https://leetcode.com/problems/longest-common-prefix/) |longest-common-prefix |Easy  |String    |1007/1009|1009/1009|1010/1013|1017/  | |
|[344](https://leetcode.com/problems/reverse-string/)       |reverse-string        |Easy  |String    |1007/1009|1009/1009|1010/1013|1017/  | |


#### 1010 Sta
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[541](https://leetcode.com/problems/reverse-string-ii/)            |reverse-string-ii            |Easy  |String |1008/1008|1008/1008|1011/1013|1018/ | |
|[151](https://leetcode.com/problems/reverse-words-in-a-string/)    |reverse-words-in-a-string    |Medium|String |1010/1010|1010/1010|1011/1013|1018/ | |
|[557](https://leetcode.com/problems/reverse-words-in-a-string-iii/)|reverse-words-in-a-string-iii|Easy  |String |1010/1010|1010/1010|1011/1013|1018/ | |
|[917](https://leetcode.com/problems/reverse-only-letters/)         |reverse-only-letters         |Easy  |String |1010/1010|1010/1010|1011/1013|1018/ | |

#### 1011 Sun
Learn videos

#### 1013 Tue
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[10](https://leetcode.com/problems/regular-expression-matching/)   |regular-expression-matching  |Hard   |String |1012/1013|1012/1013|1014/ |1020/ | |
|[49](https://leetcode.com/problems/group-anagrams/)                |group-anagrams               |Medium |String |1012/1013|1012/1013|1014/ |1020/ | |
|[438](https://leetcode.com/problems/find-all-anagrams-in-a-string/)|find-all-anagrams-in-a-string|Medium |String |1013/1014|1013/1014|1015/ |1020/ | |


#### 1014 Wed
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[44](https://leetcode.com/problems/wildcard-matching/)           |wildcard-matching            |Hard  |String|1014/1014|1014/1014|1015/ |1021/ | |
|[5](https://leetcode.com/problems/longest-palindromic-substring/)|longest-palindromic-substring|Medium|String|1014/1014|1014/1014|1015/ |1021/ | |
|[125](https://leetcode.com/problems/valid-palindrome/)           |valid-palindrome             |Easy  |String|1014/1014|1014/1014|1015/ |1021/ | |


#### 1015 Thu
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[680](https://leetcode.com/problems/valid-palindrome-ii/)|valid-palindrome-ii    |Easy |String|1015/1015|1015/1015|1016/ |1022/ | |
|[45](https://leetcode.com/problems/jump-game-ii/)      |jump-game-ii     |Hard  |High-Level DP|1015/1015|1015/1015|1016/ |1022/ | |
|[279](https://leetcode.com/problems/perfect-squares/)  |perfect-squares  |Medium|High-Level DP|1015/1015|1015/1015|1016/ |1022/ | |


#### 1016 Fri
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[980](https://leetcode.com/problems/unique-paths-iii/)|unique-paths-iii|Hard  |High-Level DP|1016/ | | | | |
|[322](https://leetcode.com/problems/coin-change/)     |coin-change     |Medium|High-Level DP|1016/ | | | | |
|[518](https://leetcode.com/problems/coin-change-2/)   |coin-change-2   |Medium|High-Level DP|1016/ | | | | |


#### 课后作业
在学习总结中，写出不同路径 2 这道题目的状态转移方程。
- if (obstacleGrid[i - 1][j - 1] == 1) dp[i][j] = 0;
- else dp[i][j] = dp[i-1][j] + dp[i][j-1]