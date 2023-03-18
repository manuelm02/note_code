package com.manuel.note_code.刷题.leet_code_101.排序算法;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/18 10:44
 * @Description: 插入排序
 */
public class InsertionSort {
  public static void insertionSort(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      for (int j = i; j > 0; j--) {
        if (nums[j] < nums[j - 1]) {
          int temp = nums[j];
          nums[j] = nums[j - 1];
          nums[j - 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2,6,4,9,1,2,43,2,5,89,9};
    insertionSort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
