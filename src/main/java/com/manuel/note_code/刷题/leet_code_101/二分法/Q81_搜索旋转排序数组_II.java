package com.manuel.note_code.刷题.leet_code_101.二分法;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/18 9:47
 * @Description: 81. 搜索旋转排序数组 II
 */
public class Q81_搜索旋转排序数组_II {
  public boolean search(int[] nums, int target) {
    if (nums == null) {
      return false;
    }
    int len = nums.length;
    int l = 0;
    int r = len - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[l] == nums[mid]) {
        ++l;
      } else if (nums[mid] <= nums[r]){
        // 右边是递增的
        if (nums[mid] < target && target <= nums[r]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      } else {
        // 左边是递增的
        if (nums[l] <= target && target < nums[mid]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      }
    }
    return false;
  }
}
