package com.dsa.leetcode.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TwoSumInput {

    @NotNull(message = "nums is required")
    @NotEmpty(message = "nums must not be empty")
    private int[] nums;

    @NotNull(message = "target is required")
    private Integer target;
}
