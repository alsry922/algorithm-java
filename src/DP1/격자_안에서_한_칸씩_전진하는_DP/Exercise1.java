package DP1.격자_안에서_한_칸씩_전진하는_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1 {
  static final int MAX_N = 100;    // 격자 최대 크기
  static int n;
//  static int[][] grid = new int[MAX_N+1][MAX_N+1];
//  static int[][] dp = new int[MAX_N+1][MAX_N+1];
  static int[][] grid;
  static int[][] dp;
  public static void dpInit() {
    dp[1][1] = grid[1][1];
    for (int i = 1; i <= n; i++) {
      dp[1][i] = grid[1][i] + dp[1][i-1];
      dp[i][1] = grid[i][1] + dp[i-1][1];
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    grid = new int[n+1][n+1];
    dp = new int[n+1][n+1];
    StringTokenizer st;
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dpInit();

    for (int i = 2; i <= n; i++) {
      for (int j = 2; j <= n; j++) {
        dp[i][j] = grid[i][j]+Math.max(dp[i-1][j], dp[i][j-1]);
      }
    }
    System.out.println(dp[n][n]);
  }
}
