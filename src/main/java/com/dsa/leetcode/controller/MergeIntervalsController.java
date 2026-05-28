package com.dsa.leetcode.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.leetcode.model.request.MergeIntervalsInput;
import com.dsa.leetcode.model.request.ProblemRequest;
import com.dsa.leetcode.model.response.ApiResponse;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.service.MergeIntervalsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Merge Intervals")
public class MergeIntervalsController {
  private final MergeIntervalsService mergeIntervalsService;

  @PostMapping("merge-intervals")
  @Operation(
    summary = "LC #5 — Merge Intervals",
    description = "Topic: Array | Return an array of the non-overlapping intervals that cover all the intervals in the input."
  )
  public ApiResponse<ProblemResponse<MergeIntervalsInput, int[][]>> mergeIntervals(
    @Valid @RequestBody ProblemRequest<MergeIntervalsInput> request
  ) {
    return ApiResponse.ok(mergeIntervalsService.solve(request.getTests()));
  }
}
