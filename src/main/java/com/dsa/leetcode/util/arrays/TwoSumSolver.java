package com.dsa.leetcode.util.arrays;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #1 — Two Sum
 * Given an array of integers and a target, return indices of two numbers that add up to the target.
 * Time: O(n)  |  Space: O(n)
 */
@Component
public class TwoSumSolver {

    public int[] solve(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{};
    }
}
