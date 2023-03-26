package com.manuel.note_code.刷题.leet_code_101.搜索.回溯法;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/26 11:44
 * @Description: 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案
 */
public class Q77_组合 {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    if (k <= 0 || n < k) {
      return result;
    }
    Deque<Integer> path = new ArrayDeque<>();
    dfs(n, k, 1, path, result);
    return result;
  }

  private void dfs(int n, int k, int start, Deque<Integer> path, List<List<Integer>> result) {
    // 递归终止条件：path的长度等于k
    if (path.size() == k) {
      result.add(new ArrayList<>(path));
      return;
    }
    // 遍历所有可能的搜索起点
    for (int i = start; i <= n - (k - path.size()) + 1; i++) {
      // 路径中添加一个元素
      path.push(i);
      // 下一轮搜索，设置搜索的起点+1（组合中不允许出现重复的元素）
      dfs(n, k, i + 1, path, result);
      // 深度优先遍历有回溯的动作（递归之前做了什么，递归之后需要做相同操作的逆向操作）
      path.pop();
    }
  }
}
