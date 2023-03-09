package com.manuel.note_code.刷题.leet_code.linked_list;

import com.manuel.note_code.刷题.lib.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/25 19:37
 * @Description: 23. 合并K个升序链表 给你一个链表数组，每个链表都已经按升序排列。 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Q23_合并K个升序链表 {
  /**
   * 使用优先队列合并 k 个链表就最多有 k 个满足这样条件的元素，每次在这些元素里面选取 val 属性最小的元素合并到链表中 在选取最小元素的时候，我们可以用优先队列来优化这个过程
   *
   * @param lists
   * @return
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        if (o1.val < o2.val) {
          return -1;
        } else if (o1.val == o2.val) {
          return 0;
        } else {
          return 1;
        }
      }
    });
    for (ListNode node : lists) {
      if (node != null) {
        queue.offer(node);
      }
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (!queue.isEmpty()) {
      cur.next = queue.poll();
      cur = cur.next;
      if (cur.next != null) {
        // 此node节点下面还有节点，就再丢进优先队列进行排序，直至队列为空的时候，就结束循环
        queue.offer(cur.next);
      }
    }
    return dummy.next;
  }

  /**
   * 分治合并
   *
   * @param lists
   * @return
   */
  public ListNode mergeKListsDivide(ListNode[] lists) {
    return merge(lists, 0, lists.length - 1);
  }

  private ListNode merge(ListNode[] list, int left, int right) {
    if (left == right) {
      return list[left];
    }
    if (left > right) {
      return null;
    }
    int mid = (left + right) / 2;
    return mergeTwoLists(merge(list, left, mid), merge(list, mid + 1, right));
  }

  /**
   * @Author: m30041209
   * @Description: 利用合并两个链表的方法，遍历一个一个合并（时间空间复杂度高）
   * @Date: 2023/2/25 16:15
   * @Param: [lists]
   * @Return: com.manuel.study_task.lib.ListNode
   **/
  public ListNode mergeKListsComplex(ListNode[] lists) {
    int length = lists.length;
    if (length == 0) {
      return null;
    }
    if (length == 1) {
      return lists[0];
    }
    ListNode temp = lists[0];
    for (int i = 1; i < length; i++) {
      temp = mergeTwoLists(temp, lists[i]);
    }
    return temp;
  }

  private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
// TODO(miaosong)
//static class Status implements Comparable<Status> {
//      int val;
//      ListNode node;
//
//      Status(int val, ListNode node) {
//          this.val = val;
//          this.node = node;
//      }
//
//      @Override
//      public int compareTo(Status status2) {
//          return this.val - status2.val;
//      }
//   }
//   PriorityQueue<Status> queue = new PriorityQueue<>();
