package com.manuel.note_code.刷题.leet_code.linked_list;

import com.manuel.note_code.刷题.lib.ListNode;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/26 22:03
 * @Description: 876. 链表的中间结点
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Q876_链表的中间结点 {
  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
