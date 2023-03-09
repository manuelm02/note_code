package com.manuel.note_code.刷题.leet_code.array;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/2 21:42
 * @Description: 344. 反转字符串 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class Q344_反转字符串 {

  /**
   * 左右指针，一左一右往中间靠拢
   * @param s
   */
  public void reverseString(char[] s) {
    if (s == null || s.length == 0) {
      return;
    }
    int left = 0;
    int right = s.length - 1;
    while (left <= right) {
      char temp = s[left];
      s[left++] = s[right];
      s[right--] = temp;
    }
  }
}
