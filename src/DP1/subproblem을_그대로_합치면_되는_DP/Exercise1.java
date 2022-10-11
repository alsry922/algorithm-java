package DP1.subproblem을_그대로_합치면_되는_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1 {
  static final int MAX_N = 45;
  static int n;
  static int[] dp = new int[MAX_N+1];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    System.out.println(dp[n]);
  }
}
