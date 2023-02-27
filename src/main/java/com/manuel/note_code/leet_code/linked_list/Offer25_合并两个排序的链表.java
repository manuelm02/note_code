package com.manuel.note_code.leet_code.linked_list;

import com.manuel.note_code.leet_code.lib.ListNode;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/27 21:27
 * @Description: 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 */
public class Offer25_合并两个排序的链表 {

  /**
   * 双指针，在一个循环中把所有的可能都遍历了
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

  /**
   * 递归方法 (不用创建一个新的链表空间)
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val <= l2.val) {
      l1.next = mergeTwoListsRecursive(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoListsRecursive(l1, l2.next);
      return l2;
    }
  }

  /**
   * 双指针，遍历来合并两个链表
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    ListNode p1 = l1;
    ListNode p2 = l2;
    while (p1 != null && p2 != null) {
      if (p1.val <= p2.val) {
        cur.next = p1;
        p1 = p1.next;
      } else {
        cur.next = p2;
        p2 = p2.next;
      }
      cur = cur.next;
    }
    while (p1 != null) {
      cur.next = p1;
      p1 = p1.next;
      cur = cur.next;
    }
    while (p2 != null) {
      cur.next = p2;
      p2 = p2.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}
