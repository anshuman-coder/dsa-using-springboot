package com.dsa.leetcode.model.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProblemResponse<I, R> {

    private final List<TestResult<I, R>> tests;
}
