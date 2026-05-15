package com.dsa.leetcode.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProblemRequest<T> {

    @NotNull(message = "tests array is required")
    @NotEmpty(message = "tests array must not be empty")
    private List<T> tests;
}
