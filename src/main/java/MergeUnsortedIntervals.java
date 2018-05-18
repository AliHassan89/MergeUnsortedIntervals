/**

 Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considerred overlapping.

 */

package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeUnsortedIntervals {
  public List<Interval> merge(List<Interval> intervals) {
    List<Interval> merged = new ArrayList<>();
    if (intervals.isEmpty())
      return merged;

    Collections.sort(intervals, IntervalComparator);

    Interval prevInterval = intervals.get(0);
    for (int i=1; i<intervals.size(); i++)
    {
      Interval currInterval = intervals.get(i);
      if (currInterval.start >= prevInterval.start && currInterval.start <= prevInterval.end)
      {
        Interval subMergedInterval = mergeIntervals(prevInterval, currInterval);
        prevInterval = subMergedInterval;
      }
      else
      {
        merged.add(prevInterval);
        prevInterval = currInterval;
      }
    }

    merged.add(prevInterval);
    return merged;
  }

  private Interval mergeIntervals(Interval interval_1, Interval interval_2)
  {
    Interval merged;
    if (interval_1.start <= interval_2.start && interval_1.end <= interval_2.end)
    {
      merged = new Interval(interval_1.start, interval_2.end);
    }
    else if (interval_1.start <= interval_2.start && interval_1.end > interval_2.end){
      merged = new Interval(interval_1.start, interval_1.end);
    }
    else{
      merged = new Interval(interval_2.start, interval_1.end);
    }

    return merged;
  }

  private Comparator<Interval> IntervalComparator = Comparator.comparingInt(interval -> interval.start);
}
