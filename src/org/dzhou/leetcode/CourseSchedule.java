package org.dzhou.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 207. Course Schedule
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]] <br>
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]] <br>
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0, and to take course 0 you should also have finished course
 * 1. So it is impossible.
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * 
 * Hints:
 * 
 * This problem is equivalent to finding if a cycle exists in a directed graph.
 * If a cycle exists, no topological ordering exists and therefore it will be
 * impossible to take all courses.
 * 
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
 * explaining the basic concepts of Topological Sort.
 * 
 * Topological sort could also be done via BFS.
 * 
 * @author zhoudong
 *
 */
public class CourseSchedule {

	public class Topological_Sort_Solution {
		Set<Integer> visiting = new HashSet<>();
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();

		public boolean canFinish(int numCourses, int[][] prerequisites) {
			Map<Integer, Set<Integer>> graph = createGraph(prerequisites);
			for (int vertex : graph.keySet()) {
				if (hasCycle(graph, vertex)) {
					return false;
				}
			}
			return true;
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

		private boolean hasCycle(Map<Integer, Set<Integer>> graph, int vertex) {
			if (!graph.containsKey(vertex)) {
				stack.push(vertex);
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
				if (hasCycle(graph, connect)) {
					return true;
				}
			}
			visiting.remove(vertex);
			visited.add(vertex);
			stack.push(vertex);
			return false;
		}
	}

	public class DFS_Solution {
		Set<Integer> visiting = new HashSet<>();
		Set<Integer> visited = new HashSet<>();

		public boolean canFinish(int numCourses, int[][] prerequisites) {
			Map<Integer, Set<Integer>> graph = createGraph(prerequisites);
			for (int vertex : graph.keySet()) {
				if (hasCycle(graph, vertex)) {
					return false;
				}
			}
			return true;
		}

		private boolean hasCycle(Map<Integer, Set<Integer>> graph, int vertex) {
			if (!graph.containsKey(vertex)) {
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
				if (hasCycle(graph, connect)) {
					return true;
				}
			}
			visiting.remove(vertex);
			visited.add(vertex);
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

	// Remove Tail
}
