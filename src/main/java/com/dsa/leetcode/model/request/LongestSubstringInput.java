package com.dsa.leetcode.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LongestSubstringInput {

  @NotNull(message = "string input is required")
  private String str;

  @NotNull(message = "answer is required to validate the test result")
  private Integer answer;
}