package com.dsa.leetcode.util.arrays;

import org.junit.jupiter.api.Test;

import com.dsa.leetcode.util.dp.ClimbingStairsSolver;

import static org.assertj.core.api.Assertions.assertThat;

class ClimbingStairsSolverTest {
  private final ClimbingStairsSolver solver = new ClimbingStairsSolver();

  @Test
  void oneStep() {
    assertThat(solver.solve(1)).isEqualTo(1);
  }

  @Test
  void twoSteps() {
    assertThat(solver.solve(2)).isEqualTo(2);
  }

  @Test
  void threeSteps() {
    assertThat(solver.solve(3)).isEqualTo(3);
  }

  @Test
  void fourSteps() {
    assertThat(solver.solve(4)).isEqualTo(5);
  }

  @Test
  void fiveSteps() {
    assertThat(solver.solve(5)).isEqualTo(8);
  }

  @Test
  void tenSteps() {
    assertThat(solver.solve(10)).isEqualTo(89);
  }
}
