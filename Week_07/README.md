学习笔记

## 第十三课 字典树和并查集

### 字典树 Trie

#### 字典树的数据结构
字典树，即Trie树，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串(但不仅限于字符串)，所以经常被搜索引擎用于文本词频统计。

它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。

#### 字典树的基本性质
1. 结点本身不存完整单词；
2. 从根结点到某一结点，路径上经过的字符串连接起来，为该结点对应的字符串；
3. 每个结点的所有子结点路径代表的字符都不相同。


#### 字典树的核心思想
Trie树的核心思想是空间换时间。
利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

#### Trie 树代码模板
```java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
```


### 并查集 Disjoint Set

#### 适用场景
- 组团、配对问题
- Group or not？

#### 基本操作
1. makeSet(s)：建立一个新的并查集，其中包含s个单元素集
2. unionSet(x, y)：把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并
3. find(x)：找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。
> 基本操作有初始化、查询、合并、路径压缩

#### 并查集代码模版
```java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```
```python
def init(p): 
	# for i = 0 .. n: p[i] = i; 
	p = [i for i in range(n)] 
 
def union(self, p, i, j): 
	p1 = self.parent(p, i) 
	p2 = self.parent(p, j) 
	p[p1] = p2 
 
def parent(self, p, i): 
	root = i 
	while p[root] != root: 
		root = p[root] 
	while p[i] != i: # 路径压缩 ?
		x = i; i = p[i]; p[x] = root 
	return root
```

## 第十四课 高级搜索

### 初级搜索
1. 朴素搜索
2. 优化方向：不重复（fibonacci）、剪枝（生成括号问题）
3. 搜索方向：
   - DFS：depth first search 深度优先搜索
   - BFS：breath first search 广度优先搜索

优化：双向搜索、启发式搜索

### 剪枝

### 双向BFS
课后作业：总结双向 BFS 代码模版，请同学们提交在学习总结中。

