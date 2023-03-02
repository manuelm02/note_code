package com.manuel.note_code.leet_code.array;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/2 21:27
 * @Description: 283. 移动零 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Q283_移动零 {

  /**
   * 快慢指针
   * @param nums
   */
  public void moveZeroes1(int[] nums) {
    if (nums.length == 0 || nums == null) {
      return;
    }
    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[fast] != 0 && nums[slow] != 0) {
        fast++;
        slow++;
      } else if (nums[fast] != 0 && nums[slow] == 0) {
        int temp = nums[fast];
        nums[fast++] = nums[slow];
        nums[slow++] = temp;
      } else {
        fast++;
      }
    }
  }

  /**
   * 单指针➕循环
   * 不为0的++，为0的不加
   * @param nums
   */
  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index++] = temp;
      }
    }
  }
}
