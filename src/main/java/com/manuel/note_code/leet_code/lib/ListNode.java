package com.manuel.note_code.leet_code.lib;

import lombok.Data;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/24 21:27
 * @Description: 链表节点
 */
@Data
public class ListNode {

  public int val;
  public ListNode next;

  public ListNode(int val) {
    this(val, null);
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
