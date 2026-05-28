package com.dsa.leetcode.util.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxSubarraySolverTest {
  private final MaxSubarraySolver solver = new MaxSubarraySolver();

  @Test
  void basicCase() {
    assertThat(solver.solver(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})).isEqualTo(6);
  }

  @Test
  void allPositive() {
    assertThat(solver.solver(new int[]{1, 2, 3, 4})).isEqualTo(10);
  }

  @Test
  void allNegative() {
    assertThat(solver.solver(new int[]{-1, -2, -3, -4})).isEqualTo(-1);
  }

  @Test
  void singlePositiveElement() {
    assertThat(solver.solver(new int[]{5})).isEqualTo(5);
  }

  @Test
  void singleNegativeElement() {
    assertThat(solver.solver(new int[]{-5})).isEqualTo(-5);
  }

  @Test
  void emptyArray() {
    assertThat(solver.solver(new int[]{})).isEqualTo(0);
  }
}
