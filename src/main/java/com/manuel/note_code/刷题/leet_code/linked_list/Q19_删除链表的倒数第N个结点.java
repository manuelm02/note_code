package com.manuel.note_code.刷题.leet_code.linked_list;

import com.manuel.note_code.刷题.lib.ListNode;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/25 19:33
 * @Description: 19. 删除链表的倒数第 N 个结点 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 */
public class Q19_删除链表的倒数第N个结点 {

  /**
   * @Author: m30041209
   * @Description: 这是快慢指针 快指针：head 慢指针：dummy（head之前的节点）
   * 先利用fast指针，定位到倒数的相对位置（相对于slow），最后fast和slow一起往后走 通过slow指针删除节点
   * @Date: 2023/2/25 15:44
   * @Param: [head, n]
   * @Return: com.manuel.study_task.lib.ListNode
   **/
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode slow = dummy;
    ListNode fast = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;
    slow.next.next = null;
    return dummy.next;
  }
}
