package Simulation.격자_안에서_완전탐색;
// 트로미노


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3 {
    public static int n, m; //grid size;
    public static int[][] grid;
    public static int[][] xL = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int[][] yL = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int[][] xStraight = {{-1, -2}, {0, 0}, {1, 2}, {0, 0}};
    public static int[][] yStraight = {{0, 0}, {1, 2}, {0, 0}, {-1, -2}};
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][m + 1];


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                bruteForce(i, j);
            }
        }
        System.out.println(answer);

    }

    private static void bruteForce(int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (canPutLShape(x, y, i)) {
                int result = grid[x][y];
                for (int j = 0; j < 2; j++) {
                    int nextX = x + xL[i][j];
                    int nextY = y + yL[i][j];
                    result += grid[nextX][nextY];
                }
                answer = Math.max(answer, result);
            }

            if (canPutStraightShape(x, y, i)) {
                int result = grid[x][y];
                for (int j = 0; j < 2; j++) {
                    int nextX = x + xStraight[i][j];
                    int nextY = y + yStraight[i][j];
                    result += grid[nextX][nextY];
                }
                answer = Math.max(answer, result);
            }
        }
    }

    private static boolean canPutStraightShape(int x, int y, int index) {
        for (int j = 0; j < 2; j++) {
            int nextX = x + xStraight[index][j];
            int nextY = y + yStraight[index][j];
            if (!isInRange(nextX, nextY)) {
                return false;
            }
        }
        return true;
    }

    private static boolean canPutLShape(int x, int y, int index) {
        for (int j = 0; j < 2; j++) {
            int nextX = x + xL[index][j];
            int nextY = y + yL[index][j];
            if (!isInRange(nextX, nextY)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= m;
    }
}
