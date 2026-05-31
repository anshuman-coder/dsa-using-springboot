package com.dsa.leetcode.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClimbingStairsInput {
  @NotNull(message = "Num cannot be null.")
  @Positive(message = "Num cannot be zero or negative number.")
  private Integer num;

  @NotNull(message = "answer cannot be null.")
  private Integer answer;

}
