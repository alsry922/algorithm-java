package DP2.진행하다_끊기고_또_진행하다_끊기는_DP;
//연속 부분 합의 최댓값 구하기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1 {
    public static int N; //수열 길이
    public static int[] seq;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        seq = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dpInit();

        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + seq[i], seq[i]);
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    private static void dpInit() {
        for (int i = 0; i <= N; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[1] = seq[1];
    }
}
