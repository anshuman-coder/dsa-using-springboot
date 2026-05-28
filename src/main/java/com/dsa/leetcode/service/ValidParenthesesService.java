package com.dsa.leetcode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dsa.leetcode.model.request.ValidParenthesesInput;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.model.response.TestResult;
import com.dsa.leetcode.util.strings.ValidParenthesesSolver;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ValidParenthesesService {
  private final ValidParenthesesSolver validParenthesesSolver;

  public ProblemResponse<ValidParenthesesInput, Boolean> solve(List<ValidParenthesesInput> tests) {
    List<TestResult<ValidParenthesesInput, Boolean>> results = tests.stream()
      .map(input -> {
        boolean result = validParenthesesSolver.solve(input.getQuery());

        return TestResult.<ValidParenthesesInput, Boolean>builder()
          .input(input)
          .result(result)
          .satisfied(result == input.getAnswer().booleanValue())
          .build();
      })
      .toList();

    return ProblemResponse.<ValidParenthesesInput, Boolean>builder()
      .tests(results)
      .build();
  }
}
