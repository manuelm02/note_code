package com.manuel.note_code.刷题.leet_code_101.排序算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/20 21:51
 * @Description: 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class Q347_前K个高频元素 {

  // TODO(manuelm02)
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> occurrences = new HashMap<>();
    for (int num : nums) {
      occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
    }
    List<int[]> values = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
      int num = entry.getKey();
      int count = entry.getValue();
      values.add(new int[]{num, count});
    }
    int[] result = new int[k];
    int len = values.size();
    quickSort(values, 0, len - 1, k, result, 0);
    return result;
  }

  private void quickSort(List<int[]> values, int start, int end, int k, int[] result, int resultIndex) {
    int[] pick = values.get(0);
    int pivot = pick[1];
    int index = start;
    for (int i = start + 1; i <= end; i++) {
      if (values.get(i)[1] >= pivot) {
        Collections.swap(values, index + 1, i);
        index++;
      }
    }
    Collections.swap(values, start, index);

    if (k <= index - start) {
      quickSort(values, start, index - 1, k, result, resultIndex);
    } else {
      for (int i = start; i <= index; i++) {
        result[resultIndex++] = values.get(i)[0];
      }
      if (k > index - start + 1) {
        quickSort(values, index + 1, end, k - (index - start + 1), result, resultIndex);
      }
    }
  }

  /**
   * 最大堆（int[] [0]存储num [1]存储个数）
   * @param nums
   * @param k
   * @return
   */
  public int[] topKFrequent1(int[] nums, int k) {
    Map<Integer, Integer> occurrences = new HashMap<>();
    for (int num : nums) {
      occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
    }
    // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
    PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
      }
    });
    for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
      int num = entry.getKey();
      int count = entry.getValue();
      if (queue.size() == k) {
        if (queue.peek()[1] < count) {
          queue.poll();
          queue.offer(new int[]{num, count});
        }
      } else {
        queue.offer(new int[]{num, count});
      }
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = queue.poll()[0];
    }
    return result;
  }
}
