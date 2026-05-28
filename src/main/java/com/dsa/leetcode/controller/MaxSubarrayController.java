package com.dsa.leetcode.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.leetcode.model.request.MaxSubarrayInput;
import com.dsa.leetcode.model.request.ProblemRequest;
import com.dsa.leetcode.model.response.ApiResponse;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.service.MaxSubarrayService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Maximum Subarray (Kadane's)")
public class MaxSubarrayController {
  private final MaxSubarrayService maxSubarrayService;

  @PostMapping("maximum-subarray")
  @Operation(
    summary = "LC #4 - Maximum Subarray (Kadane's)",
    description = "Given integer array nums, find the contiguous subarray with the largest sum and return its sum."
  )
  public ApiResponse<ProblemResponse<MaxSubarrayInput, Integer>> maxSubarray(
    @Valid @RequestBody ProblemRequest<MaxSubarrayInput> request
  ) {
    return ApiResponse.ok(maxSubarrayService.solve(request.getTests()));
  }
}
