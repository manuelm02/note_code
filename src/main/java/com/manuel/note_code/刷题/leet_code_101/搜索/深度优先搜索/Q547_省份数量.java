package com.manuel.note_code.刷题.leet_code_101.搜索.深度优先搜索;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/23 22:06
 * @Description: 547. 省份数量 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c
 * 间接相连。
 * <p>
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * <p>
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] =
 * 0 表示二者不直接相连。
 * <p>
 * 返回矩阵中 省份 的数量。
 */
public class Q547_省份数量 {

  public int findCircleNum(int[][] isConnected) {
    int cities = isConnected.length;
    int provinces = 0;
    boolean[] visited = new boolean[cities];
    for (int i = 0; i < cities; i++) {
      if (!visited[i]) {
        dfs(isConnected, visited, cities, i);
        ++provinces;
      }
    }
    return provinces;
  }

  private void dfs(int[][] isConnected, boolean[] visited, int cities, int index) {
    visited[index] = true;
    for (int i = 0; i < cities; i++) {
      if (isConnected[index][i] == 1 && !visited[i]) {
        dfs(isConnected, visited, cities, i);
      }
    }
  }
}
