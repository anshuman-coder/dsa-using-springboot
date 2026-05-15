package com.dsa.leetcode.util.arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumSolverTest {

    private final TwoSumSolver solver = new TwoSumSolver();

    @Test
    void basicCase() {
        assertThat(solver.solve(new int[]{2, 7, 11, 15}, 9)).containsExactly(0, 1);
    }

    @Test
    void duplicateValues() {
        assertThat(solver.solve(new int[]{3, 3}, 6)).containsExactly(0, 1);
    }

    @Test
    void noSolution() {
        assertThat(solver.solve(new int[]{1, 2, 3}, 100)).isEmpty();
    }
}
