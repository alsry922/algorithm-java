package DP2.원하는_State를_정의하여_한_칸씩_나아가는_DP;
// 둘 중 하나 잘 고르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1 {
    public static int N; //고를 카드 갯수
    public static int runCnt;
    public static int[] red;
    public static int[] blue;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        runCnt = 2 * N;
        dp = new int[runCnt + 1][N + 1];
        red = new int[runCnt + 1];
        blue = new int[runCnt + 1];

        for (int i = 1; i <= runCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            red[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
        }

        dpInit();

        for (int i = 1; i <= runCnt; i++) {
            for (int j = 0; j <= N; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + blue[i];
                } else if (i == j){
                    dp[i][j] = dp[i - 1][j - 1] + red[i];
                } else if (i > j) {
                    dp[i][j] = Math.max(dp[i - 1][j] + blue[i], dp[i - 1][j - 1] + red[i]);
                }
            }
        }

        System.out.println(dp[runCnt][N]);
    }

    private static void dpInit() {
        for (int i = 1; i <= runCnt; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
    }
}
