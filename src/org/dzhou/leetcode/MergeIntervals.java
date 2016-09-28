package org.dzhou.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 56. Merge Intervals
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * 
 * Given [1,3],[2,6],[8,10],[15,18],
 * 
 * return [1,6],[8,10],[15,18].
 * 
 * @author zhoudong
 *
 */
public class MergeIntervals {

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public class Solution {

		public List<Interval> merge(List<Interval> intervals) {
			if (intervals == null || intervals.size() < 2)
				return intervals;
			Collections.sort(intervals, new IntervalComparator());
			return mergeSorted(intervals);
		}

		private List<Interval> mergeSorted(List<Interval> intervals) {
			List<Interval> result = new LinkedList<>();
			Interval current = null;
			for (int i = 0; i < intervals.size(); i++) {
				if (current == null) {
					current = intervals.get(i);
				}
				if (isLast(intervals, i) || noOverlap(current, intervals.get(i + 1))) {
					result.add(current);
					current = null;
				} else {
					current = merge(current, intervals.get(i + 1));
				}
			}
			return result;
		}

		private boolean isLast(List<Interval> intervals, int index) {
			return index == intervals.size() - 1;
		}

		private boolean noOverlap(Interval current, Interval next) {
			return current.end < next.start;
		}

		private Interval merge(Interval current, Interval next) {
			int min = Math.min(current.start, next.start);
			int max = Math.max(current.end, next.end);
			return new Interval(min, max);
		}

		private class IntervalComparator implements Comparator<Interval> {
			@Override
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		}

	}

}
