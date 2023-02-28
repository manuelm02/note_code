package com.manuel.note_code.leet_code.linked_list;

import com.manuel.note_code.leet_code.lib.ListNode;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/27 22:13
 * @Description: 206. 反转链表 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Q206_反转链表 {

  /**
   * Practice 递归
   */
  public ListNode reverseListPractice_1(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode ret = reverseListPractice_1(head.next);
    head.next.next = head;
    head.next = null;
    return ret;
  }

  /**
   * Practice 双指针
   */
  public ListNode reverseListPractice_2(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode prev = head;
    ListNode cur = null;
    while (prev != null) {
      ListNode node = prev.next;
      prev.next = cur;
      cur = prev;
      prev = node;
    }
    return cur;
  }

  /**
   * 特殊的双指针
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode cur = head;
    while (head.next != null) {
      ListNode temp = head.next.next;
      head.next.next = cur;
      cur = head.next;
      head.next = temp;
    }
    return cur;
  }

  /**
   * 递归
   * @param head
   * @return
   */
  public ListNode reverseListRecursive(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }
    ListNode ret = reverseListRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return ret;
  }

  /**
   * 双指针，prev在cur之前，然后让prev的next指向cur
   * @param head
   * @return
   */
  public ListNode reverseList1(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode cur = null;
    ListNode prev = head;
    while (prev != null) {
      ListNode temp = prev.next;
      prev.next = cur;
      cur = prev;
      prev = temp;
    }
    return cur;
  }
}
