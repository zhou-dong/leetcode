package org.dzhou.leetcode;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * 
 * @author zhoudong
 *
 */
public class ImplementQueueUsingStacks {

	class MyQueue {

		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		// Push element x to the back of queue.
		public void push(int x) {
			stack1.push(x);
		}

		// Removes the element from in front of queue.
		public void pop() {
			transfer();
			stack2.pop();
		}

		// Get the front element.
		public int peek() {
			transfer();
			return stack2.peek();
		}

		// Return whether the queue is empty.
		public boolean empty() {
			return stack1.isEmpty() && stack2.isEmpty();
		}

		private void transfer() {
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
		}

	}
}
