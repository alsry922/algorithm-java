package DP1.조건에_맞게_선택적으로_전진하는_DP;

import java.io.*;
import java.util.*;

public class Exercise1 {
  static int MAX_VALUE = 10000;    // 나올 수 있는 수의 최대 숫자
  static int n;
  static int[] seq;
  static int[][] dp;
  public static void dpInit() {
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= MAX_VALUE; j++) {
        dp[i][j] = Integer.MIN_VALUE;
      }
    }
    dp[0][0] = 0;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    seq = new int[n+1];
    dp = new int[n+1][MAX_VALUE+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      seq[i] = Integer.parseInt(st.nextToken());
    }
    dpInit();
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= MAX_VALUE; j++) {
        if (j != seq[i]) {
          dp[i][j] = dp[i-1][j];
        }
        else {
          dp[i][j] = dp[i-1][j];

          for (int k = 0; k < seq[i]; k++) {
            if (dp[i-1][k] != Integer.MIN_VALUE) {
              dp[i][j] = Math.max(dp[i-1][k]+1, dp[i][j]);
            }
          }
        }
      }
    }
    int answer = 0;
    for (int j = 0; j <= MAX_VALUE; j++) {
      answer = Math.max(answer, dp[n][j]);
    }
    System.out.println(answer);
  }
}
