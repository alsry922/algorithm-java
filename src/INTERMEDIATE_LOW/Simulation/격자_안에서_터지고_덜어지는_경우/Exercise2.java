package INTERMEDIATE_LOW.Simulation.격자_안에서_터지고_덜어지는_경우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//십자 모양 폭발
public class Exercise2 {
    public static int N;
    public static int[][] grid;
    public static int[][] nextGrid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        nextGrid = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());

        int centerX = Integer.parseInt(st.nextToken()) - 1;
        int centerY = Integer.parseInt(st.nextToken()) - 1;

        bomb(centerX, centerY);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bomb(int centerX, int centerY) {
        int bombRange = grid[centerX][centerY];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (inBombRange(i, j, centerX, centerY, bombRange)) {
                    grid[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int nextRow = N - 1;
            for (int j = N - 1; j >= 0; j--) {
                if (grid[j][i] != 0) {
                    nextGrid[nextRow--][i] = grid[j][i];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = nextGrid[i][j];
            }
        }
    }

    private static boolean inBombRange(int x, int y, int centerX, int centerY, int bombRange) {
        return (x == centerX || y == centerY) &&
                (Math.abs(x - centerX) + Math.abs(y - centerY) < bombRange);
    }
}
