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

---

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

---

## 第十八课 排序

### 排序算法
1. 比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。
- 交换排序
   - 冒泡排序
   - 快速排序
- 插入排序
   - 简单插入排序
   - 希尔排序
- 选择排序
   - 简单选择排序
   - 堆排序
- 归并排序
   - 二路归并排序
   - 多路归并排序

2. 非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较排序。
- 计数排序
- 桶排序
- 基数排序

### 初级排序 - O（n^2）
1. 选择排序（Selection Sort）
每次找最小值，然后放在待排序数组的起始位置

2. 插入排序
从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入

3. 冒泡排序
嵌套循环，每次查看相邻的元素如果逆序，则交换

### 高级排序 - O（nlogn)
1. 快速排序（Quick Sort）
数组取标杆pivot，将小元素放pivot左边，大元素放右侧，然后依次对左边和右边的子数组继续快排；以达到整个序列有序。
```java
public static void quickSort(int[] array, int begin, int end) {
    if (end <= begin) return;
    int pivot = partition(array, begin, end);
    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);
}
static int partition(int[] a, int begin, int end) {
    // pivot: 标杆位置，counter: 小于pivot的元素的个数
    int pivot = end, counter = begin;
    for (int i = begin; i < end; i++) {
        if (a[i] < a[pivot]) {
            int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
            counter++;
        }
    }
    int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
    return counter;
}
```

2. 归并排序（Merge Sort）——分治
- 把长度为n的输入序列分成两个长度为n/2的子序列
- 对这两个子序列分别采用归并排序
- 将两个排序好的子序列合并成一个最终的排序序列
```java
public static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left + right) >> 1; // (left + right) / 2

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);
    merge(array, left, mid, right);
}

public static void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1]; // 中间数组
    int i = left, j = mid + 1, k = 0;

    while (i <= mid && j <= right) {
        temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    }

    while (i <= mid) temp[k++] = arr[i++];
    while (j <= right) temp[k++] = arr[j++];

    for (int p = 0; p < temp.length; p++) {
        arr[left + p] = temp[p];
    }
    // 也可以用 System.arraycopy(a, start1, b, start2, length)
}
```

#### 快排和归并对比
- 归并和快排具有相似性，但步骤顺序相反
- 归并：先排序左右子数组，然后合并两个有序数组
- 快排：先调配出左右子数组，然后对于左右子数组进行排序

3. 堆排序（Heap Sort） —— 堆插入O（logN），取最大/最小值O（1）
- 数组元素依次建立小顶堆
- 依次取堆顶元素，并删除
```java
static void heapify(int[] array, int length, int i) {
    int left = 2 * i + 1, right = 2 * i + 2；
    int largest = i;
    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }
    if (largest != i) {
        int temp = array[i]; array[i] = array[largest]; array[largest] = temp;
        heapify(array, length, largest);
    }
}
public static void heapSort(int[] array) {
    if (array.length == 0) return;
    int length = array.length;
    for (int i = length / 2-1; i >= 0; i-) 
        heapify(array, length, i);
    for (int i = length - 1; i >= 0; i--) {
        int temp = array[0]; array[0] = array[i]; array[i] = temp;
        heapify(array, i, 0);
    }
}
```

### 特殊排序 - O(n)
1. 计数排序（Counting Sort）
计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存储在额外的数组空间中；然后依次把计数大于1的填充回原数组

2. 桶排序（Bucket Sort）
假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是递归方式继续使用桶排序进行排）。

3. 基数排序（Radix Sort）
基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序

#### 参考资料
- [十大经典排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)
- [9 种经典排序算法可视化动画](https://www.bilibili.com/video/av25136272)
- [6 分钟看完 15 种排序算法动画展示](https://www.bilibili.com/video/av63851336)

---

### 实战和课后做题
#### 0928 Mon
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[191](https://leetcode.com/problems/number-of-1-bits/) |number-of-1-bits|Easy|Bit Manipulation|0928/0928|0928/0928|0929/0929|1006/ | |
|[231](https://leetcode.com/problems/power-of-two/)     |power-of-two    |Easy|Bit Manipulation|0928/0928|0928/0928|0929/0929|1006/ | |
|[190](https://leetcode.com/problems/reverse-bits/)     |reverse-bits    |Easy|Bit Manipulation|0928/0928|0928/0928|0929/0929|1006/ | |

#### 0929 Tue
|题目编号| 题目名称   | 难度  | 类型 | #1  | #2 | #3 | #4 | #5  |
|------ | ----      | ---- | ----|----                |----  |----  |----| ---- |
|[51](https://leetcode.com/problems/n-queens/)      |n-queens       |Hard  |Bit Manipulation|0929/0929|0929/0929|0930/ |1007/ | |
|[52](https://leetcode.com/problems/n-queens-ii/)   |n-queens-ii    |Hard  |Bit Manipulation|0929/0929|0929/0929|0930/ |1007/ | |
|[338](https://leetcode.com/problems/counting-bits/)|counting-bits  |Medium|Bit Manipulation|0929/0929|0929/0929|0930/ |1007/ | |

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