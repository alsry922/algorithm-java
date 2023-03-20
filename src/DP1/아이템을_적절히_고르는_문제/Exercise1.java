package DP1.아이템을_적절히_고르는_문제;
// 동전 거슬러주기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1 {
    public static int N, M; //동전 종류, 금액
    public static int[] coins;
    public static int[] dp;

    public static int MAX_ANS = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        coins = new int[N + 1];
        dp = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        dpInit();

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (i >= coins[j] && dp[i-coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        System.out.println(dp[M] == 10001 ? -1 : dp[M]);
    }

    private static void dpInit() {
        for (int i = 1; i <= M; i++) {
            dp[i] = MAX_ANS;
        }
    }


}
