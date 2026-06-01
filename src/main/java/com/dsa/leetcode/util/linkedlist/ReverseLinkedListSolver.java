package com.dsa.leetcode.util.linkedlist;

import org.springframework.stereotype.Component;

import com.dsa.leetcode.ds.SinglyLinkedList;

@Component
public class ReverseLinkedListSolver {

  public Integer solve(Integer[] list) {
    SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>(list);
    linkedList.reverse();
    return linkedList.getHead().value;
  }
}
