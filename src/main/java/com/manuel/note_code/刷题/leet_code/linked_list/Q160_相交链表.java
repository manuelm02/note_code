package com.manuel.note_code.刷题.leet_code.linked_list;

import com.manuel.note_code.刷题.lib.ListNode;
import java.util.HashSet;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/25 19:30
 * @Description: 160. 相交链表 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null
 */
public class Q160_相交链表 {

  /**
   * @Author: m30041209
   * @Description: 分别遍历两个链表，A遍历完了之后再去遍历B，另一个也一样，这样两个最后虚拟的链表都是一样的
   * 判断指针，而不是判断指针下一个，这样节点相等或者节点为null的时候，都可以跳出循环
   * @Date: 2023/2/25 15:16
   * @Param: [headA, headB]
   * @Return: com.manuel.study_task.lib.ListNode
   **/
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode curA = headA;
    ListNode curB = headB;
    while (curA != curB) {
      curA = curA == null ? headB : curA.next;
      curB = curB == null ? headA : curB.next;
    }
    return curA;
  }

  /**
   * @Author: m30041209
   * @Description: 利用HashSet不重复的特性，来判断节点是否相同
   * @Date: 2023/2/25 15:33
   * @Param: [headA, headB]
   * @Return: com.manuel.study_task.lib.ListNode
   **/
  public ListNode getIntersectionNodeHash(ListNode headA, ListNode headB) {
    HashSet<ListNode> set = new HashSet<>();
    ListNode temp = headA;
    while (temp != null) {
      set.add(temp);
      temp = temp.next;
    }
    temp = headB;
    while (temp != null) {
      if (set.contains(temp)) {
        return temp;
      }
      temp = temp.next;
    }
    return null;
  }
}
