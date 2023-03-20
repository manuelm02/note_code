package com.manuel.note_code.刷题.leet_code_101.排序算法.排序;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/18 10:07
 * @Description: 快速排序
 */
public class QuickSort {
  public static void quickSort(int[] nums) {
    //quickSort(nums, 0, nums.length - 1);
    quickSort_practice(nums, 0, nums.length - 1);
  }

  private static void quickSort_practice(int[] nums, int l, int r) {
    if (l >= r) {
      return;
    }
    int num = nums[l];
    int first = l;
    int last = r;
    while (first < last) {
      while (first < last && nums[last] > num) {
        --last;
      }
      if (first < last) {
        nums[first++] = nums[last];
      }
      while (first < last && nums[first] < num) {
        ++first;
      }
      if (first < last) {
        nums[last--] = nums[first];
      }
    }
    nums[first] = num;
    quickSort_practice(nums, l, first - 1);
    quickSort_practice(nums, first + 1, r);
  }

  private static void quickSort(int[] nums, int l, int r) {
    if (l + 1 >= r) {
      return;
    }
    int first = l;
    int last = r;
    int key = nums[first];
    while (first < last) {
      while (first < last && nums[last] >= key) {
        --last;
      }
      nums[first] = nums[last];
      while (first < last && nums[first] <= key) {
        ++first;
      }
      nums[last] = nums[first];
    }
    nums[first] = key;
    quickSort(nums, l, first);
    quickSort(nums, first + 1, r);
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2,6,4,9,1,2,43,2,5,89,9};
    quickSort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
