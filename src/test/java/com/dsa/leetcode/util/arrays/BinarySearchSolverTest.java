package com.dsa.leetcode.util.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchSolverTest {
  private final BinarySearchSolver solver = new BinarySearchSolver();

  @Test
  void targetFoundInMiddle() {
    assertThat(solver.solve(new int[]{-1, 0, 3, 5, 9, 12}, 9)).isEqualTo(4);
  }

  @Test
  void targetFoundAtStart() {
    assertThat(solver.solve(new int[]{1, 3, 5, 7, 9}, 1)).isEqualTo(0);
  }

  @Test
  void targetFoundAtEnd() {
    assertThat(solver.solve(new int[]{1, 3, 5, 7, 9}, 9)).isEqualTo(4);
  }

  @Test
  void targetNotFound() {
    assertThat(solver.solve(new int[]{-1, 0, 3, 5, 9, 12}, 2)).isEqualTo(-1);
  }

  @Test
  void singleElementFound() {
    assertThat(solver.solve(new int[]{5}, 5)).isEqualTo(0);
  }

  @Test
  void singleElementNotFound() {
    assertThat(solver.solve(new int[]{5}, 3)).isEqualTo(-1);
  }

  @Test
  void negativeNumbers() {
    assertThat(solver.solve(new int[]{-10, -5, -3, 0, 2}, -3)).isEqualTo(2);
  }
}
