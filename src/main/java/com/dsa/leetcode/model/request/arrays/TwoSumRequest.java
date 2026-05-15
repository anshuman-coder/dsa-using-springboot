package com.dsa.leetcode.model.request.arrays;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TwoSumRequest {

    @NotNull(message = "nums array is required")
    @NotEmpty(message = "nums array must not be empty")
    private int[] nums;

    @NotNull(message = "target is required")
    private Integer target;
}
