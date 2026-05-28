package com.dsa.leetcode.util.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringSolverTest {

    private final LongestSubstringSolver solver = new LongestSubstringSolver();

    @Test
    void repeatingCharsInMiddle() {
        assertThat(solver.solve("abcabcbb")).isEqualTo(3);
    }

    @Test
    void allSameChars() {
        assertThat(solver.solve("bbbbb")).isEqualTo(1);
    }

    @Test
    void emptyString() {
        assertThat(solver.solve("")).isEqualTo(0);
    }

    @Test
    void noRepeatingChars() {
        assertThat(solver.solve("abcdef")).isEqualTo(6);
    }
}
