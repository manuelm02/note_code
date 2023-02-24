package com.manuel.note_code.leet_code.linked_list;

import com.manuel.note_code.leet_code.lib.ListNode;
import java.util.HashSet;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/24 21:24
 * @Description: 141. 环形链表 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0
 * 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false
 */
public class Q141_环形链表 {

  /**
   * 哈希表，遍历整个链表，有重复就返回FALSE
   *
   * @param head
   * @return
   */
  public boolean hasCycleHash(ListNode head) {
    HashSet<ListNode> set = new HashSet<>();
    while (head != null) {
      if (!set.add(head)) {
        return true;
      }
      head = head.next;
    }
    return false;
  }

  /**
   * 快慢指针，慢指针向前1步，快指针向前2步， while循环 循环条件优先于循环体 head之前的虚拟指针同步出发，即是head 慢指针，head.next 快指针
   *
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    //ListNode slow = head, fast = head.next;
    //while (slow != fast) {
    //  if (fast == null || fast.next == null) {
    //    return false;
    //  }
    //  slow = slow.next;
    //  fast = fast.next.next;
    //}
    ListNode slow = head, fast = head;
    do {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    } while (slow != fast);
    return true;
  }
}
