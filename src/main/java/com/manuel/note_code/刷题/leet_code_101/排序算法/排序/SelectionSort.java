package com.manuel.note_code.刷题.leet_code_101.排序算法.排序;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/18 10:55
 * @Description: 选择排序
 */
public class SelectionSort {
  public static void selectionSort(int[] nums) {
    int len = nums.length;
    int mid;
    for (int i = 0; i < len - 1; i++) {
      mid = i;
      for (int j = i + 1; j < len; j++) {
        if (nums[j] < nums[mid]) {
          mid = j;
        }
      }
      int temp = nums[mid];
      nums[mid] = nums[i];
      nums[i] = temp;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2,6,4,9,1,2,43,2,5,89,9};
    selectionSort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
