package com.manuel.note_code.刷题.leet_code_101.排序算法;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/18 10:49
 * @Description: 冒泡排序
 */
public class BubbleSort {
  public static void bubbleSort(int[] nums) {
    int len = nums.length;
    boolean swapped;
    for (int i = 1; i < len; i++) {
      swapped = false;
      for (int j = 1; j < len - i + 1; j++) {
        if (nums[j] < nums[j - 1]) {
          int temp = nums[j];
          nums[j] = nums[j - 1];
          nums[j - 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2,6,4,9,1,2,43,2,5,89,9};
    bubbleSort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
