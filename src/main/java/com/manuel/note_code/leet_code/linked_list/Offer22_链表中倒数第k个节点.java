package com.manuel.note_code.leet_code.linked_list;

import com.manuel.note_code.leet_code.lib.ListNode;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/27 21:03
 * @Description: 剑指 Offer 22. 链表中倒数第k个节点 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class Offer22_链表中倒数第k个节点 {

  /**
   * 如下，但是通过一个循环来完成所有，先只遍历快指针，然后一起遍历快慢指针
   * @param head
   * @param k
   * @return
   */
  public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null) {
      if (k > 0) {
        fast = fast.next;
        k--;
      } else {
        slow = slow.next;
        fast = fast.next;
      }
    }
    return slow;
  }

  /**
   * 利用快慢指针，快指针先于满指针k个距离，在同时一起往后移，直至快指针遍历到尾部
   * @param head
   * @param k
   * @return
   */
  public ListNode getKthFromEnd1(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (k > 0) {
      fast = fast.next;
      k--;
    }
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}
