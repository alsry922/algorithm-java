package BaekJoon;

import java.io.*;
import java.util.*;

public class Baek1003 {
  static int t; // 테스트 케이스 갯수
  static int n; // 각 테스트 케이스
  static int MAX_N = 40;
  static int[][] dp = new int[MAX_N + 1][2];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());
    /*dp[i] = fibo(i)일때 각 fibo(0), fibo(1)의 호출 횟수*/
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[1][0] = 0;
    dp[1][1] = 1;

    while (t > 0) {
      n = Integer.parseInt(br.readLine());
      for (int i = 2; i <= n; i++) {
        dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
        dp[i][1] = dp[i - 1][1] + dp[i - 2][1];

      }
      System.out.println(String.format("%d %d", dp[n][0], dp[n][1]));
      t--;
    }
  }
}

