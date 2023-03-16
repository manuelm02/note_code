package com.manuel.note_code.刷题.leet_code_101.二分法;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/16 21:42
 * @Description: 69. x 的平方根
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class Q69_x的平方根 {
  public int mySqrt(int x) {
    if (x == 0) {
      return x;
    }
    int l = 1;
    int r = x;
    int mid;
    int sqrt;
    while (l <= r) {
      mid = l + (r - l) / 2;
      sqrt = x / mid;
      if (sqrt == mid) {
        return mid;
      } else if (mid > sqrt) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return r;
  }
}
