package com.dsa.leetcode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dsa.leetcode.model.request.LongestSubstringInput;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.model.response.TestResult;
import com.dsa.leetcode.util.strings.LongestSubstringSolver;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LongestSubstringService {
  private final LongestSubstringSolver longestSubstringSolver;

  public ProblemResponse<LongestSubstringInput, Integer> solve(List<LongestSubstringInput> tests) {
    List<TestResult<LongestSubstringInput, Integer>> results = tests.stream()
      .map(input -> {
        int result = longestSubstringSolver.solve(input.getStr());
        return TestResult.<LongestSubstringInput, Integer>builder()
          .input(input)
          .result(result)
          .satisfied(result == input.getAnswer())
          .build();
      })
      .toList();

    return ProblemResponse.<LongestSubstringInput, Integer>builder()
      .tests(results)
      .build();
  }
}
