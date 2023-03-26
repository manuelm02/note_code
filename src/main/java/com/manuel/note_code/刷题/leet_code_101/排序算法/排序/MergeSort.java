package com.manuel.note_code.刷题.leet_code_101.排序算法.排序;

import java.util.Arrays;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/18 10:26
 * @Description: 归并排序
 */
public class MergeSort {
  public static void mergeSort(int[] nums) {
    int len = nums.length;
    int[] temp = new int[len];
    //mergeSort(nums, temp, 0, len);
    mergeSort_practice(nums, temp, 0, len);
  }

  private static void mergeSort_practice(int[] nums, int[] temp, int l, int r) {
    if (r - l <= 1) {
      return;
    }
    int mid = l + (r - l) / 2;
    mergeSort_practice(nums, temp, l, mid);
    mergeSort_practice(nums, temp, mid, r);
    int first = l;
    int second = mid;
    int index = l;
    while (first < mid || second < r) {
      if (second >= r || (first < mid && nums[first] <= nums[second])) {
        temp[index++] = nums[first++];
      } else {
        temp[index++] = nums[second++];
      }
    }
    for (int i = l; i < r; i++) {
      nums[i] = temp[i];
    }
  }

  private static void mergeSort(int[] nums, int[] temp, int l, int r) {
    if (l + 1 >= r) {
      return;
    }
    int mid = l + (r - l) / 2;
    mergeSort(nums, temp, l, mid);
    mergeSort(nums, temp, mid, r);
    int p = l;
    int q = mid;
    int index = l;
    while (p < mid || q < r) {
      if (q >= r || (p < mid && nums[p] <= nums[q])) {
        temp[index++] = nums[p++];
      } else {
        temp[index++] = nums[q++];
      }
    }
    for (int i = l; i < r; i++) {
      nums[i] = temp[i];
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2,6,4,9,1,2,43,2,5,89,9};
    mergeSort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
