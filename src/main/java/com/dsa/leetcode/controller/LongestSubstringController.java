package com.dsa.leetcode.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.leetcode.model.request.LongestSubstringInput;
import com.dsa.leetcode.model.request.ProblemRequest;
import com.dsa.leetcode.model.response.ApiResponse;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.service.LongestSubstringService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Longest substring without repeating characters")
public class LongestSubstringController {
  private final LongestSubstringService longestSubstringService;

  @PostMapping("/longest-substring-without-repeating-characters")
  public ApiResponse<ProblemResponse<LongestSubstringInput, Integer>> longestSubstring(
    @Valid @RequestBody ProblemRequest<LongestSubstringInput> request
  ) {
    return ApiResponse.ok(longestSubstringService.solve(request.getTests()));
  }
}
