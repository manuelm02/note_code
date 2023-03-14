package com.manuel.note_code.刷题.leet_code_101.双指针;

import com.manuel.note_code.刷题.lib.ListNode;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/14 22:31
 * @Description: 142. 环形链表 II
 */
public class Q142_环形链表_II {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    do {
      if (fast == null || fast.next == null) {
        return null;
      }
      fast = fast.next.next;
      slow = slow.next;
    } while (fast !=  slow);
    fast = head;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }
}
