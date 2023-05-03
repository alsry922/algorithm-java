package INTERMEDIATE_LOW.Simulation.격자_안에서_터지고_덜어지는_경우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//십자 모양의 지속적 폭발
public class Exercise5 {
    public static int NONE = -1;
    public static int N, M; //grid size, repeat
    public static int[][] grid;
    public static int[][] nextGrid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        nextGrid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            int column = Integer.parseInt(br.readLine())-1;
            int row = getRowOfExplosion(column);
            if (row == NONE) {
                continue;
            }
            explosion(row, column);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // row, column을 중심으로 폭발 범위까지 폭발시키기
    private static void explosion(int row, int column) {
        int bombLength = grid[row][column];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (inBombRange(i, j, row, column, bombLength)) {
                    grid[i][j] = 0;
                }
            }
        }

        moveToNextGrid();
        copy();
    }

    // nextGrid 값을 grid로 옮긴다.
    private static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = nextGrid[i][j];
            }
        }
    }

    // 폭발 후 상태를 nextGrid로 옮긴다. 0값을 무시하고 당김
    private static void moveToNextGrid() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nextGrid[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            int nextRow = N - 1;
            for (int j = N-1; j >= 0; j--) {
                if (grid[j][i] != 0) {
                    nextGrid[nextRow--][i] = grid[j][i];
                }
            }
        }
    }

    // 폭발 중심 위치의 열 혹은 행 중에 하나와 같아야하며
    // 폭발 중심 위치에서 현재 위치의 거리는 폭발위치보다 무조건 1이상 작다.
    private static boolean inBombRange(int x, int y, int cr, int cc, int bombLength) {
        return (x == cr || y == cc) &&
                (Math.abs(x - cr) + Math.abs(y - cc) < bombLength);
    }

    private static int getRowOfExplosion(int column) {
        int row = NONE;
        for (int i = 0; i < N; i++) {
            if (grid[i][column] != 0) {
                row = i;
                break;
            }
        }
        return row;
    }
}
