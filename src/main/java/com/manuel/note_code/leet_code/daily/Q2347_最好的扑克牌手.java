package com.manuel.note_code.leet_code.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: manuel
 * @Date: Created in 2023/2/20 22:24
 * @Description: 最好的扑克牌手
 * <p>
 * 给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。 下述是从好到坏你可能持有的 手牌类型 ：
 * "Flush"：同花，五张相同花色的扑克牌。 "Three of a Kind"：三条，有 3 张大小相同的扑克牌。 "Pair"：对子，两张大小一样的扑克牌。 "High
 * Card"：高牌，五张大小互不相同的扑克牌。 请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
 */
public class Q2347_最好的扑克牌手 {

  public String bestHand(int[] ranks, char[] suits) {
    Arrays.sort(ranks);
    Arrays.sort(suits);
    int maxRank = 0;
    int maxSuit = 0;
    int rankSlow = 0;
    int rankFast = 0;
    int suitSlow = 0;
    int suitFast = 0;
    for (int i = 0; i < 5; i++) {
      if (ranks[rankSlow] == ranks[rankFast]) {
        rankFast++;
      } else {
        maxRank = Math.max(maxRank, rankFast - rankSlow);
        rankSlow = rankFast;
        rankFast++;
      }
      if (suits[suitSlow] == suits[suitFast]) {
        suitFast++;
      } else {
        maxSuit = Math.max(maxSuit, suitFast - suitSlow);
        suitSlow = suitFast;
        suitFast++;
      }
    }
    maxRank = Math.max(maxRank, rankFast - rankSlow);
    maxSuit = Math.max(maxSuit, suitFast - suitSlow);
    if (maxSuit == 5) {
      return "Flush";
    }
    if (maxRank >= 3) {
      return "Three of a Kind";
    }
    if (maxRank == 2) {
      return "Pair";
    }
    if (maxRank == 1) {
      return "High Card";
    }
    return "";
  }

  public String bestHand1(int[] ranks, char[] suits) {
    Map<Integer, Integer> rankMap = new HashMap<>();
    Map<Character, Integer> suitMap = new HashMap<>();
    for (int rank : ranks) {
      Integer value = rankMap.getOrDefault(rank, 0);
      rankMap.put(rank, value + 1);
    }
    for (char suit : suits) {
      Integer value = suitMap.getOrDefault(suit, 0);
      suitMap.put(suit, value + 1);
    }
    if (suitMap.size() == 1) {
      return "Flush";
    }
    if (rankMap.containsValue(3) || rankMap.containsValue(4)) {
      return "Three of a Kind";
    }
    if (rankMap.containsValue(2)) {
      return "Pair";
    }
    if (rankMap.size() == 5) {
      return "High Card";
    }
    return "";
  }
}
