package com.dsa.leetcode.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BinarySearchInput {
  
  @NotNull(message = "Nums array cannot be null.")
  @NotEmpty(message = "Nums array cannot be empty.")
  private int[] nums;

  @NotNull(message = "Target cannot be null.")
  private Integer target;

  @NotNull(message = "answer cannot be null.")
  private Integer answer;
}
