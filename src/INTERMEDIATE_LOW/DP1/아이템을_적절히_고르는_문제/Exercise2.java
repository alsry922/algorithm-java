package INTERMEDIATE_LOW.DP1.아이템을_적절히_고르는_문제;
//부분 수열의 합이 m

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2 {
    public static int N, M; //수열 길이, 부분 수열 목표 합
    public static int[] seq; //수열
    public static int[] dp;
    public static int MAX_ANS = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[N + 1];
        dp = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dpInit();

        for (int i = 1; i <= N; i++) {
            for (int j = M; j >= 1; j--) {
                if (j >= seq[i]) {
                    dp[j] = Math.min(dp[j], dp[j - seq[i]] + 1);
                }
            }
        }

        System.out.println(dp[M] == MAX_ANS ? -1 : dp[M]);
    }

    private static void dpInit() {
        for (int i = 1; i <= M; i++) {
            dp[i] = MAX_ANS;
        }
    }
}
