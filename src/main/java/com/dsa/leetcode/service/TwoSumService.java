package com.dsa.leetcode.service;

import com.dsa.leetcode.model.request.TwoSumInput;
import com.dsa.leetcode.model.response.ProblemResponse;
import com.dsa.leetcode.model.response.TestResult;
import com.dsa.leetcode.util.arrays.TwoSumSolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TwoSumService {

    private final TwoSumSolver twoSumSolver;

    public ProblemResponse<TwoSumInput, int[]> solve(List<TwoSumInput> tests) {
        List<TestResult<TwoSumInput, int[]>> results = tests.stream()
                .map(input -> {
                    int[] result = twoSumSolver.solve(input.getNums(), input.getTarget());
                    return TestResult.<TwoSumInput, int[]>builder()
                            .input(input)
                            .result(result)
                            .satisfied(result.length > 0)
                            .build();
                })
                .toList();

        return ProblemResponse.<TwoSumInput, int[]>builder()
                .tests(results)
                .build();
    }
}
