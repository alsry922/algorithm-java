package DP1.subproblem을_그대로_합치면_되는_DP;
// 피보나치 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1 {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];


        if (N <= 2) {
            System.out.println(1);
        } else {
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            System.out.println(dp[N]);
        }

    }
}
