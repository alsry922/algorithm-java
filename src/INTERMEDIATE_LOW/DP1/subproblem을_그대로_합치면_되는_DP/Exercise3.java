package INTERMEDIATE_LOW.DP1.subproblem을_그대로_합치면_되는_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 사각형 채우기
public class Exercise3 {
  public static int N;
  public static int[] dp;
  public static int[] memo;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    dp = new int[N + 1];
    memo = new int[N + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= N; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
    }
    fillRect(N);
    bw.write(dp[N] + "\n");
    bw.write(memo[N] + "\n");
    bw.flush();
    bw.close();
    br.close();
  }

  public static int fillRect(int n) {
    if (memo[n] != 0) {
      return memo[n];
    }

    if (n == 0) {
      memo[n] = 1;
      return memo[n];
    }

    if (n == 1) {
      memo[n] = 1;
      return memo[n];
    }

    memo[n] = (fillRect(n - 1) + fillRect(n - 2)) % 10007;

    return memo[n];
  }
}
