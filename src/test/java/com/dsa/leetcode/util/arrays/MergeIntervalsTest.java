package com.dsa.leetcode.util.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeIntervalsTest {
  private final MergeIntervalsSolver solver = new MergeIntervalsSolver();

  @Test
  void overlappingIntervals() {
    int[][] result = solver.solve(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    assertThat(result).isDeepEqualTo(new int[][]{{1, 6}, {8, 10}, {15, 18}});
  }

  @Test
  void touchingAtBoundary() {
    int[][] result = solver.solve(new int[][]{{1, 4}, {4, 5}});
    assertThat(result).isDeepEqualTo(new int[][]{{1, 5}});
  }

  @Test
  void noOverlap() {
    int[][] result = solver.solve(new int[][]{{1, 2}, {3, 4}});
    assertThat(result).isDeepEqualTo(new int[][]{{1, 2}, {3, 4}});
  }

  @Test
  void singleInterval() {
    int[][] result = solver.solve(new int[][]{{1, 4}});
    assertThat(result).isDeepEqualTo(new int[][]{{1, 4}});
  }

  @Test
  void allMergeIntoOne() {
    int[][] result = solver.solve(new int[][]{{1, 4}, {2, 5}, {3, 6}});
    assertThat(result).isDeepEqualTo(new int[][]{{1, 6}});
  }
}