### 启发式搜索（A\*）
```java
public class AStar
{
	public final static int BAR = 1; // 障碍值
	public final static int PATH = 2; // 路径
	public final static int DIRECT_VALUE = 10; // 横竖移动代价
	public final static int OBLIQUE_VALUE = 14; // 斜移动代价
	
	Queue<Node> openList = new PriorityQueue<Node>(); // 优先队列(升序)
	List<Node> closeList = new ArrayList<Node>();
	
	// 开始算法
	public void start(MapInfo mapInfo)
	{
		if(mapInfo==null) return;
		// clean
		openList.clear();
		closeList.clear();
		// 开始搜索
		openList.add(mapInfo.start);
		moveNodes(mapInfo);
	}

	// 移动当前结点
	private void moveNodes(MapInfo mapInfo)
	{
		while (!openList.isEmpty())
		{
			Node current = openList.poll();
			closeList.add(current);
			addNeighborNodeInOpen(mapInfo,current);
			if (isCoordInClose(mapInfo.end.coord))
			{
				drawPath(mapInfo.maps, mapInfo.end);
				break;
			}
		}
	}
	
	// 在二维数组中绘制路径
	private void drawPath(int[][] maps, Node end)
	{
		if(end==null||maps==null) return;
		System.out.println("总代价：" + end.G);
		while (end != null)
		{
			Coord c = end.coord;
			maps[c.y][c.x] = PATH;
			end = end.parent;
		}
	}

	// 添加所有邻结点到open表
	private void addNeighborNodeInOpen(MapInfo mapInfo,Node current)
	{
		int x = current.coord.x;
		int y = current.coord.y;
		// 左
		addNeighborNodeInOpen(mapInfo,current, x - 1, y, DIRECT_VALUE);
		// 上
		addNeighborNodeInOpen(mapInfo,current, x, y - 1, DIRECT_VALUE);
		// 右
		addNeighborNodeInOpen(mapInfo,current, x + 1, y, DIRECT_VALUE);
		// 下
		addNeighborNodeInOpen(mapInfo,current, x, y + 1, DIRECT_VALUE);
		// 左上
		addNeighborNodeInOpen(mapInfo,current, x - 1, y - 1, OBLIQUE_VALUE);
		// 右上
		addNeighborNodeInOpen(mapInfo,current, x + 1, y - 1, OBLIQUE_VALUE);
		// 右下
		addNeighborNodeInOpen(mapInfo,current, x + 1, y + 1, OBLIQUE_VALUE);
		// 左下
		addNeighborNodeInOpen(mapInfo,current, x - 1, y + 1, OBLIQUE_VALUE);
	}

	// 添加一个邻结点到open表
	private void addNeighborNodeInOpen(MapInfo mapInfo,Node current, int x, int y, int value)
	{
		if (canAddNodeToOpen(mapInfo,x, y))
		{
			Node end=mapInfo.end;
			Coord coord = new Coord(x, y);
			int G = current.G + value; // 计算邻结点的G值
			Node child = findNodeInOpen(coord);
			if (child == null)
			{
				int H=calcH(end.coord,coord); // 计算H值
				if(isEndNode(end.coord,coord))
				{
					child=end;
					child.parent=current;
					child.G=G;
					child.H=H;
				}
				else
				{
					child = new Node(coord, current, G, H);
				}
				openList.add(child);
			}
			else if (child.G > G)
			{
				child.G = G;
				child.parent = current;
				openList.add(child);
			}
		}
	}

	// 从Open列表中查找结点
	private Node findNodeInOpen(Coord coord)
	{
		if (coord == null || openList.isEmpty()) return null;
		for (Node node : openList)
		{
			if (node.coord.equals(coord))
			{
				return node;
			}
		}
		return null;
	}

	// 计算H的估值：“曼哈顿”法，坐标分别取差值相加
	private int calcH(Coord end,Coord coord)
	{
		return Math.abs(end.x - coord.x)
				+ Math.abs(end.y - coord.y);
	}
	
	// 判断结点是否是最终结点
	private boolean isEndNode(Coord end,Coord coord)
	{
		return coord != null && end.equals(coord);
	}

	// 判断结点能否放入Open列表
	private boolean canAddNodeToOpen(MapInfo mapInfo,int x, int y)
	{
		// 是否在地图中
		if (x < 0 || x >= mapInfo.width || y < 0 || y >= mapInfo.hight) return false;
		// 判断是否是不可通过的结点
		if (mapInfo.maps[y][x] == BAR) return false;
		// 判断结点是否存在close表
		if (isCoordInClose(x, y)) return false;
		return true;
	}

	// 判断坐标是否在close表中
	private boolean isCoordInClose(Coord coord)
	{
		return coord!=null&&isCoordInClose(coord.x, coord.y);
	}

	// 判断坐标是否在close表中
	private boolean isCoordInClose(int x, int y)
	{
		if (closeList.isEmpty()) return false;
		for (Node node : closeList)
		{
			if (node.coord.x == x && node.coord.y == y)
			{
				return true;
			}
		}
		return false;
	}
}
```



## 第十五课 高级树、AVL树和红黑树

### 二叉树、二叉树遍历
1. 前序(Pre-order)：根-左-右
2. 中序(In-order)：左-根-右
3. 后序(Post-order)：左-右-根

### 二叉搜索树 Binary Search Tree
二叉搜索树，是指一棵空树或者具有下列性质的二叉树：
1. 左子树上**所有结点**的值均小于它的根结点的值；
2. 右子树上**所有结点**的值均大于它的根结点的值；
3. 以此类推：左、右子树也分别为二叉查找树。（**这就是重复性！**）
中序遍历：升序排列

查找结点：最优时间复杂度O(log2n),极端情况树退化成链变成O(n)

#### 保证性能的关键
1. 保证二维维度！-> 左右子树结点平衡(recursively)
2. Balanced
3. https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree

### 平衡树
[维基百科-平衡树](https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree)
其中需要掌握的有：
1. 2-3 Tree
2. AVL Tree
3. B-Tree
4. Red-Black Tree
5. Splay Tree
6. Treap

