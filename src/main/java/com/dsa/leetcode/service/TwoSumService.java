package com.dsa.leetcode.service;

import com.dsa.leetcode.util.arrays.TwoSumSolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TwoSumService {

    private final TwoSumSolver twoSumSolver;

    public int[] solve(int[] nums, int target) {
        return twoSumSolver.solve(nums, target);
    }
}
