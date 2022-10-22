package BaekJoon;

import java.io.*;

public class Beak11726 {
  static int n; // 2*n 크기 직사각형
  static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    /*dp[i]= 2*i 크기의 직사각형을 2*1, 1*2 타일로 채울 수 있는 경우의 수*/
    for (int i = 2; i <= n; i++) {
      dp[i] = (dp[i-1] + dp[i-2]) % 10007;
    }
    System.out.println(dp[n]);
  }
}
