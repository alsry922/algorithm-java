package DP1.아이템을_적절히_고르는_문제;

import java.io.*;
import java.util.*;

public class Exercise3 {
  static int n; // 정수들의 합
  static int[] nums = new int[] {1,2,5};
  static int[] dp;
  static final int MAX_N = 1000;
  public static void initialize() {
    for (int i = 0; i <= n; i++) {
      dp[i] = 0;
    }
    dp[0] = 1;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    dp = new int[n+1];
    initialize();
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < 3; j++) {
        if (nums[j] <= i) {
          dp[i] = (dp[i] + dp[i-nums[j]]) % 10007;
        }
      }
    }
    System.out.println(dp[n]);
  }
}