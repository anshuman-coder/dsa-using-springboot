package com.dsa.leetcode.util.arrays;

import org.springframework.stereotype.Component;

/**
 * This solution is divided into multiple small components/steps.
 * 1) Finding the maximum start value to create a linear Array of max + 1.
 * 2) Fill/populate the linear array with values.
 * 3) Scan the linear Array and merge it into 2D Array.
 */
@Component
public class MergeIntervalsSolver {


  private int findMaxStart(int[][] intervals) {
    int max = 0;
    for (int[] interval : intervals) {
      int start = interval[0];
      max = Math.max(start, max);
    }

    return max;
  }

  private int[] fillMap(int[][] intervals, int length) {
    int[] map = new int[length];
    for (int[] inte : intervals) {
      int start = inte[0];
      int end = inte[1];
      map[start] = end + 1;
    }
    return map;
  }

  private int[][] scanAndMerge(int[][] intervals, int[] mapped) {
    int mergeCount = 0, start = -1, end = -1;

    for (int i = 0; i < mapped.length; i++) {
      if(mapped[i] != 0) {
        if(start == -1) start = i;
        end = Math.max(end, mapped[i] - 1);
      }

      if(i == end) {
        intervals[mergeCount++] = new int[] {start, end};
        start = -1; end = -1;                             //reset the start and end indexes to handle next set
      }
    }

    if (start != -1) {
      intervals[mergeCount++] = new int[] { start, end };
    }

    int[][] res = new int[mergeCount][];
    for (int i = 0; i < mergeCount; i++) {
      res[i] = intervals[i];
    }

    return res;
  }

  public int[][] solve(int[][] intervals) {
    //step 1: finding the max start.
    int maxStart = this.findMaxStart(intervals);
    //step 2: populating the linear array
    int[] map = this.fillMap(intervals, maxStart + 1);
    //step3: scanning and merging the 2d array list.
    return this.scanAndMerge(intervals, map);
  }
}
