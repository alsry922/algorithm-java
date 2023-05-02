package INTERMEDIATE_LOW.Simulation.격자_안에서_터지고_덜어지는_경우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//단 한번의 2048시도
public class Exercise4 {
    public static final int ASCII_NUM = 128;
    public static final int NONE = -1;
    public static final int GRID_SIZE = 4;
    public static int[][] grid = new int[GRID_SIZE][GRID_SIZE];
    public static int[][] nextGrid = new int[GRID_SIZE][GRID_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < GRID_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dirMapper = new int[ASCII_NUM];
        dirMapper['D'] = 0;
        dirMapper['R'] = 1;
        dirMapper['U'] = 2;
        dirMapper['L'] = 3;
        int dir = br.readLine().charAt(0);

        tilt(dirMapper[dir]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb   );
    }

    private static void tilt(int dir) {
        // 아래로 떨어지도록 돌리기
        for (int i = 0; i < dir; i++) {
            rotate();
        }

        drop();

        // 원래방향으로 돌리기
        for (int i = 0; i < 4 - dir; i++) {
            rotate();
        }
    }

    private static void drop() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                nextGrid[i][j] = 0;
            }
        }

        for (int i = 0; i < GRID_SIZE; i++) {
            int nextRow = GRID_SIZE - 1;
            int keepNum = NONE; // 최근 관찰한 숫자
            for (int j = GRID_SIZE - 1; j >= 0; j--) {
                if (grid[j][i] == 0) continue;

                if (keepNum == NONE) {
                    keepNum = grid[j][i]; // 관찰 숫자 갱신
                } else if (keepNum == grid[j][i]) {
                    nextGrid[nextRow--][i] = grid[j][i] * 2;
                    keepNum = NONE;
                } else {
                    nextGrid[nextRow--][i] = keepNum; // 떨어뜨리고
                    keepNum = grid[j][i]; // 최근 관찰 숫자 갱신
                }
            }
            // 떨어뜨리는 작업이 끝났는데도
            // 최근 관찰한 숫자가 남았다면 마저 떨어뜨린다.
            if(keepNum != NONE) {
                nextGrid[nextRow--][i] = keepNum;
            }
        }

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = nextGrid[i][j];
            }
        }
    }

    private static void rotate() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                nextGrid[i][j] = 0;
            }
        }
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                nextGrid[i][j] = grid[GRID_SIZE - j - 1][i];
            }
        }

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = nextGrid[i][j];
            }
        }
    }
}
