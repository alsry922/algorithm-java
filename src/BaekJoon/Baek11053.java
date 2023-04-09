package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11053 {
    public static int N; //수열의 길이
    public static int[] seq;
    public static int[] dp; // i인덱스를 마지막으로 하는 최대 증가 부분 수열의 길이
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

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    private static void dpInit() {

        for (int i = 0; i <= N; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        dp[0] = 0;
    }
}
