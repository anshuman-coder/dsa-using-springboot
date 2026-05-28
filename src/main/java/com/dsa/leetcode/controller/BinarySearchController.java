package com.dsa.leetcode.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.leetcode.model.request.BinarySearchInput;
import com.dsa.leetcode.model.request.ProblemRequest;
import com.dsa.leetcode.model.response.ApiResponse;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.service.BinarySearchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Binary Search")
public class BinarySearchController {
  private final BinarySearchService binarySearchService;

  @PostMapping("/binary-search")
  @Operation(
    summary = "LC #6 - Binary Search",
    description = "Topic: Binary Search | Given sorted array nums and target, return index if found, else -1."
  )
  public ApiResponse<ProblemResponse<BinarySearchInput, Integer>> binarySearch(
    @Valid @RequestBody ProblemRequest<BinarySearchInput> request
  ) {
    return ApiResponse.ok(binarySearchService.solve(request.getTests()));
  }
}
