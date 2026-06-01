package com.dsa.leetcode.ds;


public class SinglyLinkedList<T> {

  public static class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T value) {
      this.value = value;
      this.next = null;
    }
  }

  private Node<T> head;
  private int size;

  public SinglyLinkedList(T[] arr) {
    if (arr == null || arr.length == 0) {
      this.head = null;
      this.size = 0;
      return;
    }

    this.head = new Node<>(arr[0]);
    Node<T> current = this.head;

    for (int i = 1; i < arr.length; i++) {
      current.next = new Node<>(arr[i]);
      current = current.next;
    }

    this.size = arr.length;
  }

  public int size() {
    return size;
  }

  public T[] toArray(T[] result) {
    Node<T> current = head;
    int i = 0;
    while (current != null) {
      result[i++] = current.value;
      current = current.next;
    }
    return result;
  }

  public Node<T> getHead() {
    return head;
  }

  public void reverse() {
    Node<T> prev = null;
    Node<T> current = head;

    while (current != null) {
      Node<T> next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    head = prev;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    Node<T> current = head;
    while (current != null) {
      sb.append(current.value);
      if (current.next != null) sb.append(" -> ");
      current = current.next;
    }
    return sb.append("]").toString();
  }
}
