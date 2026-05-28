package com.dsa.leetcode.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MergeIntervalsInput {
  @NotNull(message = "Interval array list cannot be null or empty")
  @NotEmpty(message = "Interval array list cannot be null or empty")
  private int[][] intervals;

  @NotNull(message = "expected answer array list cannot be null or empty")
  @NotEmpty(message = "expected answer array list cannot be null or empty")
  private int[][] answer;
}
