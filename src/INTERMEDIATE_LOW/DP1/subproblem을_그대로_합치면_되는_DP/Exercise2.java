package INTERMEDIATE_LOW.DP1.subproblem을_그대로_합치면_되는_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2 {
  static final int MAX_N = 1000;    // 최대 계단 높이
  static int n;
  static int[] dp = new int[MAX_N+1];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    // dp[i] = 0번 층에서 i층까지 도달알 수 있는 서로 다른 가짓 수
    dp[0] = 1;
    dp[1] = 0;
    dp[2] = 1;
    dp[3] = 1;
    for (int i = 4; i <= n; i++) {
      dp[i] = (dp[i-2] + dp[i-3]) % 10007;
    }
    System.out.println(dp[n]);
  }
}
