package INTERMEDIATE_LOW.DP2.String_Matching;
//최장 공통 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1 {
    public static char[] A;
    public static char[] B;
    public static int[][] dp;
    public static int MAX_ANS = 1001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] tempA = br.readLine().toCharArray();
        char[] tempB = br.readLine().toCharArray();

        A = new char[tempA.length + 1];
        B = new char[tempB.length + 1];

        System.arraycopy(tempA, 0, A, 1, tempA.length);
        System.arraycopy(tempB, 0, B, 1, tempB.length);

        dp = new int[A.length][B.length];

        dpInit();

        for (int i = 2; i < A.length; i++) {
            for (int j = 2; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                if (A[i] != B[j]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[A.length-1][B.length-1]);
    }

    private static void dpInit() {
        dp[1][1] = A[1] == B[1] ? 1 : 0;

        for (int i = 2; i < B.length; i++) {
            dp[1][i] = A[1] == B[i] ? 1 : dp[1][i-1];
        }

        for (int j = 2; j < A.length; j++) {
            dp[j][1] = A[j] == B[1] ? 1 : dp[j-1][1];
        }
    }
}
