package INTERMEDIATE_LOW.Simulation.격자_안에서_밀고당기기;
// 2차원 바람

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise4 {
    public static int N, M, Q; // 행, 열, 바람 횟수
    public static int[][] grid, temp;
    public static int r1, r2, c1, c2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        grid = new int[N + 1][M + 1];
        temp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int val = Integer.parseInt(st.nextToken());
                grid[i][j] = val;
                temp[i][j] = val;
            }
        }

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());

            moveClockwise(r1, c1, r2, c2);
            replaceAverageVal(r1, c1, r2, c2);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void replaceAverageVal(int r1, int c1, int r2, int c2) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int x = r1; x <= r2; x++) {
            for (int y = c1; y <= c2; y++) {
                int sum = grid[x][y];
                int count = 1;
                for (int i = 0; i < 4; i++) {
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];
                    if (isInRange(nextX, nextY)) {
                        sum += grid[nextX][nextY];
                        count++;
                    }
                }
                temp[x][y] = sum / count;
            }
        }

        for (int x = r1; x <= r2; x++) {
            for (int y = c1; y <= c2; y++) {
                grid[x][y] = temp[x][y];
            }
        }
    }

    private static boolean isInRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }

    private static void moveClockwise(int r1, int c1, int r2, int c2) {
        for (int i = r1, j = c2; j >= c1 + 1; j--) {
            temp[i][j] = grid[i][j - 1];
        }

        for (int i = r2, j = c2; i >= r1 + 1; i--) {
            temp[i][j] = grid[i - 1][j];
        }

        for (int i = r2, j = c1; j <= c2 - 1; j++) {
            temp[i][j] = grid[i][j + 1];
        }

        for (int i = r1, j = c1; i <= r2 - 1; i++) {
            temp[i][j] = grid[i + 1][j];
        }

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                grid[i][j] = temp[i][j];
            }
        }
    }
}
