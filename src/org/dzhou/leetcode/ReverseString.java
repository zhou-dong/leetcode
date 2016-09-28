package org.dzhou.leetcode;

import java.util.Stack;

/**
 * 344. Reverse String
 * 
 * Write a function that takes a string as input and returns the string
 * reversed.
 * 
 * Example: Given s = "hello", return "olleh".
 * 
 * @author zhoudong
 *
 */
public class ReverseString {

	public class Two_Pointer_Solution {
		public String reverseString(String s) {
			char[] reversed = new char[s.length()];
			for (int i = 0, j = reversed.length - 1; i <= j; i++, j--) {
				reversed[i] = s.charAt(j);
				reversed[j] = s.charAt(i);
			}
			return new String(reversed);
		}
	}

	public class One_Pointer_Solution {
		public String reverseString(String s) {
			char[] reversed = new char[s.length()];
			for (int i = 0; i < s.length(); i++)
				reversed[i] = s.charAt(s.length() - 1 - i);
			return new String(reversed);
		}
	}

	public class Stack_Solution {
		public String reverseString(String s) {
			Stack<Character> stack = new Stack<>();
			for (char c : s.toCharArray())
				stack.push(c);
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty())
				sb.append(stack.pop());
			return sb.toString();
		}
	}

	public class StringBuilder_Solution {
		public String reverseString(String s) {
			return new StringBuilder(s).reverse().toString();
		}
	}

	// java.lang.StackOverflowError
	public class Recursive_Solution {
		public String reverseString(String s) {
			if (s == null || s.length() == 0)
				return s;
			StringBuilder sb = new StringBuilder();
			dfs(s, sb, 0);
			return sb.toString();
		}

		private void dfs(String s, StringBuilder sb, int index) {
			if (index != s.length() - 1)
				dfs(s, sb, index + 1);
			sb.append(s.charAt(index));
		}
	}

}
