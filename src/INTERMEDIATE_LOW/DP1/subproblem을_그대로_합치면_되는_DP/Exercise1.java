package INTERMEDIATE_LOW.DP1.subproblem을_그대로_합치면_되는_DP;
// 피보나치 수

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise1 {
    public static int N;
    public static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];

        initMemo();
        fibo(N);

        bw.write(memo[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void initMemo() {
        for (int i = 0; i <= N; i++) {
            memo[i] = -1;
        }
    }

    public static int fibo(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return memo[n] = 1;
        }
        memo[n] = fibo(n - 1) + fibo(n - 2);

        return memo[n];
    }
}
