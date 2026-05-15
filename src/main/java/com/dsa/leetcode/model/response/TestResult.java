package com.dsa.leetcode.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestResult<I, R> {

    private final I input;
    private final R result;
    private final boolean satisfied;
}
