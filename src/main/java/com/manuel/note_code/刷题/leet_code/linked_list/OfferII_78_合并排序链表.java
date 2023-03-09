package com.manuel.note_code.刷题.leet_code.linked_list;

import com.manuel.note_code.刷题.lib.ListNode;
import java.util.PriorityQueue;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/27 21:55
 * @Description: 剑指 Offer II 078. 合并排序链表 给定一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请将所有链表合并到一个升序链表中，返回合并后的链表
 */
public class OfferII_78_合并排序链表 {

  /**
   * 使用优先队列
   * @param lists
   * @return
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
      if (o1.val < o2.val) {
        return -1;
      } else if (o1.val == o2.val) {
        return 0;
      } else {
        return 1;
      }
    });
    for (ListNode node : lists) {
      if (node != null) {
        queue.offer(node);
      }
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (!queue.isEmpty()) {
      cur.next = queue.poll();
      cur = cur.next;
      if (cur.next != null) {
        queue.offer(cur.next);
      }
    }
    return dummy.next;
  }

  /**
   * 分治算法，来进行合并
   *
   * @param lists
   * @return
   */
  public ListNode mergeKListsDivide(ListNode[] lists) {
    return mergeTwoPartLists(lists, 0, lists.length - 1);
  }

  private ListNode mergeTwoPartLists(ListNode[] list, int left, int right) {
    if (left > right) {
      return null;
    }
    if (left == right) {
      return list[left];
    }
    int mid = (left + right) / 2;
    return mergeTwoLists(
        mergeTwoPartLists(list, left, mid),
        mergeTwoPartLists(list, mid + 1, right));
  }

  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode cur;
    ListNode p1 = l1;
    ListNode p2 = l2;
    if (p1.val <= p2.val) {
      cur = p1;
      p1 = p1.next;
    } else {
      cur = p2;
      p2 = p2.next;
    }
    ListNode head = cur;
    while (p1 != null || p2 != null) {
      if (p1 == null) {
        cur.next = p2;
        p2 = p2.next;
        cur = cur.next;
        continue;
      }
      if (p2 == null) {
        cur.next = p1;
        p1 = p1.next;
        cur = cur.next;
        continue;
      }
      if (p1.val <= p2.val) {
        cur.next = p1;
        p1 = p1.next;
      } else {
        cur.next = p2;
        p2 = p2.next;
      }
      cur = cur.next;
    }
    return head;
  }
}
