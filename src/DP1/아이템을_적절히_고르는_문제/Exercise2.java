package DP1.아이템을_적절히_고르는_문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2 {
  static int n; // 수열의 원소 갯수
  static int m; // 부분 수열의 합
  static int[] seq; // 수열
  static int[] dp;
  static final int MAX_VALUE = 10001;

  public static void initialize() {
    for (int i = 0; i <= m; i++) {
      dp[i] = MAX_VALUE;
    }
    dp[0] = 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    seq = new int[n+1];
    dp = new int[m+1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      seq[i] = Integer.parseInt(st.nextToken());
    }
    initialize();
    for (int i = 1; i <= n; i++) {
      for (int j = m; j >= 0; j--) {
        if (j >= seq[i]) {
          dp[j] = Math.min(dp[j], dp[j-seq[i]]+1);
        }
      }
    }
    System.out.println(dp[m] != MAX_VALUE ? dp[m] : -1);
  }
}
