package DP1.조건에_맞게_선택적으로_전진하는_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Exercise1 {
  static int n;
  static int maxNum;
  static int[] nums;
  static int[] dp;
  static public void initialize() {
    for (int i = 1; i <= maxNum; i++) {
      dp[i] = Integer.MIN_VALUE;
    }
    nums[0] = 0;
    dp[0] = 0;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    nums = new int[n + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    int[] temp = Arrays.copyOf(nums, nums.length);
    Arrays.sort(temp);
    maxNum = temp[temp.length-1];
    dp = new int[maxNum+1];

    initialize();
    for (int i = 1; i <= n; i++) {
      int j = nums[i];
      for (int k = 0; k < j; k++) {
        if (dp[k] != Integer.MIN_VALUE) {
          dp[j] = Math.max(dp[k]+1, dp[j]);
        }
      }
    }
    int answer = 0;
    for (int i = 0; i <= maxNum; i++) {
      answer = Math.max(answer, dp[i]);
    }
    System.out.println(answer);
  }
}
