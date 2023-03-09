package com.manuel.note_code.刷题.leet_code_101.贪心算法;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/9 22:24
 * @Description: 135. 分发糖果 n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。 相邻两个孩子评分更高的孩子会获得更多的糖果。 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */
public class Q135_分发糖果 {

  /**
   * 贪心算法
   * 二次遍历：1. 从左往右 2. 从右往左
   * @param ratings
   * @return
   */
  public int candy(int[] ratings) {
    int len = ratings.length;
    if (len == 1) {
      return 1;
    }
    int[] candy = new int[len];
    for (int i = 0; i < len; i++) {
      candy[i] = 1;
    }
    for (int i = 1; i < len; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candy[i] = candy[i - 1] + 1;
      }
    }
    for (int i = len - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
        candy[i] = candy[i + 1] + 1;
      }
    }
    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum = sum + candy[i];
    }
    return sum;
  }
}
