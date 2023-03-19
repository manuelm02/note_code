package com.manuel.note_code.刷题.leet_code_101.排序算法;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/19 19:29
 * @Description: 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Q215_数组中的第K个最大元素 {
  public int findKthLargest(int[] nums, int k) {
    int l = 0;
    int r = nums.length - 1;
    int target = nums.length - k;
    while (l < r) {
      int mid = quickSelection(nums, l, r);
      if (mid == target) {
        return nums[mid];
      }
      if (mid < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return nums[l];
  }

  private int quickSelection(int[] nums, int l, int r) {
    int i = l + 1;
    int j = r;
    while (true) {
      while (i < r && nums[i] <= nums[l]) {
        ++i;
      }
      while (j > l && nums[j] >= nums[l]) {
        --j;
      }
      if (i >= j) {
        break;
      }
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
    int temp = nums[l];
    nums[l] = nums[j];
    nums[j] = temp;
    return j;
  }
}
