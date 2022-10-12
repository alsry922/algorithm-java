package DP1.격자_안에서_한_칸씩_전진하는_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3 {
  static final int MAX_N = 100;
  static int n;
  static int[][] grid;
  /*(i,j)위치까지 이동했을 때 이동 경로 상의 최솟값 중 최댓값*/
  static int[][] dp;

  public static void dpInit() {
    dp[0][0] = grid[0][0];
    for (int i = 1; i < n; i++) {
      dp[0][i] = Math.min(grid[0][i], dp[0][i-1]);
    }
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.min(grid[i][0], dp[i-1][0]);
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    grid = new int[n][n];
    dp = new int[n][n];
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dpInit();
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        /*위에서 내려오는 경우 dp[i-1][j] 와 grid[i][j]의 최솟값
        * 왼쪽에서 오는 경우 dp[i][j-1] 와 grid[i][j]의 최솟값 중 큰 값을 선택한다.*/
        dp[i][j] = Math.max(Math.min(grid[i][j], dp[i-1][j]), Math.min(grid[i][j], dp[i][j-1]));
      }
    }
    System.out.println(dp[n-1][n-1]);
  }
}
