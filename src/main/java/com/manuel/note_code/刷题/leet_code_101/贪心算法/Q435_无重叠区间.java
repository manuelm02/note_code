package com.manuel.note_code.刷题.leet_code_101.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/9 22:42
 * @Description: 435. 无重叠区间 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回
 * 需要移除区间的最小数量，使剩余区间互不重叠 。
 */
public class Q435_无重叠区间 {

  /**
   * 贪心算法
   * 以第二个进行递增排序
   * @param intervals
   * @return
   */
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals == null) {
      return 0;
    }
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
    int count = 0;
    int[] temp = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < temp[1]) {
        count++;
      } else {
        temp = intervals[i];
      }
    }
    return count;
  }
}
