package org.dzhou.leetcode;

import java.util.Stack;

/**
 * 155. Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack.<br>
 * pop() -- Removes the element on top of the stack.<br>
 * top() -- Get the top element.<br>
 * getMin() -- Retrieve the minimum element in the stack.<br>
 * 
 * Example:<br>
 * 
 * MinStack minStack = new MinStack();<br>
 * minStack.push(-2);<br>
 * minStack.push(0);<br>
 * minStack.push(-3);<br>
 * minStack.getMin(); --> Returns -3.<br>
 * minStack.pop();<br>
 * minStack.top(); --> Returns 0.<br>
 * minStack.getMin(); --> Returns -2.<br>
 * 
 * @author zhoudong
 *
 */
public class MinStack {

	public class Modify_Node_Solution {
		class Node {
			int val;
			int min;
			Node next;

			public Node(int val) {
				this.val = val;
			}

			public Node(int val, int min) {
				this(val);
				this.min = min;
			}
		}

		Node top = null;

		public void push(int x) {
			if (top == null) {
				top = new Node(x, x);
			} else {
				int min = Math.min(x, top.min);
				Node node = new Node(x, min);
				node.next = top;
				top = node;
			}
		}

		public void pop() {
			top = top.next;
		}

		public int top() {
			return top == null ? 0 : top.val;
		}

		public int getMin() {
			return top != null ? top.min : 0;
		}
	}

	public class Two_Stack_Solution {
		Stack<Integer> mins = new Stack<>();
		Stack<Integer> vals = new Stack<>();

		public void push(int x) {
			int min = vals.isEmpty() ? x : Math.min(x, mins.peek());
			mins.add(min);
			vals.add(x);
		}

		public void pop() {
			mins.pop();
			vals.pop();
		}

		public int top() {
			return vals.peek();
		}

		public int getMin() {
			return mins.peek();
		}
	}

	// Your MinStack object will be instantiated and called as such:
	// MinStack obj = new MinStack();
	// obj.push(x);
	// obj.pop();
	// int param_3 = obj.top();
	// int param_4 = obj.getMin();
}
