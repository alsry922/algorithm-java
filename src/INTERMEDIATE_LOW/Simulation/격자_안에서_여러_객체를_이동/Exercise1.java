package INTERMEDIATE_LOW.Simulation.격자_안에서_여러_객체를_이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1 {
    public static int n; //격자 크기
    public static int[][] grid; //격자
    public static int[][] count; //현재 구슬 위치
    public static int[][] nextCount; //다음 구슬 위치
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); //구슬 갯수
        int t = Integer.parseInt(st.nextToken()); //시간

        grid = new int[n + 1][n + 1];
        count = new int[n + 1][n + 1];
        nextCount = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            count[r][c] = 1;
        }

        while (t-- > 0) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (count[i][j] == 1) {
                        move(i, j);
                    }
                }
            }
            copyCount();
            removeDuplicateMarble();
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (count[i][j] == 1) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static void move(int r, int c) {
        int max = 0;
        int nextRow = 0;
        int nextColumn = 0;
        for (int i = 0; i < 4; i++) {
            int nextTempRow = r + dx[i];
            int nextTempColumn = c + dy[i];
            if (isInRange(nextTempRow, nextTempColumn) && max < grid[nextTempRow][nextTempColumn]) {
                max = grid[nextTempRow][nextTempColumn];
                nextRow = nextTempRow;
                nextColumn = nextTempColumn;
            }
        }
        nextCount[nextRow][nextColumn]++;
    }

    public static boolean isInRange(int row, int column) {
        return row >= 1 && row <= n && column >= 1 && column <= n;
    }

    public static void copyCount() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                count[i][j] = nextCount[i][j];
                nextCount[i][j] = 0;
            }
        }
    }

    public static void removeDuplicateMarble() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (count[i][j] > 1) {
                    count[i][j] = 0;
                }
            }
        }
    }
}
