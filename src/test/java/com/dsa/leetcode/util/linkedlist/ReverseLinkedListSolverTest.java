package com.dsa.leetcode.util.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseLinkedListSolverTest {
  private final ReverseLinkedListSolver solver = new ReverseLinkedListSolver();

  @Test
  void basicCase() {
    assertThat(solver.solve(new Integer[]{1, 2, 3, 4, 5})).isEqualTo(5);
  }

  @Test
  void twoElements() {
    assertThat(solver.solve(new Integer[]{1, 2})).isEqualTo(2);
  }

  @Test
  void singleElement() {
    assertThat(solver.solve(new Integer[]{1})).isEqualTo(1);
  }

  @Test
  void alreadyReversed() {
    assertThat(solver.solve(new Integer[]{5, 4, 3, 2, 1})).isEqualTo(1);
  }

  @Test
  void negativeNumbers() {
    assertThat(solver.solve(new Integer[]{-3, -2, -1})).isEqualTo(-1);
  }

  @Test
  void duplicateValues() {
    assertThat(solver.solve(new Integer[]{1, 1, 2, 2, 3})).isEqualTo(3);
  }
}