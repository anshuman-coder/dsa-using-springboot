package com.dsa.leetcode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dsa.leetcode.model.request.BinarySearchInput;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.model.response.TestResult;
import com.dsa.leetcode.util.arrays.BinarySearchSolver;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BinarySearchService {
  private final BinarySearchSolver binarySearchSolver;

  public ProblemResponse<BinarySearchInput, Integer> solve(List<BinarySearchInput> tests) {
    List<TestResult<BinarySearchInput, Integer>> results = tests.stream()
      .map(input -> {
        int result = binarySearchSolver.solve(input.getNums(), input.getTarget());
        return TestResult.<BinarySearchInput, Integer>builder()
          .input(input)
          .result(result)
          .satisfied(result == input.getAnswer())
          .build();
      })
      .toList();

    return ProblemResponse.<BinarySearchInput, Integer>builder()
      .tests(results)
      .build();
  }
}
