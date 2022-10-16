package DP1.조건에_맞게_선택적으로_전진하는_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2 {
  static final int MAX_NUMBER = 10000;
  static int n;
  static int[] nums;
  static int[] dp;
  public static void initialize() {
    for (int i = 1; i <= n; i++) {
      dp[i] = Integer.MIN_VALUE;
    }
    dp[0] = 0;
    nums[0] = MAX_NUMBER+1;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    nums = new int[n+1];
    dp = new int[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    initialize();
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] > nums[i]) {
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
    }
    int answer = 0;
    for (int i = 1; i <= n; i++) {
      answer = Math.max(answer, dp[i]);
    }
    System.out.println(answer);
  }
}
