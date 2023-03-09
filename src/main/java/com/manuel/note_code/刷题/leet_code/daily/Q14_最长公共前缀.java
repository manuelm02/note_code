package com.manuel.note_code.刷题.leet_code.daily;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/8 21:34
 * @Description: 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Q14_最长公共前缀 {

  /**
   * 纵向扫描
   * 判断条件：第一个最先结束的字符串，或者第一个不一样的字符串就可以直接返回
   * @param strs
   * @return
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return null;
    }
    int length = strs[0].length();
    int count = strs.length;
    for (int i = 0; i < length; i++) {
      char c = strs[0].charAt(i);
      for (int j = 1; j < count; j++) {
        if (i == strs[j].length() || strs[j].charAt(i) != c) {
          return strs[0].substring(0, i);
        }
      }
    }
    return strs[0];
  }

  /**
   * 暴力解法 - 横向扫描
   * @param strs
   * @return
   */
  public String longestCommonPrefix2(String[] strs) {
    if (strs == null || strs.length == 0) {
      return null;
    }
    String prefix = strs[0];
    int len = strs.length;
    for (int i = 1; i < len; i++) {
      prefix = longestCommonPrefix(prefix, strs[i]);
      if (prefix.length() == 0) {
        break;
      }
    }
    return prefix;
  }

  /**
   * 分治算法
   * 从中间分开，以此类推
   * @param strs
   * @return
   */
  public String longestCommonPrefix1(String[] strs) {
    if (strs == null || strs.length == 0) {
      return null;
    }
    return longestCommonPrefix1(strs, 0, strs.length - 1);
  }

  private String longestCommonPrefix1(String[] strs, int start, int end) {
    if (start == end) {
      return strs[start];
    }
    int mid = (end - start) / 2 + start;
    String left = longestCommonPrefix1(strs, start, mid);
    String right = longestCommonPrefix1(strs, mid + 1, end);
    return longestCommonPrefix(left, right);
  }

  private String longestCommonPrefix(String left, String right) {
    int leftLen = left.length();
    int rightLen = right.length();
    int len = Math.min(leftLen, rightLen);
    for (int i = 0; i < len; i++) {
      if (left.charAt(i) != right.charAt(i)) {
        return left.substring(0, i);
      }
    }
    return left.substring(0, len);
  }
}
