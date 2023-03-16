package com.manuel.note_code.刷题.leet_code_101.二分法;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/16 22:01
 * @Description: 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class Q34_在排序数组中查找元素的第一个和最后一个位置 {

  /**
   * 使用二分法把中间值找出，在依次前后排序，找到临界值
   * @param nums
   * @param target
   * @return
   */
  public static int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
      return new int[]{-1, -1};
    }
    int l = 0;
    int r = nums.length - 1;
    while (r >= l) {
      int mid = l + (r - l) / 2;
      if (mid == l && nums[l] != target && nums[r] != target) {
        break;
      }
      if (nums[mid] > target){
        r = mid;
      } else if (nums[mid] < target) {
        l = mid + 1;
      } else {
        l = mid;
        r = mid;
        while (l >= 0 && nums[l] == target) {
          --l;
        }
        while (r <= nums.length - 1 && nums[r] == target) {
          ++r;
        }
        break;
      }
    }
    return r - l <= 1 ? new int[]{-1, -1} : new int[]{l + 1, r - 1};
  }

  public static void main(String[] args) {
    //int[] nums = new int[]{5,7,7,8,8,10};
    int[] nums = new int[]{1, 4};
    int target = 4;
    int[] result = searchRange(nums, target);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }
}
