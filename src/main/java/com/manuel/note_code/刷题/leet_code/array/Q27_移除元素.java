package com.manuel.note_code.刷题.leet_code.array;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/2 21:02
 * @Description: 27. 移除元素 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Q27_移除元素 {

  /**
   * 快慢指针，快慢指针交替元素，慢指针的位置就是剩余元素的个数
   * @param nums
   * @param val
   * @return
   */
  public int removeElement1(int[] nums, int val) {
    if(nums.length == 0 || nums == null) {
      return 0;
    }
    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[fast] != val && nums[slow] != val) {
        slow++;
        fast++;
      } else if (nums[fast] != val && nums[slow] == val) {
        int temp = nums[fast];
        nums[fast++] = nums[slow];
        nums[slow++] = temp;
      } else {
        fast++;
      }
    }
    return slow;
  }

  /**
   * 左右指针，一左一右
   * @param nums
   * @param val
   * @return
   */
  public int removeElement(int[] nums, int val) {
    int left = 0;
    int right = nums.length;
    while (left < right) {
      if (nums[left] == val) {
        nums[left] = nums[right - 1];
        right--;
      } else {
        left++;
      }
    }
    return left;
  }
}
