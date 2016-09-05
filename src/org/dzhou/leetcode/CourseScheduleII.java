package org.dzhou.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 210. Course Schedule II
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]]
 * 
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * 
 * There are a total of 4 courses to take. To take course 3 you should have
 * finished both courses 1 and 2. Both courses 1 and 2 should be taken after you
 * finished course 0. So one correct course order is [0,1,2,3]. Another correct
 * ordering is[0,2,1,3].
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * 
 * Hints:
 * 
 * This problem is equivalent to finding the topological order in a directed
 * graph. If a cycle exists, no topological ordering exists and therefore it
 * will be impossible to take all courses.
 * 
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
 * explaining the basic concepts of Topological Sort.
 * 
 * Topological sort could also be done via BFS.
 * 
 * @author zhoudong
 *
 */
public class CourseScheduleII {

	public class BFS_Solution {

		public int[] findOrder(int numCourses, int[][] prerequisites) {

			Map<Integer, List<Integer>> graph = createGraph(prerequisites);

			int[] counter = new int[numCourses];
			for (int[] edge : prerequisites) {
				counter[edge[0]]++;
			}

			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < numCourses; i++) {
				if (counter[i] == 0) {
					queue.add(i); // course without preCourse
				}
			}

			int index = 0;
			int[] result = new int[numCourses];
			while (!queue.isEmpty()) {
				int course = queue.poll();
				result[index++] = course;
				if (graph.containsKey(course)) {
					for (int other : graph.get(course)) {
						if (--counter[other] == 0) {
							queue.add(other);
						}
					}
				}
			}

			return index == numCourses ? result : new int[0];
		}

		private Map<Integer, List<Integer>> createGraph(int[][] edges) {
			Map<Integer, List<Integer>> graph = new HashMap<>();
			for (int[] edge : edges) {
				if (!graph.containsKey(edge[1]))
					graph.put(edge[1], new ArrayList<>());
				graph.get(edge[1]).add(edge[0]);
			}
			return graph;
		}

	}

	public class Topological_Sort_Solution {

		Set<Integer> visiting = null;
		Set<Integer> visited = null;
		Stack<Integer> stack = null;
		Map<Integer, Set<Integer>> graph = null;

		public int[] findOrder(int numCourses, int[][] prerequisites) {
			graph = createGraph(prerequisites);
			visiting = new HashSet<>();
			visited = new HashSet<>();
			stack = new Stack<>();
			for (int vertex : graph.keySet()) {
				if (hasCycle(vertex)) {
					return new int[0];
				}
			}
			if (stack.size() < numCourses) {
				for (int i = 0; i < numCourses; i++) {
					if (!visited.contains(i)) {
						visited.add(i);
						stack.add(i);
					}
				}
			}
			int[] result = new int[numCourses];
			for (int i = 0; i < numCourses; i++) {
				result[i] = stack.pop();
			}
			return result;
		}

		private boolean hasCycle(int vertex) {
			if (!graph.containsKey(vertex)) {
				if (!visited.contains(vertex)) {
					visited.add(vertex);
					stack.add(vertex);
				}
				return false;
			}
			if (visited.contains(vertex)) {
				return false;
			}
			if (visiting.contains(vertex)) {
				return true;
			}
			visiting.add(vertex);
			for (int connect : graph.get(vertex)) {
				if (hasCycle(connect)) {
					return true;
				}
			}
			visiting.remove(vertex);
			visited.add(vertex);
			stack.add(vertex);
			return false;
		}

		private Map<Integer, Set<Integer>> createGraph(int[][] edges) {
			Map<Integer, Set<Integer>> graph = new HashMap<>();
			for (int[] edge : edges) {
				if (!graph.containsKey(edge[1]))
					graph.put(edge[1], new HashSet<>());
				graph.get(edge[1]).add(edge[0]);
			}
			return graph;
		}

	}

}
