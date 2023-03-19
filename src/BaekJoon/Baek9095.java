package BaekJoon;
// 1,2,3 더하기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9095 {
  static int n;
  static int[] nums = new int[]{0,1,2,3};
  static int[] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine()); //    테스트 케이스
    while (t > 0) {
      n = Integer.parseInt(br.readLine()); //    목표 정수
      dp = new int[n+1];
      /*dp[i] = 정수가 i 일 때 1,2,3의 합으로 나타낼 수 있는 총 경우의 수*/
      /*dp 테이블 초기 조건*/
      dp[0] = 1;
      dp[1] = 1;
      /*dp 테이블 채우기*/
      for (int i = 2; i <= n; i++) {
        for (int j = 1; j <= 3; j++) {
          if (i >= nums[j]) {
            dp[i] = dp[i] + dp[i - nums[j]];
          }
        }
      }
      System.out.println(dp[n]);
      t--;
    }
  }
}
