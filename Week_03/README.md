学习笔记

## 第七课 泛型递归、树的递归

### 递归 Recursion
- 递归-循环
- 通过函数体来进行的循环

### Java代码模板
```java
    public void recur(int level, int param) {

        // terminator
        // 递归终结条件
        if (level > MAX_LEVEL) {
            // process result
            return;
        }

        // process current logic
        // 处理当前层
        process(level, param);

        // drill down
        // 下探到下一层
        recur(level + 1, newParam);

        // restore current status
        // 清理当前层
    }
```

### 思维要点
1. 不要人肉进行递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维


### 第八课 分治、回溯


#### 分治 Divide&Conquer
**代码模板**
```java
    private static int divide_conquer(Problem problem,) {
        // recursion terminator
        if (problem == NULL) {
            int res = process_last_result();
            return res;
        }

        // prepare data
        data = prepare_dara(problem);
        subProblems = split_problem(problem);

        // conquer subproblems
        res0 = divide_conquer(subProblems[0]);
        res1 = divide_conquer(subProblems[1]);
        // ...

        // process and generate the final result
        result = process_result(res0, res1);

        // revert the current level states

        return result;
    }
```

---

### 实战题目&作业

#### 0823 Sun
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[297](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)|serialize-and-deserialize-binary-tree|Hard|Recursion  |0823/0823|0823/0823|0824/0824|0831/ | |
|[98](https://leetcode.com/problems/validate-binary-search-tree/)           |validate-binary-search-tree          |Medium|Recursion|0823/0823|0823/0823|0824/0825|0831/ | |
|[104](https://leetcode.com/problems/maximum-depth-of-binary-tree/)         |maximum-depth-of-binary-tree         |Easy|Recursion  |0823/0823|0823/0823|0824/0824|0831/ | |
|[111](https://leetcode.com/problems/minimum-depth-of-binary-tree/)         |minimum-depth-of-binary-tree         |Easy|Recursion  |0823/0823|0823/0823|0824/0824|0831/ | |


#### 0824 Mon
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[236](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)|lowest-common-ancestor-of-a-binary-tree|Medium|Recursion|0824/0824|0824/0824|0825/0825|0901/ | |
|[105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)|construct-binary-tree-from-preorder-and-inorder-traversal                   |Medium|Recursion  |0824/0824|0824/0824|0825/0825|0901/ | |
|[77](https://leetcode.com/problems/combinations/)       |combinations      |Medium|Recursion  |0824/0824|0824/0824|0825/0825|0901/ | |
|[226](https://leetcode.com/problems/invert-binary-tree/)|invert-binary-tree|Easy  |Recursion  |0824/0824|0824/0824|0825/0825|0901/ | |


#### 0825 Tue
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[51](https://leetcode.com/problems/n-queens/)         |n-queens        |Hard  |Backtracking|0825/0825|0825/0825|0826/ |0902/ | |
|[46](https://leetcode.com/problems/permutations/)     |permutations    |Medium|Recursion   |0825/0825|0825/0825|0826/ |0902/ | |
|[47](https://leetcode.com/problems/permutations-ii/)  |permutations-ii |Medium|Recursion   |0825/0825|0825/0825|0826/ |0902/ | |
|[169](https://leetcode.com/problems/majority-element/)|majority-element|Easy  |DivideConquer|0825/0825|0825/0825|0826/ |0902/ | |


#### 0826 Wed
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[78](https://leetcode.com/problems/subsets/)                              |subsets                              |Medium|Backtracking  |0826/ | | | | |
|[50](https://leetcode.com/problems/powx-n/)                               |powx-n                               |Medium|Divide&Conquer|0826/ | | | | |
|[17](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)|letter-combinations-of-a-phone-number|Medium|              |0826/ | | | | |
|[455](https://leetcode.com/problems/assign-cookies/)                      |assign-cookies                       |Easy  |              |0826/ | | | | |
### 预习题目

#### 0827 Thu
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[102](https://leetcode.com/problems/binary-tree-level-order-traversal/) |binary-tree-level-order-traversal  |Medium|  |0827/ | | | | |
|[55](https://leetcode.com/problems/jump-game/)                          |jump-game                          |Medium|  |0827/ | | | | |
|[122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)|best-time-to-buy-and-sell-stock-ii |Easy  |  |0827/ | | | | |


#### 0828 Fri
Have a day off;

#### 0829 Sta
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[69](https://leetcode.com/problems/sqrtx/)                 |sqrtx               |Easy|  |0829/ | | | | |
|[367](https://leetcode.com/problems/valid-perfect-square/) |valid-perfect-square|Easy|  |0829/ | | | | |
|[]()   | |Medium|  |0829/ | | | | |
|[]()   | |Medium|  |0829/ | | | | |

