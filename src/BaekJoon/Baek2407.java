package BaekJoon;
// 조합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baek2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger[][] combi = new BigInteger[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    combi[i][j] = BigInteger.ONE;
                } else {
                    combi[i][j] = combi[i - 1][j - 1].add(combi[i - 1][j]);
                }
            }
        }
        System.out.println(combi[n][m]);
    }
}
