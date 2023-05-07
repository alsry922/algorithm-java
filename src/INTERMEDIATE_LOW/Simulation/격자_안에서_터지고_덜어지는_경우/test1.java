package INTERMEDIATE_LOW.Simulation.격자_안에서_터지고_덜어지는_경우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//최적의 십자 모양 폭발
public class test1 {
    public static final int WILL_EXPLODE = 0;
    public static final int BLANK = -1;
    public static int N; //격자 크기
    public static int[][] grid;
    public static int[][] tempGrid;
    public static int[][] nextGrid;
    public static int centerX, centerY;
    public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        tempGrid = new int[N][N];
        nextGrid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                centerX = i;
                centerY = j;
                simulate();
            }
        }
        System.out.println(answer);
    }

    private static void simulate() {
        initTempGrid();
        initNextGrid();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (inBombRange(i, j, grid[centerX][centerY])) {
                    tempGrid[i][j] = WILL_EXPLODE;
                }
            }
        }
        moveToNextFromTemp();
        answer = Math.max(answer, getPairs());
    }
    private static boolean inBombRange(int x, int y, int bomb) {
        return (x == centerX || y == centerY) &&
                (Math.abs(x - centerX) + Math.abs(y - centerY) < bomb);
    }

    private static void moveToNextFromTemp() {
        for (int column = 0; column < N; column++) {
            int nextRowIdx = N - 1;
            for (int row = N-1; row >= 0; row--) {
                if (tempGrid[row][column] != WILL_EXPLODE) {
                    nextGrid[nextRowIdx--][column] = tempGrid[row][column];
                }
            }
        }
    }

    private static int getPairs() {
        int count = 0;
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N-1; column++) {
                if (nextGrid[row][column] == BLANK) continue;

                if (nextGrid[row][column] == nextGrid[row][column+1]) {
                    count++;
                }
            }
        }
        for (int column = 0; column < N; column++) {
            for (int row = 0; row < N-1; row++) {
                if (nextGrid[row][column] == BLANK) continue;

                if (nextGrid[row][column] == nextGrid[row + 1][column]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void initNextGrid() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nextGrid[i][j] = BLANK;
            }
        }
    }


    private static void initTempGrid() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempGrid[i][j] = grid[i][j];
            }
        }
    }


}
