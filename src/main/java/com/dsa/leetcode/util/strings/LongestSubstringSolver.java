package com.dsa.leetcode.util.strings;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class LongestSubstringSolver {
  public Integer solve(String s) {
    HashMap<Character, Integer> map = new HashMap<>();

    int start = 0;
    int maxLen = 0;
    for (int end = 0; end < s.length(); end++) {
      char current = s.charAt(end);
      if(map.containsKey(current)) {
        start = Math.max(start, map.get(current) + 1);
      }

      map.put(current, end);
      maxLen = Math.max(maxLen, end - start + 1);
    }
    return maxLen;
  }
}
