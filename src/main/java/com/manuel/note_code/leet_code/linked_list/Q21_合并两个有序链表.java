package com.manuel.note_code.leet_code.linked_list;

import com.manuel.note_code.leet_code.lib.ListNode;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/25 19:36
 * @Description: 21. 合并两个有序链表 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Q21_合并两个有序链表 {
  /**
   * @Author: m30041209
   * @Description: 双指针比较，添加新链表
   * @Date: 2023/2/25 16:05
   * @Param: [list1, list2]
   * @Return: com.manuel.study_task.lib.ListNode
   **/
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    ListNode cur1 = list1;
    ListNode cur2 = list2;
    while (cur1 != null && cur2 != null) {
      if (cur1.val > cur2.val) {
        cur.next = cur2;
        cur2 = cur2.next;
      } else {
        cur.next = cur1;
        cur1 = cur1.next;
      }
      cur = cur.next;
    }
    if (cur1 != null) {
      cur.next = cur1;
    }
    if (cur2 != null) {
      cur.next = cur2;
    }
    return dummy.next;
  }
}
