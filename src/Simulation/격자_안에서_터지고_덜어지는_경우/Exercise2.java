package Simulation.격자_안에서_터지고_덜어지는_경우;
//십자 모양 폭발

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2 {
    public static int N; //격자 크기
    public static int[][] grid;
    public static int[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken());
        grid = new int[N + 1][N + 1];
        temp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        crossBoom(r, c);

        grid = temp;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void crossBoom(int r, int c) {
        int bombRange = grid[r][c];

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                if (isInBombRange(x, y, r, c, bombRange)) {
                    grid[x][y] = 0;
                }
            }
        }

        for (int y = 1; y <= N; y++) {
            int tempRow = N;
            for (int x = N; x >= 1; x--) {
                if (grid[x][y] != 0) {
                    temp[tempRow--][y] = grid[x][y];
                }
            }
        }

    }

    private static boolean isInBombRange(int x, int y, int r, int c, int bombRange) {
        return (x == r || y == c) && (Math.abs(x - r) + Math.abs(y - c) < bombRange);
    }

}
