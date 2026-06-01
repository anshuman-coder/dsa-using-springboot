package com.dsa.leetcode.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReverseLinkedListInput {
  @NotNull(message = "The linkedList cannot be null.")
  @NotEmpty(message = "The linkedList cannot be empty.")
  private Integer[] list;

  @NotNull(message = "Provided answer cannot be null.")
  private Integer answer;
}
