package com.dsa.leetcode.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsa.leetcode.model.request.ProblemRequest;
import com.dsa.leetcode.model.request.ReverseLinkedListInput;
import com.dsa.leetcode.model.response.ApiResponse;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.service.ReverseLinkedListService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Reverse Linked List")
public class ReverseLinkedListController {
  private final ReverseLinkedListService reverseLinkedListService;

  @PostMapping("/reverse-linked-list")
  @Operation(
    summary = "LC #8 - Reverse Linked List",
    description = "Topic: Linked List | Given the head of a singly linked list, reverse it and return the new head."
  )
  public ApiResponse<ProblemResponse<ReverseLinkedListInput, Integer>> reverseLinkedList(
    @Valid @RequestBody ProblemRequest<ReverseLinkedListInput> request
  ) {
    return ApiResponse.ok(reverseLinkedListService.solve(request.getTests()));
  }
}
