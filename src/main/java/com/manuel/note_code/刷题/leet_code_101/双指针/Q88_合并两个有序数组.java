package com.manuel.note_code.刷题.leet_code_101.双指针;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/14 22:12
 * @Description: 88. 合并两个有序数组
 */
public class Q88_合并两个有序数组 {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1;
    int p2 = n - 1;
    int pos = m + n - 1;
    int cur;
    while (p1 >= 0 || p2 >= 0) {
      if (p1 == -1) {
        cur = nums2[p2--];
      } else if (p2 == -1) {
        cur = nums1[p1--];
      } else if (nums1[p1] > nums2[p2]) {
        cur = nums1[p1--];
      } else {
        cur = nums2[p2--];
      }
      nums1[pos--] = cur;
    }
  }
}
