package com.manuel.note_code.刷题.leet_code_101.搜索.回溯法;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/28 23:25
 * @Description: 79. 单词搜索 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false
 * 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Q79_单词搜索 {
  char[][] board;
  int m;
  int n;

  public boolean exist(char[][] board, String word) {
    if (board == null || board[0] == null) {
      return false;
    }
    this.board = board;
    this.m = board.length;
    this.n = board[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        boolean flag = backtrack(board, visited, word, i, j, 0);
        if (flag) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean backtrack(char[][] board, boolean[][] visited, String word, int i, int j, int pos) {
    if (board[i][j] != word.charAt(pos)) {
      return false;
    } else if (pos == word.length() - 1) {
      return true;
    }
    visited[i][j] = true;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean result = false;
    for (int[] ints : dir) {
      int nextI = i + ints[0];
      int nextJ = j + ints[1];
      if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
        if (!visited[nextI][nextJ]) {
          boolean flag = backtrack(board, visited, word, nextI, nextJ, pos + 1);
          if (flag) {
            result = true;
            break;
          }
        }
      }
    }
    visited[i][j] = false;
    return result;
  }
}
