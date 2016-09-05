package org.dzhou.leetcode;

/**
 * 261. Graph Valid Tree
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to check whether these edges make
 * up a valid tree.
 * 
 * For example:
 * 
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return
 * false.
 * 
 * Hint:
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is
 * this case a valid tree?
 * 
 * According to the definition of tree on Wikipedia: “a tree is an undirected
 * graph in which any two vertices are connected by exactly one path. In other
 * words, any connected graph without simple cycles is a tree.”
 * 
 * @author zhoudong
 *
 */
public class GraphValidTree {

	public boolean validTree(int n, int[][] edges) {
		UnionFind unionFind = new UnionFind(n);
		for (int[] edge : edges) {
			if (unionFind.isConnected(edge[0], edge[1]))
				return false;
			unionFind.union(edge[0], edge[1]);
		}
		return unionFind.count == 1;
	}

	class UnionFind {
		int[] roots = null;
		int count = 0;

		public UnionFind(int n) {
			roots = new int[n];
			for (int i = 0; i < n; i++)
				roots[i] = i;
			count = n;
		}

		public void union(int x, int y) {
			if (isConnected(x, y))
				return;
			int rootY = roots[y];
			for (int i = 0; i < roots.length; i++) {
				if (roots[i] == y || roots[i] == rootY) {
					roots[i] = roots[x];
				}
			}
			count--;
		}

		public boolean isConnected(int x, int y) {
			return roots[x] == roots[y];
		}
	}

}
