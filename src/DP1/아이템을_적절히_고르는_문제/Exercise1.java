package DP1.아이템을_적절히_고르는_문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1 {
  static final int MAX_VALUE = 10001;
  static int n; //동전 종류 갯수
  static int m; //거스름돈 금액
  static int[] dp; //동전의 합이 i일 때, 고른 동전의 최소 갯수
  static int[] coins; //동전 종류

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
    dp = new int[m + 1];
    coins = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      coins[i] = Integer.parseInt(st.nextToken());
    }

    initialize();
    for (int i = 1; i <= m; i++) {
      for (int j = 0; j < n; j++) {
        if (i >= coins[j]) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }

    System.out.println(dp[m] != MAX_VALUE ? dp[m] : -1);
  }
}
