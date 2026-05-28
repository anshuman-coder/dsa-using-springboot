package com.dsa.leetcode.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ValidParenthesesInput {
  @NotNull(message = "query string cannot be null.")
  private String query;

  @NotNull(message = "Answer cannot be null.")
  private Boolean answer;
}
