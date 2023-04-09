package BaekJoon;
// RGB거리
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1149 {
    public static int N; //집의 수
    public static int[][] cost; //각 집을 칠하는 비용
    public static int[][] dp; // i번째 집을 j색으로 칠할 때 최소의 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][3];
        dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dpInit();

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + cost[i][j]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, dp[N][i]);
        }
        System.out.println(answer);
    }

    private static void dpInit() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];
    }
}
