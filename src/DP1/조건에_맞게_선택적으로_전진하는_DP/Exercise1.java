package DP1.조건에_맞게_선택적으로_전진하는_DP;
//최대 증가 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1 {
    public static int N; //수열 길이
    public static int[] seq; // 수열
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N + 1];
        dp = new int[N + 1];

        initializeDP();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        findMaxSubSequence();

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    private static void findMaxSubSequence() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
    }

    private static void initializeDP() {
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[1] = 1;
    }
}
