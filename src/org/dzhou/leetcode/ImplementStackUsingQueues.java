package org.dzhou.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * 
 * @author zhoudong
 *
 */
public class ImplementStackUsingQueues {

	class MyStack_TwoQueue {

		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();

		// Push element x onto stack.
		public void push(int x) {
			queue1.offer(x);
		}

		// Removes the element on top of the stack.
		public void pop() {
			transfer();
			queue1.poll();
			swap();
		}

		// Get the top element.
		public int top() {
			transfer();
			int val = queue1.poll();
			queue2.offer(val);
			swap();
			return val;
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return queue1.isEmpty();
		}

		private void transfer() {
			while (queue1.size() > 1) {
				queue2.offer(queue1.poll());
			}
		}

		private void swap() {
			Queue<Integer> temp = queue1;
			queue1 = queue2;
			queue2 = temp;
		}

	}

	class MyStack_TwoQueue2 {

		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();

		// Push element x onto stack.
		public void push(int x) {
			queue2.offer(x);
			while (!queue1.isEmpty()) {
				queue2.offer(queue1.poll());
			}
			swap();
		}

		// Removes the element on top of the stack.
		public void pop() {
			queue1.poll();
		}

		// Get the top element.
		public int top() {
			return queue1.peek();
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return queue1.isEmpty();
		}

		private void swap() {
			Queue<Integer> temp = queue1;
			queue1 = queue2;
			queue2 = temp;
		}

	}

	class MyStack_OneQueue {

		Queue<Integer> queue = new LinkedList<>();

		// Push element x onto stack.
		public void push(int x) {
			queue.offer(x);
		}

		// Removes the element on top of the stack.
		public void pop() {
			transfer();
			queue.poll();
		}

		// Get the top element.
		public int top() {
			transfer();
			int val = queue.poll();
			queue.offer(val);
			return val;
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return queue.isEmpty();
		}

		private void transfer() {
			int size = queue.size();
			for (int i = 0; i < size - 1; i++) {
				queue.offer(queue.poll());
			}
		}

	}

}
