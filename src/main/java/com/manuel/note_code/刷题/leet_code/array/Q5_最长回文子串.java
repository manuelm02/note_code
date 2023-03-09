package com.manuel.note_code.刷题.leet_code.array;

/**
 * @Author: manuel
 * @Date: Created in 2023/3/6 21:46
 * @Description: 5. 最长回文子串 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class Q5_最长回文子串 {

  public String longestPalindromePractise(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }
    int maxLen = 1;
    int begin = 0;
    boolean[][] dp = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }
    for (int j = 1; j < len; j++) {
      for (int i = 0; i < j; i++) {
        if (s.charAt(i) != s.charAt(j)) {
          dp[i][j] = false;
        } else {
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }
        if (j - i + 1 > maxLen && dp[i][j]) {
          maxLen = j - i + 1;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }

  public String longestPalindromePractise4(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }
    int maxLen = 1;
    int begin = 0;
    boolean[][] dp = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }
    char[] chars = s.toCharArray();
    for (int j = 1; j < len; j++) {
      for (int i = 0; i < j; i++) {
        if (chars[i] != chars[j]) {
          dp[i][j] = false;
        } else {
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }
        if (dp[i][j] && j - i + 1 > maxLen) {
          maxLen = j - i + 1;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }

  /**
   * 动态规划
   * dp[i][j] 表示子串s[i...j]是否为回文子串，
   * 状态转移方程：
   * dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1];
   * 边界条件：j - 1 - (i + 1) + 1 < 2 => j - i < 3 (当s[i...j]长度为2或者3时，不用检查子串是否回文)
   * 初始化：dp[i][i] = true (单个子串一定是回文串)
   * 输出：在得到一个状态值为true的时候，记录起始位置和长度，填表完以后再截取
   * dp[i][j] = (s[i] == s[j]) && (j - i < 3 || dp[i + 1][j - 1])
   * @param s
   * @return
   */
  public String longestPalindrome3(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }
    int maxLen = 1;
    int begin = 0;
    boolean[][] dp = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }
    char[] toCharArray = s.toCharArray();
    // 左下角先填 (一行一行的填)
    for (int j = 1; j < len; j++) {
      for (int i = 0; i < j; i++) {
        if (toCharArray[i] != toCharArray[j]) {
          dp[i][j] = false;
        } else {
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }

        if (dp[i][j] && j - i + 1 > maxLen) {
          maxLen = j - i + 1;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }

  /**
   * 中心扩散法
   * @param s
   * @return
   */
  public String longestPalindrome2(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }
    int maxLen = 1;
    int begin = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < len - 1; i++) {
      int oddLen = expandAroundCenter(chars, i, i);
      int evenLen = expandAroundCenter(chars, i, i + 1);
      int curMaxLen = Math.max(oddLen, evenLen);
      if (curMaxLen > maxLen) {
        maxLen = curMaxLen;
        begin = i - (maxLen - 1) / 2;
      }
    }
    return s.substring(begin, begin + maxLen);
  }

  private int expandAroundCenter(char[] chars, int left, int right) {
    int len = chars.length;
    int i = left;
    int j = right;
    while (i >= 0 && j < len) {
      if (chars[i] == chars[j]) {
        i--;
        j++;
      } else {
        break;
      }
    }
    return j - i - 1;
  }

  /**
   * 暴力解法
   * @param s
   * @return
   */
  public String longestPalindrome1(String s) {
    int len = s.length();
    if (len < 2) {
      return s;
    }
    int maxLen = 1;
    int begin = 0;
    char[] chars = s.toCharArray();
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        if (j - i + 1 > maxLen && validPalindromic(chars, i, j)) {
          maxLen = j - i + i;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }

  private boolean validPalindromic(char[] chars, int left, int right) {
    while (left < right) {
      if (chars[left] != chars[right]) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
