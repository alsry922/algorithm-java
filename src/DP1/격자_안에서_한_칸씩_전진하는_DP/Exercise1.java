package DP1.격자_안에서_한_칸씩_전진하는_DP;
//정수 사각형 최대 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1 {
    public static int N; //격자 크기
    public static int[][] grid; //격자
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initializeDP();
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        System.out.println(dp[N][N]);
    }

    private static void initializeDP() {
        dp[1][1] = grid[1][1];
        for (int i = 1; i <= N; i++) {
            dp[1][i] = dp[1][i - 1] + grid[1][i];
            dp[i][1] = dp[i - 1][1] + grid[i][1];
        }
    }
}
