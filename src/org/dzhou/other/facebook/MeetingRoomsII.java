package org.dzhou.other.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 253. Meeting Rooms II
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 * 
 * Tags: Heap Greedy Sort
 * 
 * @author zhoudong
 *
 */
public class MeetingRoomsII {

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

		public int minMeetingRooms(Interval[] intervals) {
			if (intervals == null || intervals.length == 0) {
				return 0;
			}

			Arrays.sort(intervals, (Interval o1, Interval o2) -> {
				return o1.start - o2.start;
			});

			PriorityQueue<Integer> heap = new PriorityQueue<>();
			heap.add(intervals[0].end);

			for (int i = 1; i < intervals.length; i++) {
				Interval current = intervals[i];
				if (current.start >= heap.peek()) {
					heap.poll();
				}
				heap.add(current.end);
			}

			return heap.size();
		}

	}

}
