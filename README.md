# MergeUnsortedIntervals
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.

# Solution:

1. A list of intervals is recevied as function parameter.

2. Create a comparator which will sort the intervals by start value.
private Comparator<Interval> IntervalComparator = Comparator.comparingInt(interval -> interval.start);

3. Sort the intervals by passing in the comparator, which will result in sorting the intervals by start value.

4. Loop through the intervals. Store first value of sorted list in prevInterval and start the loop from second value in sorted interval list.

5. Call the interval currInterval. Do the following comparison
if (currInterval.start >= prevInterval.start && currInterval.start <= prevInterval.end)

6. else save the interval in merged intervals

7. return merged intervals
