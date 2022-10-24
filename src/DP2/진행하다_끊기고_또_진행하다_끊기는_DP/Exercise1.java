package DP2.진행하다_끊기고_또_진행하다_끊기는_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1 {
  static int n;
  static int[] seq;
  static int[] dp; // i번째 원소를 마지막으로 하는 연속 부분수열일 때 원소들의 최대 합
  public static void initialize() {
    for (int i = 0; i <= n; i++) {
      dp[i] = Integer.MIN_VALUE;
    }
    dp[1] = seq[1];
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    seq = new int[n+1];
    dp = new int[n+1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      seq[i] = Integer.parseInt(st.nextToken());
    }

    initialize();

    for (int i = 2; i <= n; i++) {
      dp[i] = Math.max(dp[i-1]+seq[i], seq[i]);
    }

    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      max = Math.max(max, dp[i]);
    }

    System.out.println(max);
  }
}
