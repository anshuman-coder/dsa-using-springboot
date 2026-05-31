package com.dsa.leetcode.util.dp;

import org.springframework.stereotype.Component;

@Component
public class ClimbingStairsSolver {

  public int solve(int num) {
    if(num <= 2) return num;

    int prev = 1, curr = 2;

    for (int i = 3; i <= num; i++) {
      int temp = curr;
      curr = prev + curr;
      prev = temp;
    }

    return curr;
  }
}
