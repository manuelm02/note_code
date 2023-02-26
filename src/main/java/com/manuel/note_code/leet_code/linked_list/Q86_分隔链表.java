package com.manuel.note_code.leet_code.linked_list;

import com.manuel.note_code.leet_code.lib.ListNode;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/26 20:27
 * @Description: 86. 分隔链表 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置
 */
public class Q86_分隔链表 {

  /**
   * 同下方法，只不过用一个指针来记录节点
   * @param head
   * @param x
   * @return
   */
  public ListNode partition(ListNode head, int x) {
    if (head == null) {
      return null;
    }
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode cur = dummy;
    while (cur.next != null) {
      if (cur.next.val >= x) {
        queue.offer(cur.next.val);
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    while (!queue.isEmpty()) {
      cur.next = new ListNode(queue.poll());
      cur = cur.next;
    }
    return dummy.next;
  }

  /**
   * 遍历节点，如果遇到大于等于x的，可以取出来放进一个队列
   * 最后在末尾依次添加
   * @param head
   * @param x
   * @return
   */
  public ListNode partition1(ListNode head, int x) {
    if (head == null) {
      return null;
    }
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    ListNode cur = head;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
    while (cur != null) {
      if (cur.val >= x) {
        queue.offer(cur.val);
        prev.next = cur.next;
      } else {
        prev = prev.next;
      }
      cur = cur.next;
    }
    while (!queue.isEmpty()) {
      prev.next = new ListNode(queue.poll().intValue());
      prev = prev.next;
    }
    return dummy.next;
  }

  /**
   * 利用三个节点指针记录，当遍历到小于x的节点就，插入回去比x大的地方
   * @param head
   * @param x
   * @return
   */
  public ListNode partition2(ListNode head, int x) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(-1, head);
    ListNode prev = dummy;
    ListNode prevMoreX = dummy;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val < x) {
        if (prevMoreX.next == cur) {
          prev = cur;
          cur = cur.next;
          prevMoreX = prev;
        } else {
          prev.next = cur.next;
          cur.next = prevMoreX.next;
          prevMoreX.next = cur;
          prevMoreX = cur;
          cur = prev.next;
        }
      } else {
        prev = cur;
        cur = cur.next;
      }
    }
    return dummy.next;
  }
}
