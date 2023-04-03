package INTERMEDIATE_LOW.Simulation.격자_안에서_밀고당기기;
// 1차원 바람

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3 {
    public static int N, M, Q; // 행, 열, 바람 횟수
    public static int[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        grid = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int targetRow = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            move(targetRow, direction);
            upCheck(targetRow, direction);
            downCheck(targetRow, direction);
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

    private static String getNextDirection(String direction) {
        return direction.equals("L") ? "R" : "L";
    }

    private static boolean isInRange(int x) {
        return x >= 1 && x <= N;
    }
    private static void downCheck(int currentRow, String direction) {
        if (!isInRange(currentRow + 1)) {
            return;
        }
        boolean doNext = false;
        for (int j = 1; j <= M; j++) {
            if (grid[currentRow][j] == grid[currentRow+1][j]) {
                doNext = true;
                break;
            }
        }
        if (doNext) {
            String nextDirection = getNextDirection(direction);
            move(currentRow + 1, nextDirection);
            downCheck(currentRow + 1, nextDirection);
        }
    }

    private static void upCheck(int currentRow, String direction) {
        if (!isInRange(currentRow - 1)) {
            return;
        }

        boolean doNext = false;

        for (int j = 1; j <= M; j++) {
            if (grid[currentRow][j] == grid[currentRow-1][j]) {
                doNext = true;
                break;
            }
        }
        if (doNext) {
            String nextDirection = getNextDirection(direction);
            move(currentRow-1, nextDirection);
            upCheck(currentRow - 1, nextDirection);
        }

    }
    private static void move(int currentRow, String direction) {
        if (direction.equals("L")) {
            int temp = grid[currentRow][M];
            for (int j = M; j >= 2; j--) {
                grid[currentRow][j] = grid[currentRow][j - 1];
            }
            grid[currentRow][1] = temp;
        } else {
            int temp = grid[currentRow][1];
            for (int j = 1; j < M; j++) {
                grid[currentRow][j] = grid[currentRow][j + 1];
            }
            grid[currentRow][M] = temp;
        }
    }
}
