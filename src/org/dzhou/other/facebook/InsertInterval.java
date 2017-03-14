package org.dzhou.other.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author zhoudong
 *
 */
public class InsertInterval {

	// Definition for an interval.
	class Interval {
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

	class Solution {

		public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
			int insertPosition = findInsertPosition(intervals, newInterval);
			intervals.add(insertPosition, newInterval);
			return merge(intervals);
		}

		private int findInsertPosition(List<Interval> intervals, Interval newInterval) {
			for (int i = 0; i < intervals.size(); i++) {
				if (newInterval.start <= intervals.get(i).start) {
					return i;
				}
			}
			return intervals.size();
		}

		private List<Interval> merge(List<Interval> intervals) {
			List<Interval> result = new ArrayList<>();
			Interval current = null;
			for (int i = 0; i < intervals.size(); i++) {
				if (current == null) {
					current = intervals.get(i);
				}
				if (isLast(intervals, i) || noOverLap(current, intervals.get(i + 1))) {
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

		private boolean noOverLap(Interval first, Interval second) {
			return first.end < second.start;
		}

		private Interval merge(Interval first, Interval second) {
			return new Interval(first.start, Math.max(first.end, second.end));
		}

	}

}
