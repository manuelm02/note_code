package com.manuel.note_code.leet_code.linked_list;

import com.manuel.note_code.leet_code.lib.ListNode;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/6 21:54
 * @Description: 83. 删除排序链表中的重复元素 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class Q83_删除排序链表中的重复元素 {

  /**
   * 快慢指针
   * @param head
   * @return
   */
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      if (fast.val == slow.val) {
        fast = fast.next;
      } else {
        slow.next = fast;
        slow = slow.next;
      }
    }
    slow.next = null;
    return head;
  }
}
