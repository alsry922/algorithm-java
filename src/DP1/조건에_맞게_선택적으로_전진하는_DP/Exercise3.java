package DP1.조건에_맞게_선택적으로_전진하는_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3 {
  static int n;
  static int[] canJump;
  static int[] dp;
  public static void initialize() {
    for (int i = 0; i < n; i++) {
      dp[i] = Integer.MIN_VALUE;
    }
    dp[0] = 0;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    canJump = new int[n];
    dp = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      canJump[i] = Integer.parseInt(st.nextToken());
    }

    initialize();

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (j+canJump[j] >= i) {
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(dp[i], max);
    }
    System.out.println(max);
  }

}
