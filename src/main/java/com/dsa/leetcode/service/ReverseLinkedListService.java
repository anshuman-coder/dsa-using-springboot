package com.dsa.leetcode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dsa.leetcode.model.request.ReverseLinkedListInput;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.model.response.TestResult;
import com.dsa.leetcode.util.linkedlist.ReverseLinkedListSolver;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReverseLinkedListService {
  private final ReverseLinkedListSolver reverseLinkedListSolver;

  public ProblemResponse<ReverseLinkedListInput, Integer> solve(List<ReverseLinkedListInput> tests) {
    List<TestResult<ReverseLinkedListInput, Integer>> results = tests.stream()
      .map(input -> {
        int result = reverseLinkedListSolver.solve(input.getList());
        return TestResult.<ReverseLinkedListInput, Integer>builder()
          .input(input)
          .result(result)
          .satisfied(result == input.getAnswer())
          .build();
      })
      .toList();
    return ProblemResponse.<ReverseLinkedListInput, Integer>builder()
      .tests(results)
      .build();
  }
}
