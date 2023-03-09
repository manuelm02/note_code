package com.manuel.note_code.刷题.leet_code_101.贪心算法;

import java.util.Arrays;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/9 22:09
 * @Description: 455. 分发饼干 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子
 * i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 */
public class Q455_分发饼干 {

  /**
   * 贪心算法
   * @param g
   * @param s
   * @return
   */
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int child = 0;
    int cookie = 0;
    while (child < g.length && cookie < s.length) {
      if (g[child] <= s[cookie]) {
        child++;
      }
      cookie++;
    }
    return child;
  }
}
