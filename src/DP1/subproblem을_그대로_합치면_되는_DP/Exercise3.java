package DP1.subproblem을_그대로_합치면_되는_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3 {
  static final int MAX_N = 1000;
  static int n;
  static int[] dp = new int[MAX_N+1];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    /*dp[i] = n이 i 일때 2x0 크기부터 2xi 크기의 격자를 채우는 서로 다른 경우의 수*/
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = (dp[i-1] + dp[i-2]) % 10007;
    }
    System.out.println(dp[n]);
  }
}
