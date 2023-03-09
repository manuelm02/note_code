package com.manuel.note_code.刷题.leet_code.array;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/1 20:24
 * @Description: 26. 删除有序数组中的重复项 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的
 * 相对顺序 应该保持 一致 。
 * <p>
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * <p>
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * <p>
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Q26_删除有序数组中的重复项 {

  /**
   * 快慢指针，相等，快指针先行
   * 不等时，快慢指针交换位置，慢指针和快指针一起往前进
   * @param nums
   * @return
   */
  public int removeDuplicates1(int[] nums) {
    int len = nums.length;
    int slow = 0;
    int fast = 0;
    while (fast < len) {
      if (nums[slow] != nums[fast]) {
        nums[slow + 1] = nums[fast];
        slow++;
      }
      fast++;
      //if (nums[slow] == nums[fast]) {
      //  fast++;
      //} else {
      //  int temp = nums[fast];
      //  nums[slow + 1] = temp;
      //  slow++;
      //  fast++;
      //}
    }
    return slow + 1;
  }

  /**
   * 优化，相邻不相等就不用交换，不相邻且不等才可以交换，降低复杂度
   * @param nums
   * @return
   */
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[slow] != nums[fast]) {
        if (fast - slow > 1) {
          nums[slow+ 1] = nums[fast];
        }
        slow++;
      }
      fast++;
    }
    return slow+ 1;
  }
}
