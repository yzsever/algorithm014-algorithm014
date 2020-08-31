学习笔记

## 第九课 深度优先搜索和广度优先搜索

### 搜索-遍历
- 每个节点都要访问一次
- 每个节点仅仅要访问一次
- 对于节点的访问顺序不限
   - 深度优先：depth first search
   - 广度优先：breadth first search

### DFS代码模版
```java
//Java
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }


    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }
```

```java
#Python
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```

### BFS代码模版
```java
//Java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```

---

## 第十课 贪心算法

#### 定义
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优(即最有利)的选择，从而希望导致结果是全局最好或最优的算法。

**对比**
贪心算法：对每个子问题的解决方案都做出选择，不能回退。
动态规划：保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

#### 适用问题
可以解决一些最优化问题：
- 图中的最小生成树
- 哈夫曼编码
- ...

对于工程和生活中的问题，贪心法一般不能得到我们所要求的答案。一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。

由于贪心法的高效性以及其所得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些结果不特别精确的问题。

简单来说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解称为最优子结构。

---

## 第十一课 二分查找

### 二分查找的前提
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

### 代码模板
```java
	public int binarySearch(int[] array, int target) {
	    int left = 0, right = array.length - 1, mid;
	    while (left <= right) {
	        mid = (right - left) / 2 + left;

	        if (array[mid] == target) {
	            return mid;
	        } else if (array[mid] > target) {
	            right = mid - 1;
	        } else {
	            left = mid + 1;
	        }
	    }
	    return -1;
	}
```

### 课后作业
使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
说明：同学们可以将自己的思路、代码写在学习总结中

---

### 实战题目&作业

#### 0831 Mon
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[433](https://leetcode.com/problems/minimum-genetic-mutation/)|minimum-genetic-mutation|Medium|DFS&BFS|0831/| | | | |
|[515](https://leetcode.com/problems/find-largest-value-in-each-tree-row/)|find-largest-value-in-each-tree-row|Medium|DFS&BFS|0831/| | | | |
|[860](https://leetcode.com/problems/lemonade-change/)         |lemonade-change |Easy |Greedy|0901/| | | | |

#### 0901 Tue
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[127](https://leetcode.com/problems/word-ladder/)|word-ladder |Medium|DFS&BFS|0831/| | | | |
|[126](https://leetcode.com/problems/word-ladder-ii/)|word-ladder-ii|Hard|DFS&BFS|0831/| | | | |
|[529](https://leetcode.com/problems/minesweeper/)|minesweeper |Medium|DFS&BFS|0901/| | | | |
|[874](https://leetcode.com/problems/walking-robot-simulation/)|walking-robot-simulation|Easy |Greedy|0901/| | | | |

#### 0902 Wed
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[322](https://leetcode.com/problems/coin-change/)|coin-change |Medium|Greedy |0901/| | | | |
|[45](https://leetcode.com/problems/jump-game-ii/)|jump-game-ii |Greedy |Hard |0902/| | | | |
|[33](https://leetcode.com/problems/search-in-rotated-sorted-array/)|search-in-rotated-sorted-array |BinarySearch |Medium |0902/| | | | |


#### 0903 Thu
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[74](https://leetcode.com/problems/search-a-2d-matrix/)|search-a-2d-matrix |BinarySearch |Medium |0902/| | | | |
|[153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)|find-minimum-in-rotated-sorted-array |BinarySearch|Medium  |0902/| | | | |
|[]()| | | |0903/| | | | |
|[]()| | | |0903/| | | | |

#### 0904 Fri
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[]()| | | |0904/| | | | |
|[]()| | | |0904/| | | | |
|[]()| | | |0904/| | | | |
|[]()| | | |0904/| | | | |

#### 0905 Sta
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[1498](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/) |number-of-subsequences-that-satisfy-the-given-sum-condition|Medium |  |0829/ | | | | |
|[18](https://leetcode.com/problems/4sum/)                 |4sum                |Medium|  |0829/ | | | | |
|[17.09](https://leetcode-cn.com/problems/get-kth-magic-number-lcci/)|get-kth-magic-number-lcci|Medium | |0905/| | | | |



