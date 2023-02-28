package com.manuel.note_code.leet_code.linked_list;

import com.manuel.note_code.leet_code.lib.ListNode;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/28 21:52
 * @Description: 92. 反转链表 II 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置
 * right 的链表节点，返回 反转后的链表 。
 */
public class Q92_反转链表_II {

  public ListNode reverseBetween(ListNode head, int left, int right) {
    int disGap = right - left;
    if (disGap == 0) {
      return head;
    }
    ListNode dummy = new ListNode(-1, head);
    int indexSlow = -1;
    int indexFast = -1;
    ListNode leftHalf = dummy;
    ListNode rightHalf = dummy;
    ListNode index = dummy;
    ListNode indexPrev = null;
    ListNode leftHalfPrev = null;
    while (index != null) {
      if (indexFast - indexSlow < disGap) {
        rightHalf = rightHalf.next;
        indexFast++;
        continue;
      }
      if (indexSlow < left - 1) {
        index = index.next;
        indexPrev = index;
        leftHalfPrev = leftHalf;
        leftHalf = leftHalf.next;
        rightHalf = rightHalf.next;
        indexFast++;
        indexSlow++;
        continue;
      }
      if (index == rightHalf) {
        indexPrev = index;
        index = index.next;
      }
      ListNode node = index.next;
      ListNode nodePrev = index;
      leftHalfPrev.next = index;
      indexPrev.next = node;
      index.next = indexPrev;
      index = node;
      indexPrev = nodePrev;
    }
    return dummy.next;
  }

  /**
   * 利用快慢指针，先定位在head之前的节点，然后遍历读取到使得快慢指针相差左右的gap值，然后再单独反转中间的链表，最后再拼接
   *
   * @param head
   * @param left
   * @param right
   * @return
   */
  public ListNode reverseBetween1(ListNode head, int left, int right) {
    int disGap = right - left;
    if (disGap == 0) {
      return head;
    }
    ListNode dummy = new ListNode(-1, head);
    int indexSlow = -1;
    int indexFast = -1;
    ListNode leftHalf = dummy;
    ListNode rightHalf = dummy;
    ListNode leftHalfPrev = null;
    while (indexSlow < left - 1) {
      if (indexFast - indexSlow < disGap) {
        rightHalf = rightHalf.next;
        indexFast++;
        continue;
      }
      leftHalfPrev = leftHalf;
      leftHalf = leftHalf.next;
      rightHalf = rightHalf.next;
      indexFast++;
      indexSlow++;
    }
    leftHalfPrev.next = null;
    ListNode node = rightHalf.next;
    rightHalf.next = null;
    leftHalfPrev.next = reverseList(leftHalf);
    leftHalf.next = node;
    return dummy.next;
  }

  private ListNode reverseList(ListNode head) {
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
}
