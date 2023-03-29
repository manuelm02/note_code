package com.manuel.note_code.刷题.leet_code_101.搜索.回溯法;

import java.util.*;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/29 21:19
 * @Description: 51. N 皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class Q51_N皇后 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonalLeLft = new HashSet<>();
        Set<Integer> diagonalRight = new HashSet<>();
        backtrack(result, queens, n, 0, columns, diagonalLeLft, diagonalRight);
        return result;
    }

    private void backtrack(List<List<String>> result, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonalLeLft, Set<Integer> diagonalRight) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            result.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonalL = row - i;
                if (diagonalLeLft.contains(diagonalL)) {
                    continue;
                }
                int diagonalR = row + i;
                if (diagonalRight.contains(diagonalR)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonalLeLft.add(diagonalL);
                diagonalRight.add(diagonalR);
                backtrack(result, queens, n, row + 1, columns, diagonalLeLft, diagonalRight);
                queens[row] = -1;
                columns.remove(i);
                diagonalLeLft.remove(diagonalL);
                diagonalRight.remove(diagonalR);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