#### AVL Tree
1. 发明者G. M. Adelson-Velsky和Evgenii Landis，树的名字是发明者名称的缩写
2. Balance Factor（平衡因子）：
   - 是它的左子树的高度减去它的右子树的高度(有时相反)
   - balance factor = {-1，0，1}
3. 通过旋转操作来进行平衡（四种）
4. https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree

#### 旋转操作
1. 左旋
2. 右旋
3. 左右旋
4. 右左旋
![旋转操作图](https://github.com/yzsever/algorithm014-algorithm014/blob/master/Week_07/00-Image/01-Tree_Rebalancing.gif?raw=true)

#### AVL总结
1. 平衡二叉搜索树
2. 每个结点存在 balance factor = {-1, 0, 1}
3. 四种旋转操作
不足：结点需要存储格外信息(平衡因子，需要一个int的空间)、且调整次数频繁

### 红黑树 Red-Black Tree
红黑树是一种**近似平衡**的二叉搜索树（Binary Search Tree），它能够确保任何一个结点的左右子树的**高度差小于两倍**。具体来说，红黑树是满足如下条件的二叉搜索树：
1. 每个结点要么是红色，要么是黑丝（通过1个bit标记，0或1）
2. 根结点是黑色
3. 每个叶结点（NIL结点、空结点）是黑色的
4. 不能有相邻接的两个红色结点
5. 从任一结点到其每个叶子的所有路径都包含相同数目的黑色结点
![红黑树图](https://github.com/yzsever/algorithm014-algorithm014/blob/master/Week_07/00-Image/02-Red_Black_Tree.png?raw=true)

#### 关键性质
从根到叶子的最长的可能路径不多余最短的可能路径的两倍长

### AVL Tree 和 Red-Black Tree 对比
1. AVL trees provide **faster lookups** than Red Black Trees because they are **more strictly balanced**.
2. Red Black Trees provide **faster insertion and removal** operations than AVL trees as fewer rotations are done due to relatively relaxed balancing.
3. AVL trees store balance **factors or heights** with each node, thus requires storage for an integer per node whereas Red Black Tree requires only 1 bit of information per node.
4. Red Black Trees are used in most of the **language libraries**
**like map, multimap, multisetin C++** whereas AVL trees are used in **databases** where faster retrievals are required.


---
### 实战和课后做题
#### 0921 Mon
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[208](https://leetcode.com/problems/implement-trie-prefix-tree/)|implement-trie-prefix-tree|Medium|Trie |0921/0921|0921/0921|0922/0922|0929/ | |
|[212](https://leetcode.com/problems/word-search-ii/)   |word-search-ii   |Hard  |Trie |0921/0922|0921/0922|0923/ |0929 | |
|[547](https://leetcode.com/problems/friend-circles/)   |friend-circles   |Medium|Disjoint Set|0921/0922|0921/0922|0923/ |0929 | |
|[X]()|分析单词搜索2用Tire树方式实现的时间复杂度 |Medium|Trie |0921/ |X |X |X |X |

#### 作业：
分析单词搜索2用Tire树方式实现的时间复杂度，请同学们提交在学习总结中。
[Ref](https://leetcode-cn.com/problems/word-search-ii/solution/dan-ci-sou-suo-ii-by-leetcode/)
1. 时间复杂度：O(M(4⋅3^(L−1))O(M(4⋅3L−1))，其中M 是二维网格中的单元格数，L 是单词的最大长度。
   - 计算回溯算法将执行的确切步数是一个棘手的问题。我们为这个问题的最坏情况提供了该步骤的上限。该算法循环遍历二维网格中的所有单元，因此在复杂度公式中我们有M作为因子。然后将其归结为每个启动单元所需的最大步骤数（即 4⋅3^(L−1)）。
   - 假设单词的最大长度是 L，从一个单元格开始，最初我们最多可以探索 4 个方向。假设每个方向都是有效的（即最坏情况），在接下来的探索中，我们最多有3个相邻的单元（不包括我们来的单元）要探索。因此，在回溯探索期间，我们最多遍历 4⋅3^(L−1) 个单元格。
   - 你可能会想最坏的情况是什么样子。这里有一个例子。想象一下，二维网格中的每个单元都包含字母 a，单词词典包含一个单词 ['aaaa']。这是算法将遇到的最坏的情况之一。
> 注意，上述时间复杂性是在Trie数据结构一旦构建就不会改变的假设下估计的。如果采用优化策略逐步删除Trie中的节点，则可以大大提高时间复杂度，因为一旦匹配词典中的所有单词，即 Trie 变为空，回溯的成本就会降低到零。

2. 空间复杂度：O(N)，其中 N 是字典中的字母总数。
   - 算法消耗的主要空间是我们构建的 Trie数据结构。在最坏的情况下，如果单词之间没有前缀重叠，则Trie将拥有与所有单词的字母一样多的节点。也可以选择在 Trie 中保留单词的副本。因此，我们可能需要 2N 的空间用于 Trie。


#### 0922 Tue
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[200](https://leetcode.com/problems/number-of-islands/)  |number-of-islands   |Medium|Disjoint Set|0922/0922|0922/0922|0923/ |0930/ | |
|[130](https://leetcode.com/problems/surrounded-regions/) |surrounded-regions  |Medium|Disjoint Set|0922/0922|0922/0922|0923/ |0930/ | |
|[70](https://leetcode.com/problems/climbing-stairs/)     |climbing-stairs     |Medium|Pruning     |0922/0922|0922/0922|0923/ |0930/ | |
|[22](https://leetcode.com/problems/generate-parentheses/)|generate-parentheses|Medium|Pruning     |0922/0922|0922/0922|0923/ |0930/ | |

#### 0923 Wed
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[51](https://leetcode.com/problems/n-queens/)     |n-queens     |Hard  |Pruning|0923/0923|0923/0923|0924/ |10/01 | |
|[36](https://leetcode.com/problems/valid-sudoku/) |valid-sudoku |Medium|Pruning|0923/0923|0923/0923|0924/ |10/01 | |
|[37](https://leetcode.com/problems/sudoku-solver/)|sudoku-solver|Hard  |Pruning|0923/0923|0923/0923|0924/ |10/01 | |

#### 0924 Thu
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[127](https://leetcode.com/problems/word-ladder/)                    |word-ladder                   |Medium|Two-End BFS|0924/ | | | | |
|[433](https://leetcode.com/problems/minimum-genetic-mutation/)       |minimum-genetic-mutation      |Medium|Two-End BFS|0924/ | | | | |
|[1091](https://leetcode.com/problems/shortest-path-in-binary-matrix/)|shortest-path-in-binary-matrix|Medium|A* |0924/ | | | | |
|[37](https://leetcode.com/problems/sudoku-solver/)                   |sudoku-solver                 |Hard  |A* |0924/ | | | | |

> https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/313347/A*-search-in-Python
> https://zxi.mytechroad.com/blog/searching/8-puzzles-bidirectional-astar-vs-bidirectional-bfs/

#### 0925 Fri 预习
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[733](https://leetcode.com/problems/sliding-puzzle/)                 |sliding-puzzle                |Hard  |A* |0924/ | | | | |
|[146](https://leetcode.com/problems/lru-cache/)       |lru-cache    |Medium| |0925/ | | | | |
|[242](https://leetcode-cn.com/problems/valid-anagram/)|valid-anagram|Easy  | |0925/ | | | | |
|[X]()|总结双向 BFS 代码模版 |Medium|双向BFS  |0925/ |X |X |X |X |

#### 0926 Sta
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[]()| |Medium| |0926/ | | | | |
|[]()| |Medium| |0926/ | | | | |
|[]()| |Medium| |0926/ | | | | |
|[]()| |Medium| |0926/ | | | | |




