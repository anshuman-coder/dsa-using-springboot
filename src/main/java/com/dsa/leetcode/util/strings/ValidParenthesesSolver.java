package com.dsa.leetcode.util.strings;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ValidParenthesesSolver {
  private static final String OPENING_BRACKETS = "[{(";
  private static final Map<Character, Character> CLOSE_TO_OPEN = Map.of(
    ')', '(',
    '}', '{',
    ']', '['
  );

  public boolean solve(String query) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char current : query.toCharArray()) {
      if(OPENING_BRACKETS.contains(String.valueOf(current))) stack.push(current);
      else if (!stack.isEmpty() && stack.peek() == CLOSE_TO_OPEN.get(current)) stack.pop();
      else return false;
    }

    return stack.isEmpty();
  }
}
