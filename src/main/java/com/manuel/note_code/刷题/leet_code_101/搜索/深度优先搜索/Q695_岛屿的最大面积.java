package com.manuel.note_code.刷题.leet_code_101.搜索.深度优先搜索;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/22 20:36
 * @Description: 695. 岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class Q695_岛屿的最大面积 {

  int[] indexI = new int[]{0, 0, -1, 1};
  int[] indexJ = new int[]{1, -1, 0, 0};

  /**
   * 用递归代替栈
   * @param grid
   * @return
   */
  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid[0] == null) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int localArea = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        localArea = Math.max(localArea, dfs(grid, i, j));
      }
    }
    return localArea;
  }

  private int dfs(int[][] grid, int curI, int curJ) {
    int m = grid.length;
    int n = grid[0].length;
    if (curI < 0 || curJ < 0 || curI == m || curJ == n || grid[curI][curJ] != 1) {
      return 0;
    }
    grid[curI][curJ] = 0;
    int area = 1;
    for (int i = 0; i < 4; i++) {
      int nextI = curI + indexI[i];
      int nextJ = curJ + indexJ[i];
      area += dfs(grid, nextI, nextJ);
    }
    return area;
  }

  /**
   * 核心：遍历完 值为1 的需要改成0，避免重复统计
   * @param grid
   * @return
   */
  public int maxAreaOfIsland_stack(int[][] grid) {
    if (grid == null || grid[0] == null) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int localArea = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int curArea = 0;
        Deque<Integer> stackI = new ArrayDeque<>();
        Deque<Integer> stackJ = new ArrayDeque<>();
        stackI.push(i);
        stackJ.push(j);
        while (!stackI.isEmpty()) {
          int curI = stackI.pop();
          int curJ = stackJ.pop();
          if (curI < 0 || curJ < 0 || curI == m || curJ == n || grid[curI][curJ] != 1) {
            continue;
          }
          ++curArea;
          grid[curI][curJ] = 0;
          for (int index = 0; index < 4; index++) {
            int nextI = curI + indexI[index];
            int nextJ = curJ + indexJ[index];
            stackI.push(nextI);
            stackJ.push(nextJ);
          }
        }
        localArea = Math.max(curArea, localArea);
      }
    }
    return localArea;
  }
}
