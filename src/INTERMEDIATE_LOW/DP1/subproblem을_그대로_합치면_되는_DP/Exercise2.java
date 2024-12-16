package INTERMEDIATE_LOW.DP1.subproblem을_그대로_합치면_되는_DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

// 계단오르기
public class Exercise2 {
  public static int N;
  public static int[] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    N = Integer.parseInt(br.readLine());
    dp = new int[N + 1];
    dp[1] = 0;
    dp[2] = 1;
    for (int i = 3; i <= N; i++) {
      if (i == 3) {
        dp[i] = 1;
        continue;
      }
      dp[i] = (dp[i - 2] + dp[i - 3]) % 10007;
    }
    bw.write(String.valueOf(dp[N] % 10007));
    bw.flush();
    bw.close();
    br.close();
  }
}
