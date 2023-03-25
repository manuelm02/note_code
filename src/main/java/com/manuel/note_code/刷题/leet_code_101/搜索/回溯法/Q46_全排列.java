package com.manuel.note_code.刷题.leet_code_101.搜索.回溯法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/24 22:16
 * @Description: 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Q46_全排列 {

  public List<List<Integer>> permute_practice(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> output = new ArrayList<>();
    for (int num : nums) {
      output.add(num);
    }
    backtrack_practice(nums.length, output, result, 0);
    return result;
  }

  private void backtrack_practice(int len, List<Integer> output, List<List<Integer>> result, int index) {
    if (index == len) {
      result.add(new ArrayList<>(output));
    }
    for (int i = index; i < len; i++) {
      Collections.swap(output, index, i);
      backtrack_practice(len, output, result, i);
      Collections.swap(output, index, i);
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> output = new ArrayList<>();
    for (int num : nums) {
      output.add(num);
    }
    int len = nums.length;
    backtrack(len, output, result, 0);
    return result;
  }

  public void backtrack(int len, List<Integer> output, List<List<Integer>> result, int index) {
    if (index == len) {
      result.add(new ArrayList<>(output));
    }
    for (int i = index; i < len; i++) {
      // 动态维护数组
      Collections.swap(output, index, i);
      // 递归下一个数
      backtrack(len, output, result, index + 1);
      // 撤销操作
      Collections.swap(output, index, i);
    }
  }
}
