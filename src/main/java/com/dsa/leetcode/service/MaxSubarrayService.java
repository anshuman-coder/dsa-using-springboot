package com.dsa.leetcode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dsa.leetcode.model.request.MaxSubarrayInput;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.model.response.TestResult;
import com.dsa.leetcode.util.arrays.MaxSubarraySolver;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaxSubarrayService {
  private final MaxSubarraySolver maxSubarraySolver;

  public ProblemResponse<MaxSubarrayInput, Integer> solve(List<MaxSubarrayInput> tests) {
    List<TestResult<MaxSubarrayInput, Integer>> results = tests.stream()
      .map(input -> {
        int result = maxSubarraySolver.solver(input.getNums());

        return TestResult.<MaxSubarrayInput, Integer>builder()
          .input(input)
          .result(result)
          .satisfied(result == input.getAnswer())
          .build();
      })
      .toList();

    return ProblemResponse.<MaxSubarrayInput, Integer>builder()
      .tests(results)
      .build();
  }
}
