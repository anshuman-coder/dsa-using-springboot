package com.dsa.leetcode.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.leetcode.model.request.ProblemRequest;
import com.dsa.leetcode.model.request.ValidParenthesesInput;
import com.dsa.leetcode.model.response.ApiResponse;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.service.ValidParenthesesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Valid Parentheses")
public class ValidParenthesesController {
  private final ValidParenthesesService validParenthesesService;

  @PostMapping("/valid-parentheses")
  @Operation(
    summary = "LC #3 - Valid Parentheses",
    description = "Topic: Stack | Open brackets must be closed in the correct order"
  )
  public ApiResponse<ProblemResponse<ValidParenthesesInput, Boolean>> validParentheses(
    @Valid @RequestBody ProblemRequest<ValidParenthesesInput> request
  ) {
    return ApiResponse.ok(validParenthesesService.solve(request.getTests()));
  }
}
