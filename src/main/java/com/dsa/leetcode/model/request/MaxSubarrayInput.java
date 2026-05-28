package com.dsa.leetcode.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MaxSubarrayInput {
  @NotNull(message = "nums cannot be null.")
  int[] nums;

  @NotNull(message = "Answer cannot be null.")
  int answer;
}
