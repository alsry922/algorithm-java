package INTERMEDIATE_LOW.DP2.연속적이지만_직전_상황에_영향을_받는_DP;
// 적절한 옷 고르기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//적절한 옷 고르기
public class Exercise1 {
    public static int N, M;
    public static int[][] clothes;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        clothes = new int[N + 1][4];
        dp = new int[M + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                clothes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dpInit();

        for (int i = 2; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (clothes[k][1] <= i - 1 && clothes[k][2] >= i - 1
                            && clothes[j][1] <= i && clothes[j][2] >= i) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + Math.abs(clothes[k][3] - clothes[j][3]));
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[M][i]);
        }

        System.out.println(answer);
    }

    private static void dpInit() {
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (clothes[i][1] == 1) {
                dp[1][i] = 0;
            }
        }

    }
}

