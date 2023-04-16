package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정수 삼각형
public class Baek1932 {
    public static int N; //삼각형 크기
    public static int[][] triangle;
    public static int[][] dp; // i층, j위치까지 고려했을 때 선택된 수의 합이 최대인 경우
    public static int MIN = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        triangle = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dpInit();

        for (int i = 3; i <= N; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[N][i]);
        }

        System.out.println(max);

    }

    private static void dpInit() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = MIN;
            }
        }

        dp[1][1] = triangle[1][1];
        for (int i = 2; i <= N; i++) {
            dp[i][1] = dp[i - 1][1] + triangle[i][1];
        }

        for (int i = 2; i <= N; i++) {
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }
    }
}
