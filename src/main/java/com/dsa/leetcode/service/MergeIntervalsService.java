package com.dsa.leetcode.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dsa.leetcode.model.request.MergeIntervalsInput;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.model.response.TestResult;
import com.dsa.leetcode.util.arrays.MergeIntervalsSolver;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MergeIntervalsService {
  private final MergeIntervalsSolver mergeIntervalsSolver;

  public ProblemResponse<MergeIntervalsInput, int[][]> solve(List<MergeIntervalsInput> tests) {
    List <TestResult<MergeIntervalsInput, int[][]>> results = tests.stream()
      .map(input -> {
        int[][] result = mergeIntervalsSolver.solve(input.getIntervals());
        return TestResult.<MergeIntervalsInput, int[][]>builder()
          .input(input)
          .result(result)
          .satisfied(Arrays.deepEquals(result, input.getAnswer()))
          .build();
      })
    .toList();
    return ProblemResponse.<MergeIntervalsInput, int[][]>builder()
      .tests(results)
      .build();
  }
}
