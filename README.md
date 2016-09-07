# LeetCode 刷题

## Reverse:

如果一个题要从后往前遍历，首先应该想到用stack，如果用stack的话，就可以想想可以不可以用递归。

或者反过来：如果一个题要从后往前遍历，首先可以想到用递归，如果是递归的话，就可以想想可以不可以用stack。

## Tree

### Recursive

```java
private void inorderTraversal(TreeNode root) {
	if (root != null) {
		inorderTraversal(root.left);
		visit(root);
		inorderTraversal(root.right);
	}
}
```

### Iterative

```java
public void inorderTraversal(TreeNode root) {
	Stack<TreeNode> stack = new Stack<>();
	while (root != null || !stack.isEmpty()) {
		if (root != null) {
			stack.push(root);
			root = root.left;
		} else {
			root = stack.pop();
			visit(root);
			root = root.right;
		}
	}
}
``

BFS

- 如果两个child分别在root的left、right，那么child一个大于root，一个小于root。
- 反过来也成立。

### Lowest Common Ancestor of a Binary Search Tree

```
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if (root.val < p.val && root.val < q.val)
		return lowestCommonAncestor(root.right, p, q);
	if (root.val > p.val && root.val > q.val)
		return lowestCommonAncestor(root.left, p, q);
	return root;
}
```

### Segment Tree

如果一个值的改变，会影响到整体，就可以想想可以不可以使用segment Tree。

Segment Tree不需要一个改变，就全部改变，Segment Tree 只需要修改log(n)个值。

### Heap

Advantage：使用保持 balance。

Add / push [Time complexity: log(n)]
	1. add to tail
	2. 从leaf向root switch。（从下向上）
	
remove [Time complexity: log(n)]
	1. remove root
	2. remove tail to root
	3. 从root向leaf switch。 （从上向下）
	
	
### Trie

```java
class TrieNode {
	boolean isWord;
	Map<Character, TrieNode> children;

	public TrieNode() {
		isWord = false;
		children = new HashMap<>();
	}
}
```

## Search

1. 在排好序（sorted）的array中查找，应该马上就想到 binary search O(log(N))
2. 如果是在hashSet/hashTable中，肯定是最快的查找速度。O(1)

## 找cycle

1. 使用 hash table
2. slow，fast （快慢指针）两个指针一起向前迭代，如果他们有cycle一定会相遇。

### cycle from graph

1. hash table
2. (slow / fast ) pointer
3. DFS (unvisited, visiting, visited)

如果遍历到某个结点，发现状态是visiting，说明有cycle。

### Topological Sort

在不知道root结点，或者没有root结点的 场景 中使用。

其实就是使用DFS遍历各个node。如果遍历到最后一个结点，加入到stack中。

1. DFS traverse all node.
2. Add tail to stack.
3. pop from stack.
4. if has cycle no result.

## Dynamic programming

### Edit Distance

```
if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
	dp(row)(col) = dp(row - 1)(col - 1);
} else {
	int replace = dp(row - 1)(col - 1) + 1;
	int insert = dp(row)(col - 1) + 1;
	int delete = dp(row - 1)(col) + 1;
	dp(row)(col) = Math.min(replace, Math.min(insert, delete));
}
```