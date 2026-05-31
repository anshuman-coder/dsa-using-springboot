package com.dsa.leetcode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dsa.leetcode.model.request.ClimbingStairsInput;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.model.response.TestResult;
import com.dsa.leetcode.util.dp.ClimbingStairsSolver;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClimbingStairsService {
  private final ClimbingStairsSolver climbingStairsSolver;

  public ProblemResponse<ClimbingStairsInput, Integer> solve(List<ClimbingStairsInput> tests) {
    List<TestResult<ClimbingStairsInput, Integer>> results = tests.stream()
      .map(input -> {
        int result = climbingStairsSolver.solve(input.getNum());
        return TestResult.<ClimbingStairsInput, Integer>builder()
          .input(input)
          .result(result)
          .satisfied(result == input.getAnswer())
          .build();
      })
      .toList();

    return ProblemResponse.<ClimbingStairsInput, Integer>builder()
      .tests(results)
      .build();
  }
}
