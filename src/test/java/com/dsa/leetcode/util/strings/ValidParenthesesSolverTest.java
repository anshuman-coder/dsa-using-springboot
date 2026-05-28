package com.dsa.leetcode.util.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidParenthesesSolverTest {
  private final ValidParenthesesSolver solver = new ValidParenthesesSolver();

  @Test
  void validWithSinglePair() {
    assertThat(solver.solve("()")).isTrue();
  }

  @Test
  void validWithMixedBrackets() {
    assertThat(solver.solve("()[]{}")).isTrue();
  }

  @Test
  void validWithNestedBrackets() {
    assertThat(solver.solve("{[()]}")).isTrue();
  }

  @Test
  void invalidWrongClosingOrder() {
    assertThat(solver.solve("(]")).isFalse();
  }

  @Test
  void invalidUnclosedOpening() {
    assertThat(solver.solve("(()")).isFalse();
  }

  @Test
  void invalidClosingWithoutOpening() {
    assertThat(solver.solve(")")).isFalse();
  }

  @Test
  void emptyStringIsValid() {
    assertThat(solver.solve("")).isTrue();
  }
}
