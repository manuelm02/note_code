package com.manuel.note_code.刷题.leet_code_101.搜索.深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/23 22:31
 * @Description: 417. 太平洋大西洋水流问题 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋”
 * 处于大陆的右边界和下边界。
 * <p>
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * <p>
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * <p>
 * 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
 */
public class Q417_太平洋大西洋水流问题 {
  static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  int[][] heights;
  int m;
  int n;
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    this.heights = heights;
    this.m = heights.length;
    this.n = heights[0].length;
    // 对应单元格是否可以流入海洋
    boolean[][] pacific = new boolean[m][n];
    boolean[][] atlantic = new boolean[m][n];
    // 左边
    for (int i = 0; i < m; i++) {
      dfs(i, 0, pacific);
    }
    // 上边（排除上边第一个单元格，因为在左边已经遍历过了）
    for (int j = 1; j < n; j++) {
      dfs(0, j, pacific);
    }
    // 右边
    for (int i = 0; i < m; i++) {
      dfs(i, n - 1, atlantic);
    }
    // 下边（排除下边最后一个单元格，因为在右边已经遍历过了）
    for (int j = 0; j < n - 1; j++) {
      dfs(m - 1, j, atlantic);
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          List<Integer> cell = new ArrayList<>();
          cell.add(i);
          cell.add(j);
          result.add(cell);
        }
      }
    }
    return result;
  }

  private void dfs(int row, int col, boolean[][] ocean) {
    if (ocean[row][col]) {
      return;
    }
    // 核心！能进入dfs的方法就表示可以流入海洋，则为true
    ocean[row][col] = true;
    for (int[] dir : dirs) {
      int newRow = row + dir[0];
      int newCol = col + dir[1];
      if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[row][col]) {
        dfs(newRow, newCol, ocean);
      }
    }
  }
}
