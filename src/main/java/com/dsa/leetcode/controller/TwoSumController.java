package com.dsa.leetcode.controller;

import com.dsa.leetcode.model.request.ProblemRequest;
import com.dsa.leetcode.model.request.TwoSumInput;
import com.dsa.leetcode.model.response.ApiResponse;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.service.TwoSumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Two Sum", description = "LC #1 — Arrays")
public class TwoSumController {

    private final TwoSumService twoSumService;

    @PostMapping("/two-sum")
    @Operation(summary = "LC #1 — Two Sum",
               description = "Topic: Arrays | Returns indices of two numbers in nums that add up to target.")
    public ApiResponse<ProblemResponse<TwoSumInput, int[]>> twoSum(
            @Valid @RequestBody ProblemRequest<TwoSumInput> request) {
        return ApiResponse.ok(twoSumService.solve(request.getTests()));
    }
}
