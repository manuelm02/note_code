package com.manuel.note_code.leet_code.daily;

import java.util.ArrayDeque;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/21 21:54
 * @Description: 分割平衡字符串 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的子字符串，并满足：
 * <p>
 * 每个子字符串都是平衡字符串。 返回可以通过分割得到的平衡字符串的 最大数量
 */
public class Q1221_分割平衡字符串 {

  public int balancedStringSplit(String s) {
    int count = 0;
    int index = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'L') {
        index++;
      } else {
        index--;
      }
      if (index == 0) {
        count++;
      }
    }
    return count;
  }

  public int balancedStringSplit1(String s) {
    ArrayDeque<Character> queue = new ArrayDeque<>();
    int len = s.length();
    int count = 0;
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      if (queue.isEmpty()) {
        queue.offer(c);
        continue;
      }
      if (queue.peek() == c) {
        queue.offer(c);
      } else {
        queue.poll();
      }
      if (queue.isEmpty()) {
        count++;
      }
    }
    return count;
  }
}
