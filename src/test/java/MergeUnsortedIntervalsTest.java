package test.java;

import java.util.ArrayList;
import java.util.List;
import main.java.Interval;
import main.java.MergeUnsortedIntervals;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class MergeUnsortedIntervalsTest {

  MergeUnsortedIntervals mergeUnsortedIntervals = new MergeUnsortedIntervals();

  @Test
  public void shouldTestEmptyInput(){
    //given
    List<Interval> intervals = new ArrayList<>();

    //when
    List<Interval> mergedIntervals = mergeUnsortedIntervals.merge(intervals);

    //then
    assertThat(mergedIntervals, notNullValue());
    assertThat(mergedIntervals.size(), equalTo(0));
  }

  @Test
  public void shouldTestSortedInput(){
    //given
    List<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(1,3));
    intervals.add(new Interval(2,6));
    intervals.add(new Interval(8,10));
    intervals.add(new Interval(15,18));

    //when
    List<Interval> mergedIntervals = mergeUnsortedIntervals.merge(intervals);

    //then
    assertThat(mergedIntervals, notNullValue());
    assertThat(mergedIntervals.size(), equalTo(3));
  }

  @Test
  public void shouldTestUnSortedInput(){
    //given
    List<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(2,6));
    intervals.add(new Interval(15,18));
    intervals.add(new Interval(8,10));
    intervals.add(new Interval(1,3));

    //when
    List<Interval> mergedIntervals = mergeUnsortedIntervals.merge(intervals);

    //then
    assertThat(mergedIntervals, notNullValue());
    assertThat(mergedIntervals.size(), equalTo(3));
  }

  @Test
  public void shouldTestSingleValue(){
    //given
    List<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(2,6));

    //when
    List<Interval> mergedIntervals = mergeUnsortedIntervals.merge(intervals);

    //then
    assertThat(mergedIntervals, notNullValue());
    assertThat(mergedIntervals.size(), equalTo(1));
  }

  @Test
  public void shouldTestForEdgeCase(){
    //given
    List<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(2,3));
    intervals.add(new Interval(1,4));

    //when
    List<Interval> mergedIntervals = mergeUnsortedIntervals.merge(intervals);

    //then
    assertThat(mergedIntervals, notNullValue());
    assertThat(mergedIntervals.size(), equalTo(1));
    Interval interval = mergedIntervals.get(0);
    assertThat(interval.start, equalTo(1));
    assertThat(interval.end, equalTo(4));
  }
}
