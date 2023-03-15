package com.manuel.note_code.刷题.leet_code_101.双指针;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/15 22:26
 * @Description: 76. 最小覆盖子串 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串
 * "" 。 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Q76_最小覆盖子串 {

  public static String minWindow(String s, String t) {
    int[] chars = new int[128];
    boolean[] flag = new boolean[128];
    // 先统计t中的字符情况
    int tLen = t.length();
    int sLen = s.length();
    for (int i = 0; i < tLen; i++) {
      flag[t.charAt(i)] = true;
      ++chars[t.charAt(i)];
    }
    // 移动滑动窗口，更改统计数据
    int count = 0;
    int l = 0;
    int minL = 0;
    int minSize = s.length() + 1;
    for (int r = 0; r < sLen; r++) {
      if (flag[s.charAt(r)]) {
        if (--chars[s.charAt(r)] >= 0) {
          ++count;
        }
        // 若目前滑动窗口已包含t中全部字符串，则尝试将指针l右移，在不影响结果的情况下获得最短的子字符串
        while (count == tLen) {
          if (r - l + 1 < minSize) {
            minL = l;
            minSize = r - l + 1;
          }
          if (flag[s.charAt(l)] && ++chars[s.charAt(l)] > 0) {
            --count;
          }
          ++l;
        }
      }
    }
    return minSize > sLen ? "" : s.substring(minL, minL + minSize);
  }

  public static void main(String[] args) {
    String s = "ABAACBAB";
    String t = "ABC";
    String s1 = minWindow(s, t);
    System.out.println(s1);
  }
}
