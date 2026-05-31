package com.dsa.leetcode.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.leetcode.model.request.ClimbingStairsInput;
import com.dsa.leetcode.model.request.ProblemRequest;
import com.dsa.leetcode.model.response.ApiResponse;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.service.ClimbingStairsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Climbing Stairs")
public class ClimbingStairsController {
  private final ClimbingStairsService climbingStairsService;

  @PostMapping("/climbing-stairs")
  @Operation(
    summary = "LC #7 - Climbing Stairs",
    description = "Topic: Dynamic Programming & Fibonacci Series | n steps to the top; each time you can climb 1 or 2 steps. In how many distinct ways can you reach the top?"
  )
  public ApiResponse<ProblemResponse<ClimbingStairsInput, Integer>> climbingStairs(
    @Valid @RequestBody ProblemRequest<ClimbingStairsInput> request
  ) {
    return ApiResponse.ok(climbingStairsService.solve(request.getTests()));
  }
}
