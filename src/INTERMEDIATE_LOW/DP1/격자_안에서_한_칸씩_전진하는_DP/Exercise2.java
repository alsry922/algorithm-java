package INTERMEDIATE_LOW.DP1.격자_안에서_한_칸씩_전진하는_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2 {
  static final int MAX_N = 100;
  static int n;
  static int[][] grid;
  static int[][] dp;
  public static void dpInit() {
    dp[0][n-1] = grid[0][n-1];
    for (int i = n-2; i >= 0; i--) {
      dp[0][i] = grid[0][i] + dp[0][i+1];
    }
    for (int i = 1; i < n; i++) {
      dp[i][n-1] = grid[i][n-1] + dp[i-1][n-1];
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    grid = new int[n][n];
    dp = new int[n][n];
    StringTokenizer st;
    /*grid 초기화*/
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    /*dp 초기화*/
    dpInit();

    for (int i = 1; i < n; i++) {
      for (int j = n-2; j >= 0; j--) {
        dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j+1]);
      }
    }
    System.out.println(dp[n-1][0]);
  }
}
